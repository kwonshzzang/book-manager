package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class MemberTests {

    @Test
    void test() {
        Member member = new Member();
        member.setEmail("martin@fastcampus.com");
        member.setName("martin");

        System.out.println(member);

        Member member1 = new Member(null,"martin", "martin@fastcampus.com", Gender.MALE, LocalDateTime.now(), LocalDateTime.now());
        System.out.println(member1);


        Member member2 = new Member("martin", "martin@fastcampus.com");
        System.out.println(member2);

        Member member3 = Member.builder()
                .name("martin")
                .email("martin@fastcampus.com")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        System.out.println(member3);
    }

}