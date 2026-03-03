package com.dev.library.libraryapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record BookRequestDto(
    @NotBlank String title, 
    @NotBlank String author, 
    @NotBlank String isbn
) {
}