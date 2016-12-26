package ru.sberbank.javaschool.core.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * JavaSchool SBT
 * Created by Sam on 10.12.2016.
 */
public class PasswordSecurity {

    PasswordSecurity() {
    }

    public static String getPasswordHex(String password) {
        if (password == null) {
            throw new NullPointerException();
        }
        return String.valueOf(DigestUtils.shaHex(password));
    }

    public static boolean verifyPassword(String enteredPassword, String expectedPassword) {
        if (enteredPassword == null || expectedPassword == null) {
            throw new NullPointerException();
        }
        return getPasswordHex(enteredPassword).equals(expectedPassword);
    }
}
