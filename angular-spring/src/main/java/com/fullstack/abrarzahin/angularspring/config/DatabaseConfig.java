package com.fullstack.abrarzahin.angularspring.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.fullstack.abrarzahin.angularspring.repository" )
@EnableTransactionManagement
public class DatabaseConfig {

}
