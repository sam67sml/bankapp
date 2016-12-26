package ru.sberbank.javaschool.core.service;

import ru.sberbank.javaschool.core.entity.Customer;

import java.util.List;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
public interface CustomerService {
    Customer getCustomerByEmail(String email);
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
