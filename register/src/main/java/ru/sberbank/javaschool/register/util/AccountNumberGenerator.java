package ru.sberbank.javaschool.register.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
public class AccountNumberGenerator {
    public static Long generate(){
        return ThreadLocalRandom.current().nextLong(1000000L, 10000000L);
    }
}
