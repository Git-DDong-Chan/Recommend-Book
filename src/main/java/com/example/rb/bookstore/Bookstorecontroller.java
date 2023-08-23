package com.example.rb.bookstore;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

@RequiredArgsConstructor
@Controller
public class Bookstorecontroller {

    private final BookstoreService bookstoreservice;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/bookstore/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<bookentity> paging = this.bookstoreservice.getList(page, kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        return "bookstorelist";
    }

}
