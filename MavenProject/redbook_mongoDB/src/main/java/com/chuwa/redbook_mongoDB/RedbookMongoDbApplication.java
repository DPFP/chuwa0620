package com.chuwa.redbook_mongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RedbookMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedbookMongoDbApplication.class, args);
	}

}
