package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@EntityListeners(value = MyEntityListener.class)
//@Table(name = "member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Member implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    //@Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //@Column(name = "crtdat")
    //@Column(nullable = false)
    //@Column(updatable = false)
    private LocalDateTime createdAt;

    //@Column(insertable = false)
    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void postUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }

//    @Transient
//    private String testData;

//    @PrePersist
//    public void prePersist() {
//        System.out.println(">>> prePersist....");
//    }
//
//    @PostPersist
//    public void postPersist() {
//        System.out.println(">>> postPersist....");
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        System.out.println(">>> preUpdate....");
//    }
//
//    @PostUpdate
//    public void postUpdate() {
//        System.out.println(">>> postUpdate...");
//    }
//
//    @PreRemove
//    public void preRemove() {
//        System.out.println(">>> preRemove....");
//    }
//
//    @PostRemove
//    public void postRemove() {
//        System.out.println(">>> postRemove....");
//    }
//
//    @PostLoad
//    public void postLoad() {
//        System.out.println(">>> postLoad....");
//    }

}
