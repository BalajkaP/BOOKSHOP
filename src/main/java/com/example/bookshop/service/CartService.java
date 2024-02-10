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
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;

    public List<CartEntity> getAllCart() {
        return cartRepository.findAll();
    }


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
  /*  public void addBookToCart(Long cartId, Long bookId) {
        boolean cartIsPresent = cartRepository.findById(cartId).isPresent();
        CartEntity cart = null;
        if (!cartIsPresent) {
            CartEntity newCart = new CartEntity();
            newCart.setId(cartId);
            cartRepository.save(newCart);
        } else {
            cart = cartRepository.getReferenceById(cartId);
        }
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
    }*/


    public void removeBookFromCart(Long cartId) {
        CartEntity cart = cartRepository.findById(cartId).orElseThrow();
        cartRepository.delete(cart);
    }
}
