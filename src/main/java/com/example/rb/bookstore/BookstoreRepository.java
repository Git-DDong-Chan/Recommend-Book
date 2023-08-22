package com.example.rb.bookstore;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookstoreRepository extends JpaRepository<bookentity, String> {
    


@Query("SELECT b FROM bookentity b WHERE b.bookavailable = 1 order by b.bookdate desc")
   Page<bookentity> findAll(Pageable pageable);  

    
}
