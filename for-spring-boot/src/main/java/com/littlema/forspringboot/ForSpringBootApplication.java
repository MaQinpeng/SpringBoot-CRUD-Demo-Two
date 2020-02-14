package com.littlema.forspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.littlema.forspringboot.Mapper")
public class ForSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForSpringBootApplication.class, args);
	}

}
