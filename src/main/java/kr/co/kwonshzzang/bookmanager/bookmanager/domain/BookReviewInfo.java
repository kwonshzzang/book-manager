package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;
    @OneToOne(optional = false)
    private Book book;
    private float averageReviewScore;
    private int reviewCount;

}
