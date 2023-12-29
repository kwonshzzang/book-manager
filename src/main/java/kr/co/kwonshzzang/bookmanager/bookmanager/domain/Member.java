package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import jakarta.persistence.*;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.listener.MemberEntityListener;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Entity
@EntityListeners(value =  MemberEntityListener.class)
//@Table(name = "member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Member extends BaseEntity {
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="member_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<MemberHistory> memberHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    //@Column(name = "crtdat")
    //@Column(nullable = false)
    //@Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    //@Column(insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

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
