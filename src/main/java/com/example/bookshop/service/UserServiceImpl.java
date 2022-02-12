package com.example.bookshop.service;

import com.example.bookshop.forms.UserForm;
import com.example.bookshop.model.User;
import com.example.bookshop.repositories.UserRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserForm userForm) {
        User user = User.builder()
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .age(userForm.getAge())
                .favoriteGenre(userForm.getFavoriteGenre())
                .build();
        userRepository.save(user);
    }

    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }
}
