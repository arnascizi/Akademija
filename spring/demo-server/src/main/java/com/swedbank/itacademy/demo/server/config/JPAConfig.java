package com.swedbank.itacademy.demo.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.swedbank.itacademy.demo.server.person",
        "com.swedbank.itacademy.demo.server.group"})
public class JPAConfig {
}
