package ru.sberbank.javaschool.register.util.exceptions;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
public class AccountException extends RuntimeException {
    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
