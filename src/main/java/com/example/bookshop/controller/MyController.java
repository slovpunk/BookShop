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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.showAllBooks();
        Collections.sort(books);
        List<User> users = userService.showAllUsers();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByEmail(authentication.getName());
        if (user.getRole().toString().equals("USER")) {
            model.addAttribute("books", books);
            model.addAttribute("user", user);
            return "user";
        } else {
            model.addAttribute("book", books);
            model.addAttribute("users", users);
            model.addAttribute("user", user);
            return "admin";
        }
    }


//    @GetMapping("/books")
//    public String getAllBooks(Model model) {
//        List<Book> books = bookService.showAllBooks();
//        Collections.sort(books);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getByEmail(authentication.getName());
//        model.addAttribute("user", user);
//        model.addAttribute("book", books);
//        return "view-all-books";
//    }

    @GetMapping("/book/{id}")
    public String showBooksOfAuthor(Model model, @PathVariable(value = "id") Long id) {
        List<Book> books = bookService.findAllByBookAuthorId(id);
        model.addAttribute("books", books);
        return "view-all-books-of-author";
    }

    @PostMapping("/books/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByEmail(authentication.getName());
        Book book = bookService.getById(id);
        while (user.getBookList().contains(book))
            user.getBookList().remove(book);
        userService.userSave(user);
        bookService.deleteBook(id);
        return "redirect:/bookins/books";
    }

    @PostMapping("/books/save")
    public String addBookAndAuthor(BookForm bookForm, AuthorForm authorForm) {
        BookAuthor bookAuthor = bookAuthorService.getBookAuthorByName(authorForm.getName());
        if (bookAuthor == null) {
            bookAuthorService.saveAuthor(authorForm);
            bookAuthor = bookAuthorService.getBookAuthorByName(authorForm.getName());
        }
        bookForm.setBookAuthor(bookAuthor);
        bookService.saveBook(bookForm);
        return "redirect:/bookins/books";
    }

    @PostMapping("/books/{id}/update")
    public String updateBook(@PathVariable(value = "id") Long id, Book book) {
        bookService.updateBook(id, book);
        return "redirect:/bookins/books";
    }

    @GetMapping("/books/update/{id}")
    public String updateBooks(Model model, @PathVariable(value = "id") Long id) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book";
    }

    ////////////////////////////////////////////////////// users

    @PostMapping("/books/{user-id}/basket/{book-id}")
    public String addToBasket(@PathVariable(value = "user-id") Long userId,
                              @PathVariable(value = "book-id") Long bookId) {
        User user = userService.getById(userId);
        Book book = bookService.getById(bookId);
        user.getBookList().add(book);
        userService.userSave(user);
        return "redirect:/bookins/books";
    }

    @PostMapping("/books/{id}/deleteBasket")
    public String deleteFromBasket(@PathVariable(value = "id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByEmail(authentication.getName());
        Book book = bookService.getById(id);
        user.getBookList().remove(book);
        userService.userSave(user);
        return "redirect:/bookins" + "/" + user.getId() + "/basket";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.showAllUsers();
        model.addAttribute("users", users);
        return "view-all-users";
    }

    @GetMapping("/{id}/basket")
    public String getBooksFromBasket(Model model, @PathVariable(value = "id") Long id) {
        User user = userService.getById(id);
        List<Book> books = bookService.findAllByUser(user);
        Set<String> authors = books
                .stream()
                .map(Book::getBookAuthor)
                .map(BookAuthor::getName)
                .collect(Collectors.toSet());
        double sumOfPriceOfBooks = user.getBookList()
                .stream()
                .map(Book::getPrice)
                .reduce((accumulator, element) -> accumulator + element).orElse(0.0);
        model.addAttribute("sum", sumOfPriceOfBooks);
        model.addAttribute("books", books);
        model.addAttribute("user", user);
        model.addAttribute("favAuthor", authors);
//        model.addAttribute("fAuthor", favAuthors);
        return "basket";
    }

    @GetMapping("/{id}/user")
    public String getUser(Model model, @PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/{id}/user/update")
    public String getUserUpdate(Model model, @PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/users")
    public String saveUser(UserForm userForm) {
        userService.saveUser(userForm);
        return "redirect:/bookins/users";
    }

    @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable(value = "id") Long id, User user) {
        userService.updateUser(id, user);
        return "redirect:/bookins/books";
    }

//    @PostMapping("/users/{id}/update")
//    public String addDetails() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getByEmail(authentication.getName());
//        userService.updateUser(user.getId(), user);
//        return "redirect:/bookins/user";
//    }

    ////////////////////////////////////////////////////// authors

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        List<BookAuthor> authors = bookAuthorService.showAllAuthors();
        model.addAttribute("authors", authors);
        return "view-all-authors";
    }
//
//    @PostMapping("/authors")
//    public String saveUser(AuthorForm authorForm) {
//        bookAuthorService.saveAuthor(authorForm);
//        return "redirect:/bookins/books";
//    }

}
