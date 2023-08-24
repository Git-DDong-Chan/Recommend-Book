package com.example.rb.bookstore;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookstoreRepository extends JpaRepository<bookentity, String> {
    

@Query("SELECT b FROM bookentity b WHERE b.bookavailable = 1 AND LOWER(b.bookname) LIKE %:kw% ORDER BY b.bookdate DESC")
   Page<bookentity>findAllByKeyword(@Param("kw") String kw, Pageable pageable);

    
}
