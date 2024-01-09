package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Author;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void putAuthor() {
        Author author = Author.builder().name("martin").build();
        authorRepository.save(author);
//        throw new RuntimeException("오류가 발생하였습니다. 트랜잭션은 어떻게 될까요?");
    }
}
