package com.example.bookshop.service;

import com.example.bookshop.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    void deleteBook(Book book);
    List<Book> showAllBooks();

}
