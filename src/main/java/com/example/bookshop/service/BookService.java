package com.example.bookshop.service;

import com.example.bookshop.forms.AuthorForm;
import com.example.bookshop.forms.BookForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;

import java.util.List;

public interface BookService {
    void saveBook(BookForm bookForm, AuthorForm authorForm);
    void deleteBook(Long id);
    List<Book> showAllBooks();
    List<Book> findAllByBookAuthorId(Long id);
}
