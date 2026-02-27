package com.dev.library.libraryapi.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_books")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String title;
    private String author;
    private String isbn;

    // --- METODOS MANUAIS (EVITAR ERRO NO MVN) ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}