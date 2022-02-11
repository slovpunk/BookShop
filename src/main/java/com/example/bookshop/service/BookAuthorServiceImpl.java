package com.example.bookshop.service;

import com.example.bookshop.model.BookAuthor;
import com.example.bookshop.repositories.BookAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookAuthorServiceImpl implements BookAuthorService {

    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    public BookAuthorServiceImpl(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public void addAuthor(BookAuthor bookAuthor) {
    }

    @Override
    public List<BookAuthor> showAllAuthors() {
        return null;
    }
}
