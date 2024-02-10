package com.example.bookshop.controller;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.entities.CartEntity;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class MVCcontroller {
    private final CartService cartService;
    private final BookService bookService;
    private final BookRepository bookRepository;

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


    @PostMapping("/addToCart/{bookId}")
    public String addToCart(@PathVariable Long bookId) {
        Long cartId = 10L;
        cartService.addBookToCart(cartId, bookId);
        return "redirect:/books";
    }

    @PostMapping("/createBook")
    public String addBook(@RequestParam String title,
                          @RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String price) {
        bookService.addBook(title, firstName, lastName, price);
        return "redirect:/books";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @GetMapping("/remove/{cartId}")
    public String removeBookFromCart(@PathVariable Long cartId) {
        cartService.removeBookFromCart(cartId);
        return "redirect:/cart";
    }

    @GetMapping("/updatePrice")
    public String showUpdatePriceForm(Model model) {
        List<BooksEntity> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "updatePriceForm";
    }

    @PostMapping("/updatePrice")
    public String updateBookPrice(@RequestParam Long bookId, @RequestParam String newPrice) {
        bookService.updateBookPrice(bookId, newPrice);
        return "redirect:/books";
    }

    @GetMapping("/")
    public String getRandomBooks(Model model) {
        List<BooksEntity> randomBooks = bookService.getRandomBooks();
        model.addAttribute("randomBooks", randomBooks);
        return "Index"; // název Thymeleaf šablony pro zobrazení
    }

}



