package com.divyasree.library.service;

import com.divyasree.library.model.Book;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CatalogService {
    private final Map<String, Book> catalog = new ConcurrentHashMap<>();

    public void addBook(String isbn, String title, String author) {
        catalog.put(isbn, new Book(isbn, title, author));
    }

    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(catalog.get(isbn));
    }

    public boolean borrowBook(String isbn) {
        Book b = catalog.get(isbn);
        if (b != null && b.isAvailable()) {
            b.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book b = catalog.get(isbn);
        if (b != null && !b.isAvailable()) {
            b.setAvailable(true);
            return true;
        }
        return false;
    }
}
