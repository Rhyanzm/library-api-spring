package com.dev.library.libraryapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record BookRequestDto(
    @NotBlank(message = "Title is required") String title,
    @NotBlank(message = "Author is required") String author,
    @NotBlank(message = "ISBN is required") String isbn
) {}