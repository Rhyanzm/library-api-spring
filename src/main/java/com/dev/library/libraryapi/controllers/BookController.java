package com.dev.library.libraryapi.controllers;

import com.dev.library.libraryapi.dtos.BookRequestDto;
import com.dev.library.libraryapi.dtos.BookResponseDto;
import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> saveBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        Book savedBook = bookService.save(bookRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponseDto(savedBook));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> list = bookService.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBook(@PathVariable(value = "id") Long id) {
        Optional<Book> bookO = bookService.findById(id);
        if(bookO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        return ResponseEntity.ok(convertToResponseDto(bookO.get()));
    }
    @GetMapping("/{id}")
public ResponseEntity<BookResponseDto> getOneBook(@PathVariable(value = "id") Long id) {
    Book book = bookService.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    
    return ResponseEntity.ok(convertToResponseDto(book));
}

    // Método auxiliar para não repetir código de conversão
    private BookResponseDto convertToResponseDto(Book book) {
        return new BookResponseDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());
    }
}