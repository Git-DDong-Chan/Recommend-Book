package com.example.rb.bookstore;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rb.user.UserService;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
@Controller
public class Bookstorecontroller {
    
    private final BookstoreService bookstoreservice;
    private final UserService userService;

    
   @PreAuthorize("isAuthenticated()")
    @GetMapping("/bookstore/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,@RequestParam(value = "kw", defaultValue = "") String kw) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Page<bookentity> paging =this.bookstoreservice.getList(page,kw);

        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        model.addAttribute("loggedInUsername", loggedInUsername);
        return "bookstorelist";
    }

   
    
  
}

