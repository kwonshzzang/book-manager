package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import kr.co.kwonshzzang.bookmanager.bookmanager.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberServiceTest() {
        memberService.put();

        System.out.println(">>>> " + memberRepository.findByEmail("newMember@fastcampus.com"));

        memberRepository.findAll().forEach(System.out::println);


    }

}