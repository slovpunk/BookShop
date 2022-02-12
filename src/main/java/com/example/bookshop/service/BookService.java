package com.example.bookshop.service;

import com.example.bookshop.forms.BookForm;
import com.example.bookshop.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(BookForm bookForm);
    void deleteBook(Book book);
    List<Book> showAllBooks();

}
