package com.example.bookshop.service;

import com.example.bookshop.entities.AuthorsEntity;
import com.example.bookshop.entities.BooksEntity;
import com.example.bookshop.repository.AuthorRepository;
import com.example.bookshop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<BooksEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BooksEntity addBook(String title, String authorName, String authorSurname, String price) {
        AuthorsEntity author = authorRepository.findByNameAndSurname(authorName, authorSurname);
        if (author == null) {
            author = new AuthorsEntity();
            author.setName(authorName);
            author.setSurname(authorSurname);
            authorRepository.save(author);
        }
        BooksEntity booksEntity = BooksEntity.builder()
                .author(author)
                .price(price)
                .title(title)
                .build();
        if (author.getBooks() == null) { // Overím či má zoznam kníh autora hodnotu null
            author.setBooks(new ArrayList<>()); // Inicializujem zoznam, ak je null
        }
        var list = author.getBooks();
        list.add(booksEntity);
        author.setBooks(list);
        authorRepository.save(author);
        return bookRepository.save(booksEntity);
    }


    public void deleteBookById(Long id) {
        BooksEntity book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            AuthorsEntity author = book.getAuthor();
            if (author != null) {
                List<BooksEntity> booksList = author.getBooks();
                booksList.remove(book);
                author.setBooks(booksList);
                authorRepository.save(author);
            }
            bookRepository.delete(book);
        }
    }

    public void updateBookPrice(Long bookId, String newPrice) {
        BooksEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        book.setPrice(newPrice);
        bookRepository.save(book);
    }

    public List<BooksEntity> getRandomBooks() {
        return bookRepository.findRandomBooks();
    }
}

