package com.example.bookshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "books")
public class Book implements Comparable<Book> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private Double price;
    @Column
    private String description;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private BookAuthor bookAuthor;

    @ManyToMany(mappedBy= "bookList")
    private List<User> user;

    @Override
    public int compareTo(Book o) {
        int result = this.bookAuthor.getName().compareTo(o.bookAuthor.getName());
        return result;
    }
}
