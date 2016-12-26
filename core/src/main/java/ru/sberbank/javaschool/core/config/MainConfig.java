package ru.sberbank.javaschool.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@Configuration
@Import(DatabaseConfig.class)
public class MainConfig {

}
