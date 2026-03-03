package com.dev.library.libraryapi.infra;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public record ErrorMessage(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path
) {}