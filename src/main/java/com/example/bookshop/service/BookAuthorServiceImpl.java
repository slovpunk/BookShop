package com.example.bookshop.service;

import com.example.bookshop.forms.AuthorForm;
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
    public void saveAuthor(AuthorForm authorForm) {
        BookAuthor bookAuthor = BookAuthor.builder()
                .name(authorForm.getName())
                .build();
        bookAuthorRepository.save(bookAuthor);
    }

    @Override
    public List<BookAuthor> showAllAuthors() {
        return bookAuthorRepository.findAll();
    }

    @Override
    public BookAuthor getAuthorById(Long id) {
        return bookAuthorRepository.getById(id);
    }

    @Override
    public List<BookAuthor> findAllById(Long id) {
        return bookAuthorRepository.findAllById(id);
    }

    @Override
    public BookAuthor getBookAuthorByName(String name) {
        return bookAuthorRepository.getBookAuthorByName(name);
    }
}
