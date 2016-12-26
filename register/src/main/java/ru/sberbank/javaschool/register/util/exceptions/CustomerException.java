package ru.sberbank.javaschool.register.util.exceptions;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
public class CustomerException extends RuntimeException {

    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}
