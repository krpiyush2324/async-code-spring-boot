package com.async;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AsyncApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("start of application runner");
		System.out.println("application runner added");
		System.out.println("start of application runner");
	}
}
