package ru.galeev.springcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SpringcourseRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcourseRestClientApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
