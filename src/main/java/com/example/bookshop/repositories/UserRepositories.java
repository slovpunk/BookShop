package com.example.bookshop.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long> {
}
