package com.example.rb.bookstore;



import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final BookstoreRepository bookstoreRepository;
   
  
     public Page<bookentity> getList(int page, String kw) {
        Pageable pageable = PageRequest.of(page, 12);
        return this.bookstoreRepository.findAllByKeyword(kw, pageable);
    }
  
    
}