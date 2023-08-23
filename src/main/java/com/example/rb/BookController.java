package com.example.rb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class BookController {
    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/getComment/{id}")
    @ResponseBody
    public String getComment(@PathVariable Long id) {
        // 책의 댓글 내용을 가져와서 반환
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return book.getComment();
        }
        return "";
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

    @GetMapping("/")
    public String index() {
        return "booklist";
    }
}
