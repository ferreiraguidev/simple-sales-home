package com.business.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.business.customeregistration.model")
@ComponentScan(basePackages = {"com.business.simple.*"})
@EnableJpaRepositories(basePackages = {"com.business.simple.repository"})
@EnableTransactionManagement
public class CustomeregistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomeregistrationApplication.class, args);
    }

}
