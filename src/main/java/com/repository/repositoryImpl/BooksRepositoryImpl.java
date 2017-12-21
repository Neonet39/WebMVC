package com.repository.repositoryImpl;

import com.repository.BooksRepository;
import com.repository.BooksRepositoryAdapt;
import com.repository.entity.Autor;
import com.repository.entity.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BooksRepositoryImpl implements BooksRepositoryAdapt {
    private static final Logger LOG = LoggerFactory.getLogger(BooksRepositoryImpl.class);

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Books> findAll() {
        List<Books> booksList;
        try {
            Query query = entityManager.createNativeQuery("SELECT books.id,title,content,description,last_name,first_name FROM books join autor_books " +
                    "on autor_books.books_id = books.id " +
                    "join autor " +
                    "on autor.id = autor_books.autor_id",Books.class);

            booksList =  query.getResultList();
        } catch (Exception e) {
            LOG.error("Error retrieving books in method findAll()" + e);
            return null;
        }
        LOG.info("Successfully received books in method findAll()");
        return booksList;
    }

    @Override
    public Books findById(Long id) {
        Books books;
        try {
            books = booksRepository.findById(id).get();
        } catch (Exception e) {
            LOG.error("Error retrieving book n method findById()" + e);
            return null;
        }
        LOG.info("Successfully received book in method findById()");
        return books;
    }
}
