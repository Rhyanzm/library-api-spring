package com.dev.library.libraryapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library API", version = "1.0", description = "API de Gerenciamento de Livros"))
public class LibraryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApiApplication.class, args);
    }
}