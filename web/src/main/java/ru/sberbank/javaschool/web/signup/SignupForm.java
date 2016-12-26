package ru.sberbank.javaschool.web.signup;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import ru.sberbank.javaschool.core.entity.Account;
import ru.sberbank.javaschool.core.entity.Card;
import ru.sberbank.javaschool.core.entity.Customer;

import java.sql.Timestamp;
import java.util.Random;
import java.util.Set;

public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";
	private static final String EMAIL_EXISTS_MESSAGE = "{email-exists.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	@Email(message = SignupForm.EMAIL_MESSAGE)
	@EmailExists(message = SignupForm.EMAIL_EXISTS_MESSAGE)
	private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String password;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account createAccount(Customer customer, Set<Card> cards) {
		Random random = new Random(System.currentTimeMillis());
        Account account = new Account();
        account.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        account.setCustomer(customer);
        account.setAccNumber(1000000L + random.nextInt(999999));
        account.setCards(cards);
    	return account;
	}
}
