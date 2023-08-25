package com.example.rb.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    @GetMapping("/recommend/list")
    public String listrecommendBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "recommend_list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findByChecks(1);
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
    @GetMapping("/toggleRecommend/{id}")
    public Map<String, Object> toggleRecommend(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            int newCount = book.getCount() == 0 ? 1 : 0;
            book.setCount(newCount);
            bookRepository.save(book);

            response.put("success", true);
            response.put("newCount", newCount);
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
            int newChecks = book.getChecks() == 0 ? 1 : 0;
            book.setChecks(newChecks);
            bookRepository.save(book);

            response.put("success", true);
            response.put("newChecks", newChecks);
        } else {
            response.put("success", false);
        }

        return response;
    }

    @PostMapping("/recommend/delete-checks-zero")
    public String deleteChecks() {
        bookService.deleteChecks();
        return "redirect:/books";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/bookstore/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "kw", defaultValue = "") String kw) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Page<Book> paging = this.bookService.getList(page, kw);

        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        model.addAttribute("loggedInUsername", loggedInUsername);
        return "bookstorelist";
    }
}