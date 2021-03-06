package com.controller;

import com.repository.entity.Books;
import com.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/mainPage")
public class ControllerHome {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerHome.class);

    @Autowired
    BooksService booksServices;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        LOG.info("got into the controller");

        List<Books> booksList = booksServices.getListBooks();
        model.addAttribute("booksList", booksList);
        model.addAttribute("cod", "menu");
        return "index";
    }
}
