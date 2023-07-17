package com.comcast.lcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:error.properties")
})										
public class ComcastlcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComcastlcsApplication.class, args);
	}

}
