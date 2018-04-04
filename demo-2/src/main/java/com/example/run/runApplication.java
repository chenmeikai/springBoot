package com.example.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableTransactionManagement
@EnableScheduling
@MapperScan("com.**.mapper")
@EnableAsync
@EnableAspectJAutoProxy
public class runApplication {

	public static void main(String[] args) {
		SpringApplication.run(runApplication.class, args);
	}
}
