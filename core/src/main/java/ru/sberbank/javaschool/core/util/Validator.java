package ru.sberbank.javaschool.core.util;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@FunctionalInterface
public interface Validator<T> {
    boolean validate(T t);
}
