package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import jakarta.persistence.Tuple;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Book;
import kr.co.kwonshzzang.bookmanager.bookmanager.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query(value = "update book set category ='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();

    List<Book> findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

//    @Query(value = "select b from Book b where b.name = ?1 and b.createdAt >= ?2 and b.updatedAt >= ?3 and b.category is null")
//    List<Book> findByNameRecent(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

    @Query(value = "select b from Book b where b.name = :name and b.createdAt >= :createdAt and b.updatedAt >= :updatedAt and b.category is null")
    List<Book> findByNameRecent(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt);

    @Query(value = "select new kr.co.kwonshzzang.bookmanager.bookmanager.dto.BookNameAndCategory(b.name, b.category) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new kr.co.kwonshzzang.bookmanager.bookmanager.dto.BookNameAndCategory(b.name, b.category) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable page);
}
