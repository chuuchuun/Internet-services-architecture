package com.example.UniversityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UniversityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityServiceApplication.class, args);
	}

	@Bean
	@Qualifier("course-service")
	public RestTemplate universityServiceRestTemplate(
		@Value("${game.course-service.url}") String professionServiceUrl
	) {
		return new RestTemplateBuilder()
				.rootUri(professionServiceUrl)
				.build();
	}

}
