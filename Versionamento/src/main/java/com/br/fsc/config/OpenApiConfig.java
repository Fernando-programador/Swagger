package com.br.fsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	//http://localhost:8080/swagger-ui/index.html
	//http://localhost:8080/v3/api-docs
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Rest Fuul API JAva 17 Spring boot 3")
						.version("v1")
						.description("Minha descrição da APi")
						.termsOfService("\"https:\\\\ajeitandoseulado.com.br\"")
						.license(new License().name("Apache 2.0")
								.url("https:\\ajeitandoseulado.com.br")));
		
	}
}
