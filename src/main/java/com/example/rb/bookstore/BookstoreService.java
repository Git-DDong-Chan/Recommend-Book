package com.example.rb.bookstore;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final BookstoreRepository bookstoreRepository;
   
    public List<bookentity> getList(){
        return this.bookstoreRepository.findAvailableBooks();
    }
    
}
