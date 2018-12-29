package com.cfh.demo.common.lang.configuration;

import org.springframework.beans.factory.annotation.Value;
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


/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 10:48
 * @description: Swagger的配置
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Value("${swagger.basePackage}")
	private String basePackage;

	@Value("${swagger.title}")
	private String title;

	@Value("${swagger.contactName}")
	private String contactName;

	@Value("${swagger.contactUrl}")
	private String contactUrl;

	@Value("${swagger.contactEmail}")
	private String contactEmail;

	@Value("${swagger.description}")
	private String description;

	@Value("${swagger.version}")
	private String version;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.contact(new Contact(contactName, contactUrl, contactEmail))
				.description(description)
				.version(version)
				.build();
	}

}
