package com.repository;

import com.repository.entity.Books;
import com.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    @Query("select b.id,b.title,b.description from Books b join BooksAutor e on e. ")
    Books findByName();
}
