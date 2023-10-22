package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class RestJpaMysqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestJpaMysqlDemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.example.rest.controller"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData(){
		return new ApiInfo(
				"Cloud Vendor Api Application",
				"Cloud Vendor Documentation",
				"1.0",
				"Cloud Vendor Service terms",
				new Contact("Ahmed", "http://test.com", "test@gmail.com"),
				"zerzif licence",
				"http://test.com",
				Collections.emptyList()
		);
	}

}
