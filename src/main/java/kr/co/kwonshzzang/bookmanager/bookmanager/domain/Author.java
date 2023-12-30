package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Author extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
//    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

}
