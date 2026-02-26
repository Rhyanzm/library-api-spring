package com.dev.library.libraryapi.repositories;

import com.dev.library.libraryapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Indica que este componente lida com o acesso a dados
public interface BookRepository extends JpaRepository<Book, Long> {
    // Aqui herdamos métodos como save(), findAll(), findById(), delete()
}