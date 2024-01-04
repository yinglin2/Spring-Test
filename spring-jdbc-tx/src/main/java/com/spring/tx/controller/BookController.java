package com.spring.tx.controller;

import com.spring.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    public void buyBook(int bookId, int userId) {
        bookService.buyBook(bookId,userId);
    }
}
