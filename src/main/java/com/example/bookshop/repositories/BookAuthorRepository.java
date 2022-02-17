package com.example.bookshop.repositories;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
    List<BookAuthor> findAllById(Long id);
    BookAuthor getBookAuthorByName(String name);
}
