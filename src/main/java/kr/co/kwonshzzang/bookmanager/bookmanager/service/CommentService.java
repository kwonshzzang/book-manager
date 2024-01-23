package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Comment;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void init() {
        for(int i = 0; i < 10; i++) {
            Comment comment = Comment.builder().comment("최고예요~~~").build();
            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true)
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        for(Comment comment: comments) {
            comment.setComment("별로예요~~");
            commentRepository.save(comment);
        }
    }

    @Transactional
    public void insertSomething() {
        Comment comment = commentRepository.findById(1L).orElseThrow(RuntimeException::new);
        comment.setComment("이건뭐죠?");
        commentRepository.save(comment);
    }
}


