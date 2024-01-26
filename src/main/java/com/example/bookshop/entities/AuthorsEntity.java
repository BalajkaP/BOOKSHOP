package com.example.bookshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="authors")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorsEntity {

    @Id
    @Column(name="id_author")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToMany (mappedBy = "author" ,cascade = CascadeType.ALL)
    List<BooksEntity> books;

}
