package com.lovezhan.controller;

import com.lovezhan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookServiceImpl;

    @RequestMapping("/bookCount")
    public Long bookCount() {
        return bookServiceImpl.getBookById(1);
    }

}
