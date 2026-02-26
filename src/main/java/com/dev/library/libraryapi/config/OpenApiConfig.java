package com.dev.library.libraryapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server devServer = new Server();
        // O Spring vai tentar detectar a URL, ou você pode deixar o campo vazio para ele usar a URL relativa
        devServer.setUrl("/"); 
        devServer.setDescription("Servidor de Desenvolvimento (Codespaces)");

        return new OpenAPI()
                .info(new Info()
                        .title("Library API Restful")
                        .version("v1")
                        .description("API para gerenciamento de livros desenvolvida para portfólio."))
                .servers(List.of(devServer));
    }
}