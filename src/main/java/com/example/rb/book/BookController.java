package com.example.rb.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

import java.security.Principal;
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

import com.example.rb.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;
   
   


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
@Autowired
private UserService userService;

@PreAuthorize("isAuthenticated()")
@GetMapping("/bookstore/list")
public String list(Model model,
    @RequestParam(value = "kw", defaultValue = "") String kw, Principal principal, @RequestParam(value = "page", defaultValue = "0") int page) {

    String loggedInUsername = principal.getName(); // 현재 로그인한 사용자의 이름
    // 아래와 같이 ID 값을 가져올 수 있을 것입니다. (ID 값이 어떤 필드에 저장되어 있는지에 따라 다를 수 있습니다.)
    Long loggedInUserId = userService.getUserIdByUsername(loggedInUsername);

    Page<Book> paging = this.bookService.getList(kw,loggedInUserId ,page);

    model.addAttribute("loggedInUserId", loggedInUsername);
    model.addAttribute("paging", paging);
    model.addAttribute("kw", kw);

    return "bookstorelist";
}
   @PreAuthorize("isAuthenticated()")
    @GetMapping("/books")
    public String listBooks(Model model,Principal principal) {
     String loggedInUsername1 = principal.getName(); // 현재 로그인한 사용자의 이름
    // 아래와 같이 ID 값을 가져올 수 있을 것입니다. (ID 값이 어떤 필드에 저장되어 있는지에 따라 다를 수 있습니다.)
      Long loggedInUserId1 = userService.getUserIdByUsername(loggedInUsername1);

        List<Book> books = bookRepository.findByCheck(loggedInUserId1,1);
        model.addAttribute("books", books);
        return "book-list";
    }
   @PreAuthorize("isAuthenticated()")
    @GetMapping("/recommend/list")
    public String listrecommendBooks(Model model,Principal principal) {
        String loggedInUsername1 = principal.getName(); // 현재 로그인한 사용자의 이름
      // 아래와 같이 ID 값을 가져올 수 있을 것입니다. (ID 값이 어떤 필드에 저장되어 있는지에 따라 다를 수 있습니다.)
      Long loggedInUserId1 = userService.getUserIdByUsername(loggedInUsername1);

        List<Book> books = bookRepository.findByCheck(loggedInUserId1,0);
        model.addAttribute("books", books);
        return "recommend_list";
    }
    @PostMapping("/recommend/delete-checks-zero")
    public String deleteChecks(Principal principal) {
        String loggedInUsername1 = principal.getName(); // 현재 로그인한 사용자의 이름
      // 아래와 같이 ID 값을 가져올 수 있을 것입니다. (ID 값이 어떤 필드에 저장되어 있는지에 따라 다를 수 있습니다.)
      Long loggedInUserId1 = userService.getUserIdByUsername(loggedInUsername1);
        bookService.deleteChecks(loggedInUserId1);
        return "redirect:/books";
    }


}