package com.example.rb;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rb.bookstore.bookentity;
import com.example.rb.bookstore.bookstoreRepository;

@SpringBootTest
class RbApplicationTests {
	@Autowired
    private bookstoreRepository BookstoreRepository;

	@Test
	void contextLoads() {
	
		for (int i = 6; i <= 10; i++) {
			bookentity b = new bookentity();
			b.setBookname("책 제목 " + i);
			b.setBookcontent("책 내용 " + i);
			b.setBookdate(20230000 + i); // 여기에 적절한 날짜 계산 방법을 사용하세요.
			b.setBookavailable(1);
			this.BookstoreRepository.save(b);
		}
	}

}
