package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Author;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.BookAndAuthor;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTests {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;

    @Test
    void manyToManyTest() {
        Book book1 = givenBook("책1");
        Book book2 = givenBook("책2");
        Book book3 = givenBook("개발책1");
        Book book4 = givenBook("개발책2");

        Author author1 = givenAuthor("martin");
        Author author2 = givenAuthor("steve");

        BookAndAuthor bookAndAuthor1 = givenBookAndAuthor(book1, author1);
        BookAndAuthor bookAndAuthor2 = givenBookAndAuthor(book2, author2);
        BookAndAuthor bookAndAuthor3 = givenBookAndAuthor(book3, author1);
        BookAndAuthor bookAndAuthor4 = givenBookAndAuthor(book3, author2);
        BookAndAuthor bookAndAuthor5 = givenBookAndAuthor(book4, author1);
        BookAndAuthor bookAndAuthor6 = givenBookAndAuthor(book4, author2);

//
//        book1.setAuthors(Lists.newArrayList(author1));
//        book2.setAuthors(Lists.newArrayList(author2));
//        book3.setAuthors(Lists.newArrayList(author1, author2));
//        book4.setAuthors(Lists.newArrayList(author1, author2));
//
//        author1.setBooks(Lists.newArrayList(book1, book3, book4));
//        author2.setBooks(Lists.newArrayList(book2, book3, book4));

        book1.setBookAndAuthors(Lists.newArrayList(bookAndAuthor1));
        book2.setBookAndAuthors(Lists.newArrayList(bookAndAuthor2));
        book3.setBookAndAuthors(Lists.newArrayList(bookAndAuthor3, bookAndAuthor4));
        book4.setBookAndAuthors(Lists.newArrayList(bookAndAuthor5, bookAndAuthor6));

        author1.setBookAndAuthors(Lists.newArrayList(bookAndAuthor1, bookAndAuthor3, bookAndAuthor5));
        author2.setBookAndAuthors(Lists.newArrayList(bookAndAuthor2, bookAndAuthor4, bookAndAuthor6));

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));
        bookAndAuthorRepository.saveAll(Lists.newArrayList(bookAndAuthor1, bookAndAuthor2, bookAndAuthor3, bookAndAuthor4, bookAndAuthor5, bookAndAuthor6));


        System.out.println("============================================================================================================================");
        bookRepository.findAll().forEach(System.out::println);
        authorRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        bookRepository.findAll().get(2).getBookAndAuthors().forEach(bookAndAuthor -> System.out.println(bookAndAuthor.getAuthor()));
        authorRepository.findAll().get(0).getBookAndAuthors().forEach(bookAndAuthor -> System.out.println(bookAndAuthor.getBook()));

    }

    private Book givenBook(String name) {
        Book book = Book.builder().name(name).build();
        return bookRepository.save(book);
    }

    private Author givenAuthor(String name) {
        Author author = Author.builder().name(name).build();
        return authorRepository.save(author);
    }

    private BookAndAuthor givenBookAndAuthor(Book book, Author author) {
        BookAndAuthor bookAndAuthor = BookAndAuthor.builder().book(book).author(author).build();
        return bookAndAuthorRepository.save(bookAndAuthor);
    }

}