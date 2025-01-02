package com.example.CourseService.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
	private final String characterServiceURL;
	private final String universityServiceURL;

	public GatewayApplication(
		@Value("${game.course-service.url}") String characterURL,
		@Value("${game.university-service.url}") String universityURL
	){
		this.characterServiceURL = characterURL;
		this.universityServiceURL = universityURL;
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator router(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("universities", route -> route
				.path("/api/universities", "/api/universities/{uuid}")
				.uri(universityServiceURL)
			)
			.route("courses", route -> route
				.path("/api/courses", "/api/courses/{uuid}", "/api/universities/{uuid}/courses")
				.uri(characterServiceURL)
			)
			.build();
	}
}
