package ru.sberbank.javaschool.register.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ru.sberbank.javaschool.core.entity.Customer;
import ru.sberbank.javaschool.core.repository.CustomerDao;
import ru.sberbank.javaschool.core.service.CustomerService;
import ru.sberbank.javaschool.register.util.CustomerValidator;
import ru.sberbank.javaschool.register.util.exceptions.CustomerException;

import java.util.Collections;
import java.util.List;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final PlatformTransactionManager platformTransactionManager;


    private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
    private final CustomerValidator validator = new CustomerValidator();

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, PlatformTransactionManager platformTransactionManager) {
        this.customerDao = customerDao;
        this.platformTransactionManager = platformTransactionManager;
    }

    @Override
    @Transactional
    public Customer getCustomerByEmail(String email) {

        final TransactionTemplate transaction = new TransactionTemplate(platformTransactionManager);
        return transaction.execute(status -> customerDao.findCustomerByEmail(email));
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        if (!validator.validate(customer)) {
            LOGGER.trace("CustomerServiceImpl: Customer validation fails");
            throw new CustomerException();
        }
        final TransactionTemplate transaction = new TransactionTemplate(platformTransactionManager);
        customer.setId(0L);

        return transaction.execute(status -> customerDao.save(customer));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return Collections.emptyList();

    }
}
