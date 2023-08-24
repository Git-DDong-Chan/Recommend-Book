package com.example.rb.book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByChecks(int checks);


    @Query("SELECT b FROM Book b WHERE b.count = 1 AND LOWER(b.title) LIKE %:kw% ")
   Page<Book>findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
