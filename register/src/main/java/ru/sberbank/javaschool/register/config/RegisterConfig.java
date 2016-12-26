package ru.sberbank.javaschool.register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import ru.sberbank.javaschool.core.config.DatabaseConfig;
import ru.sberbank.javaschool.core.repository.CustomerDao;
import ru.sberbank.javaschool.core.service.CustomerService;
import ru.sberbank.javaschool.register.service.CustomerServiceImpl;

/**
 * JavaSchool SBT
 * Created by Sam on 25.12.2016.
 */
@Configuration
@Import(DatabaseConfig.class)
public class RegisterConfig {
    @Bean
    CustomerService customerService(CustomerDao customerDao, PlatformTransactionManager transactionManager) {
        return new CustomerServiceImpl(customerDao, transactionManager);
    }

}
