package com.example.bookshop.repository;

import com.example.bookshop.entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends JpaRepository<BooksEntity, Long> {


}

