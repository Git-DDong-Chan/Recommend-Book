package com.example.rb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String root() {
        return "redirect:/bookstore/list";
    }
}
