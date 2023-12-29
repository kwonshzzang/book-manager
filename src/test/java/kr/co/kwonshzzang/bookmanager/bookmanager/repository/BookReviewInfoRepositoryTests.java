package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTests {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest1() {
        System.out.println("============================================================================================================================");
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder().book(givenBook()).averageReviewScore(4.5f).reviewCount(2).build();
        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        System.out.println("============================================================================================================================");
        givenBook();
        givenBookReviewInfo();

        System.out.println(">>>  " + bookRepository.findAll());
        System.out.println(">>>  " + bookReviewInfoRepository.findAll());

        Book result = bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBook();

        System.out.println(">>>  "  + result);

        BookReviewInfo bookReviewInfo = result.getBookReviewInfo();

        System.out.println(">>>  "  + bookReviewInfo);


    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder().book(givenBook()).averageReviewScore(4.5f).reviewCount(2).build();
        bookReviewInfoRepository.save(bookReviewInfo);
    }

    private Book givenBook() {
        Book book = Book.builder().name("Jpa 초격차 패키지").build();
        return bookRepository.save(book);
    }

}