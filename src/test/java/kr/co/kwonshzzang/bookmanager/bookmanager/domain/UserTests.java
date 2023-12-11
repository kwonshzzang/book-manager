package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class UserTests {

    @Test
    void test() {
        User user = new User();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");

        System.out.println(user);

        User user1 = new User("martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
        System.out.println(user1);


        User user2 = new User("martin", "martin@fastcampus.com");
        System.out.println(user2);

        User user3 = User.builder()
                .name("martin")
                .email("martin@fastcampus.com")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        System.out.println(user3);
    }

}