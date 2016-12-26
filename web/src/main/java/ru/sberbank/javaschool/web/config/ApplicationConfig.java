package ru.sberbank.javaschool.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.sberbank.javaschool.web.Application;

/**
 * JavaSchool SBT
 * Created by Sam on 23.12.2016.
 */
@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
