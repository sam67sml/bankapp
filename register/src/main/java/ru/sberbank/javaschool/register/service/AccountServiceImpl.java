package ru.sberbank.javaschool.register.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ru.sberbank.javaschool.core.entity.*;
import ru.sberbank.javaschool.core.repository.AccountDao;
import ru.sberbank.javaschool.core.repository.AccountInfoDao;
import ru.sberbank.javaschool.core.service.AccountService;
import ru.sberbank.javaschool.core.util.converter.LocalDateTimeToTimestampConverter;
import ru.sberbank.javaschool.register.util.AccountNumberGenerator;
import ru.sberbank.javaschool.register.util.CustomerValidator;
import ru.sberbank.javaschool.register.util.exceptions.AccountException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountInfoDao accountInfoDao;

    private final AccountDao accountDao;
    private final PlatformTransactionManager platformTransactionManager;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao, PlatformTransactionManager platformTransactionManager) {
        this.accountDao = accountDao;
        this.platformTransactionManager = platformTransactionManager;
    }


    private LocalDateTimeToTimestampConverter converter = new LocalDateTimeToTimestampConverter();

    private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);
    private final CustomerValidator validator = new CustomerValidator();


    @Transactional
    @Override
    public Account create(Customer customer) {
        if (Objects.isNull(customer)) {
            LOGGER.trace("AccountServiceImpl: Customer can't be NULL");
            throw new AccountException();
        }
        if (!validator.validate(customer)) {
            LOGGER.trace("AccountServiceImpl: Customer validation fails");
            throw new AccountException();
        }
        Account account = new Account();
        account.setCustomer(customer);
        account.setRegisterDate(converter.convertToDatabaseColumn(LocalDateTime.now()));
        account.setAccNumber(AccountNumberGenerator.generate());
        account.setAccountInfo(getAccountInfo());

        final TransactionTemplate transaction = new TransactionTemplate(platformTransactionManager);
        return transaction.execute(status -> accountDao.save(account));

    }

    private AccountInfo getAccountInfo() {
        final TransactionTemplate transaction = new TransactionTemplate(platformTransactionManager);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setBalance(new BigDecimal(0));
        Currency currency = new Currency();
        currency.setCurrencyName("RUB");
        accountInfo.setCurrency(currency);
        transaction.execute(status -> accountInfoDao.save(accountInfo));
        return accountInfo;
    }

    @Transactional
    @Override
    public Account findByCustomerId(Long id) {
        final TransactionTemplate transaction = new TransactionTemplate(platformTransactionManager);
        return transaction.execute(status -> accountDao.findByCustomerId(id));
    }
}
