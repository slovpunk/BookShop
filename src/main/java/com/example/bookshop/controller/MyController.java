package com.example.bookshop.controller;


import com.example.bookshop.forms.BookForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.User;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookins")
public class MyController {

    private UserService userService;
    private BookService bookService;

    @Autowired
    public MyController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.showAllBooks();
        model.addAttribute("book", books);
        return "view-all-books";
    }

    @PostMapping("/books")
    public String saveBook(BookForm bookForm) {
        bookService.saveBook(bookForm);
        return "redirect:/bookins/books";
    }

}
