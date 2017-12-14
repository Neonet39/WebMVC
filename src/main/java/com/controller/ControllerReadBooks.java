package com.controller;

import com.repository.entity.Books;
import com.services.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/getBook")
public class ControllerReadBooks {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerReadBooks.class);

    @Autowired
    BooksService booksServices;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redBooks(@ModelAttribute("id") Long id){
         LOG.info("got into the controller");

         Books books = booksServices.getBoks(id);
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("books",books);
         modelAndView.addObject("cod","menu");
         modelAndView.setViewName("readBooks");
         return modelAndView;
    }

}
