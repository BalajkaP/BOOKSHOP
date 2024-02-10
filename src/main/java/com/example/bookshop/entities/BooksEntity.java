package com.example.bookshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "books")

@Getter
@Setter
@AllArgsConstructor
@Builder
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


    @ManyToMany
    private List<CartEntity> carts;

}
