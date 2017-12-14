package com.services.servicesImpl;

import com.repository.BooksRepositoryAdapt;
import com.repository.entity.Books;
import com.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    BooksRepositoryAdapt booksRepositoryAdapt;

    @Override
    public List<Books> getListBooks() {
        return booksRepositoryAdapt.findAll();
    }

    @Override
    public Books getBoks(Long id) {
        return booksRepositoryAdapt.findById(id);

    }
}
