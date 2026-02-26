package com.dev.library.libraryapi.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity // Diz ao Hibernate que isso é uma tabela no banco
@Table(name = "TB_BOOKS") // Define o nome da tabela
@Data // Gera Getters, Setters, toString, Equals e HashCode automaticamente
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // O banco gera o ID sozinho
    private Long id;

    @Column(nullable = false, length = 150) // Campo obrigatório
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true) // ISBN deve ser único
    private String isbn;
}