package ru.sberbank.javaschool.register.service;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.sberbank.javaschool.core.entity.Customer;
import ru.sberbank.javaschool.core.repository.AccountDao;
import ru.sberbank.javaschool.core.repository.CustomerDao;
import ru.sberbank.javaschool.core.repository.Marker;
import ru.sberbank.javaschool.core.service.AccountService;
import ru.sberbank.javaschool.core.service.CustomerService;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = Marker.class)
@EnableTransactionManagement
public class TestAppConfig {

    @Bean
    CustomerService getCustomerService(CustomerDao customerDao, PlatformTransactionManager platformTransactionManager) {
        return new CustomerServiceImpl(customerDao, platformTransactionManager);
    }

    @Bean
    AccountService getAccountService(AccountDao accountDao, PlatformTransactionManager platformTransactionManager) {
        return new AccountServiceImpl(accountDao, platformTransactionManager);
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl("jdbc:h2:mem:dbTest;DB_CLOSE_DELAY=-1");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("log4j.logger.org.hibernate.type", "trace");
        return properties;
    }
    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource,
                                                     JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(Customer.class.getPackage().getName());
        factory.setDataSource(dataSource);
        factory.setJpaProperties(jpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
            throws PropertyVetoException {
        return new JpaTransactionManager(emf);
    }
}
