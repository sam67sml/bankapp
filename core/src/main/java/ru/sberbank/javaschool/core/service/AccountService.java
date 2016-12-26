package ru.sberbank.javaschool.core.service;

import ru.sberbank.javaschool.core.entity.Account;
import ru.sberbank.javaschool.core.entity.Customer;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
public interface AccountService {
    Account create(Customer customer);
    Account findByCustomerId(Long id);
}
