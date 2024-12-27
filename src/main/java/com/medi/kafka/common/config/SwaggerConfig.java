package com.medi.kafka.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(security = {@SecurityRequirement(name = "bearerAuth")})
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class SwaggerConfig {

    @Value("${springdoc.info.title:}")
    private String title;

    @Value("${springdoc.info.description:}")
    private String description;

    @Value("${springdoc.info.version:}")
    private String version;

    @Value("${springdoc.info.contact.name:}")
    private String contactName;

    @Value("${springdoc.info.contact.email:}")
    private String contactEmail;

    @Value("${springdoc.info.terms-of-service:}")
    private String termOfService;

    @Value("${springdoc.info.license.name:}")
    private String licenseName;

    @Value("${springdoc.info.license.url:}")
    private String licenseUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .termsOfService(termOfService)
                        .contact(new Contact()
                                .name(contactName)
                                .email(contactEmail))
                        .license(new License()
                                .name(licenseName)
                                .url(licenseUrl)));
    }

}
