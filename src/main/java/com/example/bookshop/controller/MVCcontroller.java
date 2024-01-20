package com.example.bookshop.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MVCcontroller {
    @GetMapping
    public String welcomePage() {
        return "Index";
    }

    @RequestMapping("/cart")
    public String showCart(Model model) {
        return "Cart";
    }

    @RequestMapping("/books")
    public String showBooks(Model model) {
        return "Books";
    }

    @RequestMapping("/contact")
    public String showContacts(Model model) {
        return "Contact";
    }
}