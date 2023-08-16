package com.example.rb.bookstore;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookstoreRepository extends JpaRepository<bookentity, String> {
    
@Query("SELECT b FROM bookentity b WHERE b.bookavailable = 1")
    List<bookentity> findAvailableBooks();
}
