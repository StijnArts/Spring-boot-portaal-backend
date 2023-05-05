package com.slager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.*;
import org.springframework.transaction.annotation.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringSlagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSlagerApplication.class, args);
	}

}
