package org.qianrenxi.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SystemSwaggerUIConfig {
	
	@Bean("systemSwaggerUIConfig_Docket")
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("PMS REST API")
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.qianrenxi"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("PMS REST API")
				.description("API文档")
				.license("")
				.licenseUrl("http://unlicense.org")
				.termsOfServiceUrl("")
				.version("1.0.0")
				.contact(new Contact("Tony Een", "", ""))
				.build();
	}
}
