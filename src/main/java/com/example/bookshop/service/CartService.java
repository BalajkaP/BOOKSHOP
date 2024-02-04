package com.example.bookshop.service;

import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.entities.CartEntity;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;

    public List<CartEntity> getAllCart() {
        return cartRepository.findAll();
    }


    public void addBookToCart(Long cartId, Long bookId) {
        CartEntity cart = cartRepository.findById(cartId).orElseThrow();
        BooksEntity book = bookRepository.getReferenceById(bookId);
        List<BooksEntity> listBooks = cart.getBooks();
        listBooks.add(book);
        cart.setBooks(listBooks);
        cartRepository.save(cart);
        List<CartEntity> listCarts = book.getCarts();
        listCarts.add(cart);
        book.setCarts(listCarts);
        bookRepository.save(book);
    }
}
