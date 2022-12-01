package com.br.fsc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
/*http://localhost:8080/book/?mediaType=xmlyoutube
 * 
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {		
	// caminho para testar implementação via url http://localhost:8080/book/?mediaType=xml	
		configurer.favorParameter(true)
		.parameterName("mediaType").ignoreAcceptHeader(true)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
	}*/
	/*
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {		
	// implementação via header no reader do postmam acrescentar Accept(application/xml)
		//http://localhost:8080/book/
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
	}*/
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {		
		// implementação via header no reader do postmam acrescentar Accept(application/xml)
		//http://localhost:8080/book/
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
	}

}
