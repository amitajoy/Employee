package com.test;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.test.greeting.GreetingController.GREETING_RESOURCE;
import static com.test.employee.EmployeeController.EMPLOYEES_RESOURCE;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket employeeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("employeeApi")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test"))
                .paths(regex(EMPLOYEES_RESOURCE+".*"))
                .build()
                .apiInfo(metaData());
    }
    @Bean
    public Docket greetingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetingApi")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.greeting"))
                .paths(regex(GREETING_RESOURCE+".*"))
                .build();
                //.apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Employee",
                "1.0",
                "Terms of service",
                new Contact("Amit Agrawal", "https://temp/about/", "a@b.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
