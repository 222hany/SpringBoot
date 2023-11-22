package com.kh.springdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kh.springdb.mapper")
public class SpringDbOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbOracleApplication.class, args);
	}

}