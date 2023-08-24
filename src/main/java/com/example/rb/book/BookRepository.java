package com.example.rb.book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByCountEquals(int count);
}
