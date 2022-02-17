package com.example.bookshop.repositories;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import com.example.bookshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByBookAuthorId(Long id);
    Book getById(Long id);
    List<Book> findAllByUser(User user);
}
