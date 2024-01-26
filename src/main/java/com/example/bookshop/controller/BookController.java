package com.example.bookshop.controller;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BooksEntity> books = BookService.getAllBooks();
        model.addAttribute("books", books);
        return "Books";
    }
}
