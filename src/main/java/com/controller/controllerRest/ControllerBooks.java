package com.controller.controllerRest;

import com.repository.entity.Books;
import com.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class ControllerBooks {

    @Autowired
    BooksService booksServices;

    @RequestMapping("/getBooks")
    public List<Books> greeting() {
        List<Books> books = booksServices.getListBooks();
        return books;
    }

    @RequestMapping("/getBook")
    public Books greeting(@RequestParam(value="id") Long id) {
        Books books = booksServices.getBoks(id);
        return books;
    }

}
