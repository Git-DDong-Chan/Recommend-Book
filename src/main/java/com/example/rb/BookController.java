package com.example.rb;

import java.util.List; // 이 부분 추가
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@Transactional
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findAll(); // 수정된 부분
        model.addAttribute("books", books);
        return "book-list";
    }
}
