package com.example.bookshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books_author")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bookAuthor")
    private List<Book> books;
}
