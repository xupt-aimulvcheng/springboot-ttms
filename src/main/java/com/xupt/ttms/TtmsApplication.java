package com.xupt.ttms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.xupt.ttms.mapper")
@EnableCaching
public class TtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtmsApplication.class, args);
	}

}
