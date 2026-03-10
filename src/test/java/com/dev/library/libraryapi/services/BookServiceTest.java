package com.dev.library.libraryapi.services;

import com.dev.library.libraryapi.dtos.BookRequestDto;
import com.dev.library.libraryapi.models.Book;
import com.dev.library.libraryapi.repositories.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    @DisplayName("Deve salvar um livro com sucesso")
    void saveBookSuccess() {
        // Arrange (Configuração dos dados de teste)
        BookRequestDto dto = new BookRequestDto("O Hobbit", "J.R.R. Tolkien", "123456");
        Book book = new Book();
        book.setId(1L);
        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setIsbn(dto.isbn());

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Act (Execução do método a ser testado)
        Book savedBook = bookService.save(dto);

        // Assert (Verificação dos resultados)
        assertNotNull(savedBook);
        assertEquals("O Hobbit", savedBook.getTitle());
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}