package com.example.rb.recommend;


import com.example.rb.user.SiteUser;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InputService {

    private final InputRepository inputRepository;

    public Input create(String content, String user) {
        Input i = new Input();
        i.setContent(content);
        i.setUsername(user);
        return this.inputRepository.save(i);
    }
}
