package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Publisher;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crudTest() {
        Book book = Book.builder().name("JPA 초격차 패키지").build();
        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

    @Test
    void bookRelationTest() {
        givenBookAndReview();

        System.out.println("============================================================================================================================");
        Member member = memberRepository.findByEmail("martin@fastcampus.com");

        System.out.println("Review : " + member.getReviews());
        System.out.println("Book : " + member.getReviews().get(0).getBook());
        System.out.println("Publisher : " + member.getReviews().get(0).getBook().getPublisher());

    }

    private void givenBookAndReview() {
        givenReview(givenMember(), givenBook(givenPublisher()));
    }

    private Member givenMember() {
        return memberRepository.findByEmail("martin@fastcampus.com");
    }

    private Publisher givenPublisher() {
        Publisher publisher = Publisher.builder().name("fastcampus").build();
        return publisherRepository.save(publisher);
    }

    private Book givenBook(Publisher publisher) {
        Book book = Book.builder()
                .name("Jpa 초격차 패키지")
                .publisher(publisher)
                .build();
        return bookRepository.save(book);
    }


    private void givenReview(Member member, Book book) {
        Review review = Review.builder()
                .title("내 인생을 바꾼 책")
                .content("너무 너무 재미있고 즐거운 책이었어요~~")
                .score(5)
                .member(member)
                .book(book)
                .build();
        reviewRepository.save(review);
    }

}