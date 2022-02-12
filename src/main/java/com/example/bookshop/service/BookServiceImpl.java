package com.example.bookshop.service;

import com.example.bookshop.forms.BookForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import com.example.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(BookForm bookForm) {
        Book book = Book.builder()
                .id(bookForm.getId())
                .title(bookForm.getTitle())
                .price(bookForm.getPrice())
                .genre(bookForm.getGenre())
                .description(bookForm.getDescription())
                .build();

        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

}
