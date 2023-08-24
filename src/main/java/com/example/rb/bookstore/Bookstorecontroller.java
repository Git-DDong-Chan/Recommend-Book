package com.example.rb.bookstore;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rb.user.UserService;

import org.springframework.data.domain.Page;

@RequiredArgsConstructor
@Controller
public class Bookstorecontroller {

    private final BookstoreService bookstoreservice;
    private final UserService userService;

    
  
    @GetMapping("/bookstore/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,@RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<bookentity> paging =this.bookstoreservice.getList(page,kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        model.addAttribute("loggedInUsername", loggedInUsername);
        return "bookstorelist";
    }
    
  
}
