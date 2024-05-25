package com.faash.sample_rest_client.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8082");
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("sam.mv74@gmail.com");
        contact.setName("samaneh");
        contact.setUrl("https://www.faash.com");

        Info info = new Info()
                .title("Sample API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage person client methods.");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
