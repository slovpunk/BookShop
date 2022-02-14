package com.example.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    @GetMapping
    public String signIn() {
        return "signIn";
    }
}
