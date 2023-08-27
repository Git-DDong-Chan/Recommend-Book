package com.example.rb.book;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public void deleteChecks(Long loggedInUserId1) {
        List<Book> booksToDelete = bookRepository.findByCheck(loggedInUserId1,0);
        bookRepository.deleteAll(booksToDelete);
    }


      public Page<Book> getList(String kw,Long loggedInUserId,int page) {
        Pageable pageable = PageRequest.of(page, 6);
        return this.bookRepository.findAllByKeyword(kw,loggedInUserId ,pageable);
    }
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}