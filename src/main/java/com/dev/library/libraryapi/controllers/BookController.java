package com.dev.library.libraryapi.controllers;

import com.dev.library.libraryapi.dtos.BookRecordDto;
import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;package com.dev.library.libraryapi.controllers;

import com.dev.library.libraryapi.dtos.BookRecordDto;
import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookRecordDto bookRecordDto) {
        var bookModel = new Book();
        BeanUtils.copyProperties(bookRecordDto, bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }
}

@RestController
@RequestMapping("/books") // Define a rota base como http://localhost:8080/books
public class BookController {

    // Injeção de dependência via construtor (melhor prática para testabilidade)
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookRecordDto bookRecordDto) {
        var bookModel = new Book();
        // BeanUtils facilita a conversão de DTO para Model
        BeanUtils.copyProperties(bookRecordDto, bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }
}