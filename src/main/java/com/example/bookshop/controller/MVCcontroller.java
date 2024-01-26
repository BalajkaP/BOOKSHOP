package com.example.bookshop.controller;

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


    @RequestMapping("/contact")
    public String showContacts(Model model) {
        return "Contact";
    }
}