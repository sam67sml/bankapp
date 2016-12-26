package ru.sberbank.javaschool.register.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.sberbank.javaschool.core.entity.Customer;
import ru.sberbank.javaschool.core.entity.Role;
import ru.sberbank.javaschool.core.entity.RoleNames;
import ru.sberbank.javaschool.core.service.CustomerService;

import java.util.Arrays;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestAppConfig.class, loader = AnnotationConfigContextLoader.class)
public class CustomerServiceImplTest {


   @Autowired
   CustomerService customerService;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getCustomerByEmail() throws Exception {
        Customer customer  = getCustomer();
        customerService.createCustomer(customer);
        Customer result = customerService.getCustomerByEmail("1@mail.ru");
        Assert.assertEquals(customer.getFirstName(), result.getFirstName());
    }

    @Test
    public void createCustomer() throws Exception {
        Customer customer = getCustomer();

        Customer result = customerService.createCustomer(customer);
        Assert.assertEquals(customer.getEmail(), result.getEmail());
    }

    private Customer getCustomer() {
        Customer customer = new Customer();

        customer.setFirstName("Sam");
        customer.setLastName("Savchenkov");
        customer.setEmail("1@mail.ru");
        customer.setPassword("password");
        customer.setPhoneNumber("123456");
        Role role = new Role();
        role.setRoleName(RoleNames.USER.toString());
        customer.setRoles(Arrays.asList(role));
        return customer;
    }

    @Test
    public void getAllCustomers() throws Exception {
    }

}