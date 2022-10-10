package br.com.residencia.cinema.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("/cinema/src/main/java/br/com/residencia/cinema/controller/DiretorController.java"))
				.paths(regex("/diretor"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
			
			ApiInfo apiInfo = new ApiInfo(
				"cinema API REST", 
				"API para CRUD basico de cinema",
				"1.0.0",
				"termo e serviços",
				new Contact("Grupo 6", "www.grupo6.com", "grupo6@gmail.com"),
				"Apache License version 2.0",
				"https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
			);
	
			return apiInfo;
	}
}