package com.dev.library.libraryapi.services;

import com.dev.library.libraryapi.dtos.BookRequestDto;
import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book save(BookRequestDto dto) {
        var book = new Book();
        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setIsbn(dto.isbn());
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public void delete(Book book) {
        bookRepository.delete(book);
    }
}