package com.bookingservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BookingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServicesApplication.class, args);
	}
	
	
//	@Bean
//	public Docket api() {
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.any())
//				.apis(RequestHandlerSelectors.basePackage("com.bookingservice"))
//				.build()
//				.apiInfo(apiEndPointInfo());
////				.securitySchemes(Collections.singletonList(authenticationScheme))
////				//.securitySchemes(securitySchemes())
////				.securityContexts(List.of(securityContext()));
//	}
//	
//	private ApiInfo apiEndPointInfo() {
//		return ApiInfo(
//				"Booking Service API's",
//				"this is for flight boooking",
//				"version - 0.0.1-SNAPSHOT",
//				"Developed By TEJA",
//				"Booking Service", "www.bookingService.com", "tejakambham5@gmail.com",
//				"API Lisence",
//				"www.bookingService.com"
//				);
//	}
//
//
//	private ApiInfo ApiInfo(String string, String string2, String string3, String string4, String string5,
//			String string6, String string7, String string8, String string9) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
