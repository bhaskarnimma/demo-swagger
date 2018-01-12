package com.bhaskar.sample.demoswagger.config;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Profile("swagger")
public class SwaggerConfig {
	private static final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

	@Bean
	public Docket postsApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.groupName("esign-api").
				apiInfo(apiInfo()).
				select().
				paths(PathSelectors.ant("/api/**")).
				build();

		docket.globalResponseMessage(RequestMethod.GET,
				ImmutableList.of(
						new ResponseMessageBuilder().code(400).message("Bad Request")
								.responseModel(new ModelRef("Error")).build(),
						new ResponseMessageBuilder().code(500).message("Internal Server Error")
								.responseModel(new ModelRef("Error")).build()));

		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ESign Document Retrieval").description("ESign Document Retrieval API reference for developers")
				.termsOfServiceUrl("http://t-mobile.com")
				.licenseUrl("t-mobile@gmail.com").version("1.0").build();
	}



}