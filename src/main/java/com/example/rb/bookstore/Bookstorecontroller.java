package com.example.rb.bookstore;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

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
}



