package com.example.rb.book;

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
    public void deleteChecks() {
        List<Book> booksToDelete = bookRepository.findByChecks(0);
        bookRepository.deleteAll(booksToDelete);
    }


      public Page<Book> getList(int page,Long loggedInUserId,String kw) {
        Pageable pageable = PageRequest.of(page, 12);
        return this.bookRepository.findAllByKeyword(kw,loggedInUserId ,pageable);
    }
}