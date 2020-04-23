package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement 
//(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages= {"com.example.demo.*"})
public class SpringbootJpaPostgresPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaPostgresPocApplication.class, args);
	}

}
