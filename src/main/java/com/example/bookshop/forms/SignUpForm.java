package com.example.bookshop.forms;

import lombok.Data;

@Data
public class SignUpForm {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer age;
    private String favoriteGenre;
}

