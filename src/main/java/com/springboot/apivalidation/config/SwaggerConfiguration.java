package com.springboot.apivalidation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);

    /*Configuring what is considered for API documentation in swagger*/
    //@Bean
    public Docket swaggerConfiguration() {
        logger.info("Configuring swagger from main app");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**")) //URLs starting with this patterns
                .apis(RequestHandlerSelectors.basePackage("com.springboot.apivalidation")) //scan only this package for documentation inclusion
                .build();
    }
}
