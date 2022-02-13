package com.example.bookshop.service;

import com.example.bookshop.forms.SignUpForm;
import com.example.bookshop.model.User;
import com.example.bookshop.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SignUpServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void signUpUser(SignUpForm signUpForm) {
        User user = User.builder()
                .name(signUpForm.getName())
                .surname(signUpForm.getSurname())
                .email(signUpForm.getEmail())
                .role(User.Role.USER)
                .hashPassword(passwordEncoder.encode(signUpForm.getPassword()))
                .build();

        userRepository.save(user);
    }
}
