package com.example.bookshop.service;


import com.example.bookshop.forms.UserForm;
import com.example.bookshop.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserForm userForm);
    List<User> showAllUsers();
    void updateUser(Long id, User user);
    User getUser(Long id);
}
