package ru.sberbank.javaschool.register.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.sberbank.javaschool.core.service.AccountService;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestAppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AccountServiceImplTest {

    @Autowired
    AccountService accountService;

    @Test
    public void create() throws Exception {

    }

    @Test
    public void findByCustomerId() throws Exception {
    }

}