package com.example.bookshop.service;


import com.example.bookshop.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    void addAuthor(BookAuthor bookAuthor);
    List<BookAuthor> showAllAuthors();
}
