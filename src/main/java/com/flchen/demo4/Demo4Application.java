package com.flchen.demo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync //开启异步支持，使方法上的注解@Async生效
//@EnableScheduling //支持@Scheduled注解，开启计划任务
public class Demo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(10);
		return taskScheduler;
	}
}
