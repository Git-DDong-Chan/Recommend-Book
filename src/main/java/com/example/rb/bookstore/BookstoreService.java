package com.example.rb.bookstore;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final BookstoreRepository bookstoreRepository;
   
    public List<bookentity> getList(){
        return this.bookstoreRepository.findAvailableBooks();
    }
     public Page<bookentity> getList(int page) {
        Pageable pageable = PageRequest.of(page, 12);
        return this.bookstoreRepository.findAll(pageable);
    }
    
}
