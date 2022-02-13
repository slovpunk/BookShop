package com.example.bookshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

//    public enum Role {
//        ADMIN, USER
//    }
//
//    @Enumerated(value = EnumType.STRING)
//    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "favorite_genre")
    private String favoriteGenre;

    @Column(unique = true)
    private String email;

    private String hashPassword;


    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")})
    private List<Book> bookList;
}
