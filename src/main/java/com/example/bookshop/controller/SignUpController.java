package com.example.bookshop.controller;

import com.example.bookshop.forms.SignUpForm;
import com.example.bookshop.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignUp() {
        return "signUp";
    }

    @PostMapping
    public String signUpUser(SignUpForm signUpForm) {
        signUpService.signUpUser(signUpForm);
        return "redirect:/signIn";
    }

}
