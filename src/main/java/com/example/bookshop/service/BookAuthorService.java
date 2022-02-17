package com.example.bookshop.service;


import com.example.bookshop.forms.AuthorForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    void saveAuthor(AuthorForm authorForm);
    List<BookAuthor> showAllAuthors();
    BookAuthor getAuthorById(Long id);
    List<BookAuthor> findAllById(Long id);
    BookAuthor getBookAuthorByName(String name);
}
