package com.fullstack.abrarzahin.angularspring.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories("com.fullstack.abrarzahin.angularspring.repository")
@EnableTransactionManagement
@EnableWebMvc
@EnableSpringDataWebSupport
public class DatabaseConfig {

}
