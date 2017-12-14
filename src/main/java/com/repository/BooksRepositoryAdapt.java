package com.repository;

import com.repository.entity.Books;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepositoryAdapt {
    List<Books> findAll();
    Books findById(Long id);
}
