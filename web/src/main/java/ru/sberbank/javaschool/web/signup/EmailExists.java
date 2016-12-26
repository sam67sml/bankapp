package ru.sberbank.javaschool.web.signup;

import org.springframework.stereotype.Component;
import ru.sberbank.javaschool.core.repository.AccountDao;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailExistsValidator.class)
@Documented
public @interface EmailExists {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

@Component
class EmailExistsValidator implements ConstraintValidator<EmailExists, Long> {

    private final AccountDao accountDao;

    public EmailExistsValidator(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public void initialize(EmailExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return !accountDao.exists(id);
    }
}
