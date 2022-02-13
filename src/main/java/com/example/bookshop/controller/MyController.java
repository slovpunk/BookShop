package com.example.bookshop.controller;


import com.example.bookshop.forms.AuthorForm;
import com.example.bookshop.forms.BookForm;
import com.example.bookshop.forms.UserForm;
import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookAuthor;
import com.example.bookshop.model.User;
import com.example.bookshop.service.BookAuthorService;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookins")
public class MyController {

    private UserService userService;
    private BookService bookService;
    private BookAuthorService bookAuthorService;

    public MyController(UserService userService, BookService bookService, BookAuthorService bookAuthorService) {
        this.userService = userService;
        this.bookService = bookService;
        this.bookAuthorService = bookAuthorService;
    }

    ////////////////////////////////////////////////////// books

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcomePage";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.showAllBooks();
        model.addAttribute("book", books);
        return "view-all-books";
    }

//    @PostMapping("/books/{books-id}/{author-id}")

    @PostMapping("/books")
    public String saveBook(BookForm bookForm) {
        bookService.saveBook(bookForm);
        return "redirect:/bookins/books";
    }

    @PostMapping("/books/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/bookins/books";
    }

    ////////////////////////////////////////////////////// users

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.showAllUsers();
        model.addAttribute("users", users);
        return "view-all-users";
    }

    @GetMapping("/user")
    public String getUser(Model model, @PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/users")
    public String saveUser(UserForm userForm) {
        userService.saveUser(userForm);
        return "redirect:/bookins/users";
    }

    @GetMapping("/users/{id}/update")
    public String addDetails(@PathVariable(value = "id") Long id, User user) {
        userService.updateUser(id, user);
        return "redirect:/user";
    }


    ////////////////////////////////////////////////////// authors

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        List<BookAuthor> authors = bookAuthorService.showAllAuthors();
        model.addAttribute("authors", authors);
        return "view-all-authors";
    }

    @PostMapping("/authors")
    public String saveUser(AuthorForm authorForm) {
        bookAuthorService.saveAuthor(authorForm);
        return "redirect:/bookins/authors";
    }

}
