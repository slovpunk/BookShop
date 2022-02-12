package com.example.bookshop.repositories;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
}
