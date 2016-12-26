package ru.sberbank.javaschool.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import ru.sberbank.javaschool.core.config.DatabaseConfig;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@Configuration
@Import(DatabaseConfig.class)
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter {

}
