package com.comcast.lcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.comcast.lcs.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfoMetaData());
    }

    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("API Documentation for comcast")
                .description("The purpose of the API to find the \"longestCommonSubstring\" is to provide a service that allows users or client applications to find the longest common substring among a set of strings. The API is designed to take a set of strings as input and return the longest common substring that exists in all the strings within the set.")
                .license("Vejju")
                .licenseUrl("http://vejjus.blogspot.com")
                .version("1.0")
                .build();
    }
}