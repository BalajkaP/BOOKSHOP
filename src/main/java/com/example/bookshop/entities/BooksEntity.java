package com.example.bookshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksEntity {
    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorsEntity author;
}
