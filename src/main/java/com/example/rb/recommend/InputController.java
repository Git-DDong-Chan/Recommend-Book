package com.example.rb.recommend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.validation.BindingResult;

import com.example.rb.recommend.InputForm;
import com.example.rb.user.SiteUser;
import com.example.rb.user.UserService;

import java.security.Principal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/recommend")
@RequiredArgsConstructor
@Controller
class InputController {

    private final InputService inputService;
    private final UserService userService;

   @PreAuthorize("isAuthenticated()")
    @GetMapping("/myemotion")
    public String createInput(InputForm inputForm) {
        return "recommend";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/myemotion")
    public String createInput(@Valid InputForm inputForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "recommend";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        Input input = this.inputService.create(inputForm.getContent(), siteUser);
        return "redirect:/recommend/myemotion"; // 질문 저장후 질문목록으로 이동
    }
}
