package com.example.rb.bookstore;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookstoreRepository extends JpaRepository<bookentity, String> {
    
Page<bookentity> findAll(Pageable pageable);  

@Query("SELECT b FROM bookentity b WHERE b.bookavailable = 1")
    List<bookentity> findAvailableBooks();

    
}
