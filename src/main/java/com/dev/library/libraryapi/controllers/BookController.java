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
    public ResponseEntity<BookResponseDto> getOneBook(@PathVariable(value = "id") Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
        
        return ResponseEntity.ok(convertToResponseDto(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @RequestBody @Valid BookRequestDto bookRequestDto) {
        Book updatedBook = bookService.update(id, bookRequestDto);
        return ResponseEntity.ok(convertToResponseDto(updatedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private BookResponseDto convertToResponseDto(Book book) {
        return new BookResponseDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());
    }
}