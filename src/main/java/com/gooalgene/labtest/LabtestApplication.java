package com.gooalgene.labtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gooalgene.labtest.dao")
@SpringBootApplication
public class LabtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabtestApplication.class, args);
	}

}
