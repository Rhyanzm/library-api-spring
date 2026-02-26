package com.dev.library.libraryapi.controllers;

import com.dev.library.libraryapi.dtos.BookRecordDto;
import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookRecordDto bookRecordDto) {
    var bookModel = new Book();
    // Forçamos o set manual se o BeanUtils estiver falhando por nomes diferentes
    bookModel.setTitle(bookRecordDto.title());
    bookModel.setAuthor(bookRecordDto.author());
    bookModel.setIsbn(bookRecordDto.isbn());
    
    return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
}

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }

    // AQUI ESTAVA O ERRO: Mudamos de UUID para Long para bater com seu Repository
    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getOneBook(@PathVariable(value = "id") Long id) {
        Optional<Book> bookO = bookService.findById(id);
        if(bookO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookO.get());
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") Long id) {
        Optional<Book> bookO = bookService.findById(id);
        if(bookO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        bookService.delete(bookO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }
}