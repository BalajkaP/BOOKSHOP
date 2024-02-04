package com.example.bookshop.service;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BooksEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}