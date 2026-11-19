package com.divyasree.library.controller;

import com.divyasree.library.service.CatalogService;

public class LibraryController {
    private final CatalogService catalog;

    public LibraryController(CatalogService catalog) {
        this.catalog = catalog;
    }

    public String handleBorrow(String isbn) {
        return catalog.borrowBook(isbn) ? "SUCCESS_BORROWED" : "UNAVAILABLE";
    }
}
