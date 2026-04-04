package com.mudit.piingouserservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI userServiceOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Piingo User Service API")
                        .description("API documentation for Piingo user-service endpoints.")
                        .version("v1")
                        .contact(new Contact().name("Piingo")));
    }
}
