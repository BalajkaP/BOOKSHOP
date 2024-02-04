package com.example.bookshop.controller;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.entities.CartEntity;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MVCcontroller {
    private final CartService cartService;
    private final BookService bookService;

    @GetMapping
    public String welcomePage() {
        return "Index";
    }

    @RequestMapping("/cart")
    public String showCart(Model model) {
        return "Cart";
    }


    @RequestMapping("/contact")
    public String showContacts(Model model) {
        return "Contact";
    }

    @GetMapping("/cart")
    public String getAllCart(Model model) {
        List<CartEntity> cart = cartService.getAllCart();
        model.addAttribute("cart", cart);
        return "Cart";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BooksEntity> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "Books";
    }

    @GetMapping("/abcd")
    public String getBooks() {
        cartService.addBookToCart(1L, 1L);
        return "Books";
    }

}
