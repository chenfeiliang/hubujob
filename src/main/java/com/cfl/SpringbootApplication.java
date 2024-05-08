package com.cfl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cfl.mappers")
public class SpringbootApplication {

	public static void main(String[] args) {

	    SpringApplication.run(SpringbootApplication.class, args);
	}
}
