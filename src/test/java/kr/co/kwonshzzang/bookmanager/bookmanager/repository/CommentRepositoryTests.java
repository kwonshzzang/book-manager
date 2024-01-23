package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTests {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    void commentTest() {
        Comment comment = Comment.builder().comment("별로예요").build();
//        comment.setCommentedAt(LocalDateTime.now());
        commentRepository.saveAndFlush(comment);
//
        entityManager.clear();

//        System.out.println(commentRepository.findById(3L).get());

        System.out.println(comment);

        commentRepository.findAll().forEach(System.out::println);

    }

}