package com.example.rb.book;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    @GetMapping("/recommend/list")
    public String listRecommendBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "recommend_list";
    }

    
    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @ResponseBody
    @PostMapping("/saveComment/{id}")
    public Map<String, Object> saveComment(@PathVariable Long id, @RequestParam String content) {
        Map<String, Object> response = new HashMap<>();

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();

            book.setComment(content); // Book 엔티티에 코멘트 업데이트

            bookRepository.save(book);

            response.put("success", true);
        } else {
            response.put("success", false);
        }

        return response;
    }

    @ResponseBody
    @GetMapping("/toggleRecommendation/{id}")
    public Map<String, Object> toggleRecommendation(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            int newCount = book.getCount() == 0 ? 1 : 0;
            int newChecks = book.getChecks() == 0 ? 1 : 0;
            book.setCount(newCount);
            book.setChecks(newChecks);

            bookRepository.save(book);

            response.put("success", true);
            response.put("newCount", newCount);
            response.put("newChecks", newChecks);

        } else {
            response.put("success", false);
        }
        return response;
    }



    @PostMapping("/recommend/delete-check-zero")
    public String deleteCheck() {
        bookService.deleteCheck();
        return "redirect:/recommend/list";
    }
}