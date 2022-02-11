package com.example.bookshop.controller;


import com.example.bookshop.model.Book;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
        model.addAttribute("books", books);
        return "view-all-books";
    }

}
