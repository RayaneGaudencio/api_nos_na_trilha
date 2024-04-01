package com.api.nos_na_trilha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class NosNaTrilhaApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(NosNaTrilhaApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowedMethods("*")
				.exposedHeaders("*");

//		WebMvcConfigurer.super.addCorsMappings(registry);
	}
}
