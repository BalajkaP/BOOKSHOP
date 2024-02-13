package com.example.bookshop.service;

import com.example.bookshop.entities.AuthorsEntity;
import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.entities.CartEntity;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;


    public void addBookToCart(Long cartId, Long bookId) {
        CartEntity cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));
        BooksEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        List<BooksEntity> listBooks = cart.getBooks();
        listBooks.add(book);
        cart.setBooks(listBooks);
        cartRepository.save(cart);
        List<CartEntity> listCarts = book.getCarts();
        listCarts.add(cart);
        book.setCarts(listCarts);
        bookRepository.save(book);
    }

    public void removeBookFromCart(Long cartId, Long bookId) {
        // Získaj košík pomocou ID
        CartEntity cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Košík nebol nájdený"));

        // Získaj knihu pomocou ID
        BooksEntity book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Kniha neexistuje"));

        // Odstráň knihu z košíka
        cart.getBooks().remove(book);

        // Ulož zmeny v košíku
        cartRepository.save(cart);

        // Odstráň košík z knihy
        book.getCarts().remove(cart);

        // Ulož zmeny v knihe
        bookRepository.save(book);
    }

}
