package com.dev.library.libraryapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record BookRecordDto(
    @NotBlank String title, 
    @NotBlank String author, 
    @NotBlank String isbn
) {}