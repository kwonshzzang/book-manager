package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Publisher;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Review;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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

    @Test
    void bookCascadeTest() {
        Book book = Book.builder().name("JPA 초격차 패키지").build();

        Publisher publisher = Publisher.builder().name("패스트캠퍼스").build();

        book.setPublisher(publisher);
        bookRepository.save(book);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).orElseThrow(RuntimeException::new);
        book1.getPublisher().setName("슬로우캠퍼스");

        bookRepository.save(book1);

        System.out.println("publisher : " + publisherRepository.findAll());

       System.out.println("============================================================================================================================");
       Book book2  = bookRepository.findById(1L).orElseThrow(RuntimeException::new);
//       bookRepository.delete(book2);

       System.out.println("books : " + bookRepository.findAll());
       System.out.println("publishers : " + publisherRepository.findAll());

        System.out.println("============================================================================================================================");
        Book book3  = bookRepository.findById(1L).orElseThrow(RuntimeException::new);
        book3.setPublisher(null);
        bookRepository.save(book3);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book-publisher : " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDeleted() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));
        bookRepository.findByCategoryIsNull().forEach(System.out::println);
    }

    @Test
    void queryTest() {
        List<Book> result = bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual("JPA 초격차 패키지",
                LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusDays(1L));

        System.out.println("findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual : " + result);
        System.out.println("============================================================================================================================");

        System.out.println("findByNameRecent : " + bookRepository.findByNameRecent("JPA 초격차 패키지", LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusDays(1L)));
        System.out.println("============================================================================================================================");

        System.out.println("findBookNameAndCategory : " + bookRepository.findBookNameAndCategory());
        System.out.println("============================================================================================================================");

        System.out.println("findBookNameAndCategory with page :" + bookRepository.findBookNameAndCategory(PageRequest.of(0, 1)).getContent());
        System.out.println("findBookNameAndCategory with page :" + bookRepository.findBookNameAndCategory(PageRequest.of(1, 1)).getContent());

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