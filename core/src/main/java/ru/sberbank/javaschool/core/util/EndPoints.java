package ru.sberbank.javaschool.core.util;

/**
 * JavaSchool SBT
 * Created by Sam on 25.12.2016.
 */
public enum EndPoints {
    ACCOUNT_CREATE("");



    private final String endpointUrl;

    EndPoints(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }
}
