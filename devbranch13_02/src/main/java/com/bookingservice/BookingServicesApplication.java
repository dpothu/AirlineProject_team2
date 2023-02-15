package com.bookingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class BookingServicesApplication {

	Logger logger = LoggerFactory.getLogger(BookingServicesApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookingServicesApplication.class, args);
	}
	
	
	@Bean
	public Docket api() {
		logger.trace("Swagger Accessed");
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bookingservice.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiEndPointInfo());
	}

	private ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder()
				.title("Booking Service API's")
				.description("The Booking Micro Services for BrownField AirLines")
				.version("version - 0.0.1-SNAPSHOT")
				.license("Developed By TEJA(ProfessorKTS)")
				.licenseUrl("https://teja-professorkts.netlify.app/")
				.contact(new Contact("Booking Service Dev Team", "https://teja-professorkts.netlify.app/", "kambham.teja@capgemini.com"))
				.build();
	}

}
