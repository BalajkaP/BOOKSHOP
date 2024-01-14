package com.example.bookshop.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MVCcontroller {
    @GetMapping
    public String welcomePage () {
        return "Index";
    }
}
