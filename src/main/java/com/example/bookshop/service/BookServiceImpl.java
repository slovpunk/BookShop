package com.example.bookshop.service;

import com.example.bookshop.forms.AuthorForm;
import com.example.bookshop.forms.BookForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import com.example.bookshop.model.User;
import com.example.bookshop.repositories.BookAuthorRepository;
import com.example.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookAuthorRepository bookAuthorRepository) {
        this.bookRepository = bookRepository;
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public void saveBook(BookForm bookForm) {
        Book book = Book.builder()
                .id(bookForm.getId())
                .title(bookForm.getTitle())
                .price(bookForm.getPrice())
                .genre(bookForm.getGenre())
                .bookAuthor(bookForm.getBookAuthor())
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

    @Override
    public List<Book> findAllByBookAuthorId(Long id) {
        return bookRepository.findAllByBookAuthorId(id);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book data = bookRepository.getById(id);
        data.setTitle(book.getTitle());
        data.setGenre(book.getGenre());
        data.setPrice(book.getPrice());
        data.setDescription(book.getDescription());
//        data.setBookAuthor(book.getBookAuthor());
        bookRepository.save(data);
    }
}
