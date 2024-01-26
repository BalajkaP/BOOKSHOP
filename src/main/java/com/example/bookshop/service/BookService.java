package com.example.bookshop.service;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.repository.BookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Setter
@Getter
@Service
public class BookService {
    private static BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static List<BooksEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}