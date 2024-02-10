package com.example.bookshop.entities;

import com.example.bookshop.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;


    @ManyToMany
    private List<BooksEntity> books;


}
