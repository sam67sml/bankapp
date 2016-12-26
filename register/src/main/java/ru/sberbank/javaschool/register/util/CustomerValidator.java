package ru.sberbank.javaschool.register.util;

import org.apache.log4j.Logger;
import ru.sberbank.javaschool.core.entity.Customer;
import ru.sberbank.javaschool.core.util.Validator;

import java.util.Objects;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
public class CustomerValidator implements Validator<Customer> {

    private static final Logger LOGGER = Logger.getLogger(CustomerValidator.class);

    @Override
    public boolean validate(Customer customer) {
        Objects.requireNonNull(customer);

        if (null == customer.getEmail()) {
            LOGGER.trace("Customer validator: email can't be NULL");
            return false;
        }

        if (null == customer.getFirstName()) {
            LOGGER.trace("Customer validator: firstName can't be NULL");
            return false;
        }
        if (null == customer.getLastName()) {
            LOGGER.trace("Customer validator: lastName can't be NULL");
            return false;
        }
        if (null == customer.getPhoneNumber()) {
            LOGGER.trace("Customer validator: phoneNumber can't be NULL");
            return false;
        }
        if (null == customer.getRoles()) {
            LOGGER.trace("Customer validator: roles can't be NULL");
            return false;
        }

        return true;
    }
}
