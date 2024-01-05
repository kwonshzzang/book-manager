package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Author;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.AuthorRepository;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    @Transactional
    public void putBookAndAuthor() {
        Book book = Book.builder().name("JPA 시작하기").build();
        bookRepository.save(book);

        Author author = Author.builder().name("martin").build();
        authorRepository.save(author);
    }

}
