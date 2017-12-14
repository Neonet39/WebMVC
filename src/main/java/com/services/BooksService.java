package com.services;

import com.repository.entity.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {
     List<Books> getListBooks();
     Books getBoks(Long id);
}
