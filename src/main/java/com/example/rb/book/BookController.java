package com.example.rb.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;


    @GetMapping("/recommend/list")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "recommend_list";
    }
  
    @ResponseBody
    @GetMapping("/toggleRecommendation/{id}")
    public Map<String, Object> toggleRecommendation(@PathVariable Long id) {
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


    @PostMapping("/recommend/delete-count-zero")
    public String deleteCount() {
        bookService.deleteCount();
        return "redirect:/recommend/list";
    }
}
