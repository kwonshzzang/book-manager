package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        Book book = Book.builder().name("JPA 초격차 패키지").authorId(1L).build();
        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

}