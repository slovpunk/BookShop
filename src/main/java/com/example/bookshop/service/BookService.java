package com.example.bookshop.service;

import com.example.bookshop.forms.AuthorForm;
import com.example.bookshop.forms.BookForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import com.example.bookshop.model.User;

import java.util.List;

public interface BookService {
    void saveBook(BookForm bookForm);

    void deleteBook(Long id);

    List<Book> showAllBooks();

    List<Book> findAllByBookAuthorId(Long id);

    Book getById(Long id);

    void updateBook(Long id, Book book);

    List<Book> findAllByUser(User user);

}
