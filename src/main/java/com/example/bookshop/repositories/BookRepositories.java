package com.example.bookshop.repositories;

import com.example.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositories extends JpaRepository<Book, Long> {
}
