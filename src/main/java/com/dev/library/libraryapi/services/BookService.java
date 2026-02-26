package com.dev.library.libraryapi.services;

import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional // Garante que a operação seja atômica no banco
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}