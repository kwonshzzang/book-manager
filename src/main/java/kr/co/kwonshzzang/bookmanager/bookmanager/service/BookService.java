package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import jakarta.persistence.EntityManager;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Author;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.AuthorRepository;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() {
        Book book = Book.builder().name("JPA 시작하기").build();
        bookRepository.save(book);

        try {
            authorService.putAuthor();
        } catch (RuntimeException e) {

        }

//        Author author = Author.builder().name("martin").build();
//        authorRepository.save(author);
//
        throw new RuntimeException("오류가 발생하였습니다. 트랜잭션은 어떻게 될까요?");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id) {
        System.out.println(">>>> " + bookRepository.findById(id));
        System.out.println(">>>> " + bookRepository.findAll());
        entityManager.clear();

        System.out.println(">>>> " + bookRepository.findById(id));
        System.out.println(">>>> " + bookRepository.findAll());

        bookRepository.update();
        entityManager.clear();

//        Book book = bookRepository.findById(id).get();
//        book.setName("바뀔까?");
//        bookRepository.save(book);

    }

}
