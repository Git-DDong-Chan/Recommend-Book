package com.example.rb.book;

import java.util.List;


import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteCount() {
        List<Book> booksToDelete = bookRepository.findByCountEquals(0);
        bookRepository.deleteAll(booksToDelete);
    }
}
