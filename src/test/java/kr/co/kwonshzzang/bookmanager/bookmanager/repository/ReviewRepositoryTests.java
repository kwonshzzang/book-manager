package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTests {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() {
        System.out.println("============================================================================================================================");
//        List<Review> reviews = reviewRepository.findAll();
//        List<Review> reviews = reviewRepository.findAllByFetchJoin();
//        List<Review> reviews = reviewRepository.findAllByEntityGraph();
        List<Review> reviews = reviewRepository.findAll();

        System.out.println("전체를 가져왔습니다.");

        System.out.println(reviews.get(0) .getComments());
        System.out.println("첫번째 리뷰의 코멘트를 가져왔습니다.");

        System.out.println(reviews.get(1) .getComments());
        System.out.println("두번째 리뷰의 코멘트를 가져왔습니다.");

        System.out.println(reviews.get(2) .getComments());
        System.out.println("세번째 리뷰의 코멘트를 가져왔습니다.");


        System.out.println("============================================================================================================================");
        reviews.forEach(System.out::println);
    }

}