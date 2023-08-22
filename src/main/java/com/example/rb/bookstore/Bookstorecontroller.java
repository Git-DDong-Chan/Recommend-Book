package com.example.rb.bookstore;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
@Controller
public class Bookstorecontroller {
    
    private final BookstoreService bookstoreservice;

    
  
    @GetMapping("/bookstore/list")
    public String list(Model model) {
        List<bookentity> bookList = this.bookstoreservice.getList();
        model.addAttribute("bookList", bookList);
        return "bookstorelist";
    }
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<bookentity> paging = this.bookstoreservice.getList(page);
        model.addAttribute("paging", paging);
        return "bookstorelist";
    }
    
  
}



