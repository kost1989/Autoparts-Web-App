package ru.auto.dunkan.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Dunkan Auto Swagger API")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("")
                                                .url("")
                                                .name("Kostyukov Ilya")
                                )
                );
    }
}

