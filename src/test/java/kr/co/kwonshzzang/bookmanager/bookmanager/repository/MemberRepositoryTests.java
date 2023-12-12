package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTests {
    @Autowired
    private MemberRepository userRepository;

    @Test
    void crudTest() { //create, read, update, delete
        userRepository.save(new Member());

        System.out.println(">>>>> " + userRepository.findAll());
    }

}