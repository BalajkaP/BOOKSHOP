package com.example.bookshop.repository;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<BooksEntity, Long> {

    List<BooksEntity> findAllByCartsIn(List<CartEntity> carts);

    @Query(value = "SELECT * FROM books ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<BooksEntity> findRandomBooks();
    BooksEntity findByTitle(String title);
}

