package com.example.bookshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books_author")
public class BookAuthor implements Comparable<BookAuthor>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bookAuthor")
    private List<Book> books;

    @Override
    public int compareTo(BookAuthor o) {
        return this.id.compareTo(o.id);
    }
}
