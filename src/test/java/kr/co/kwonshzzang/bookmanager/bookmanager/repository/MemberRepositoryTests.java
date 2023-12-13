package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import jakarta.transaction.Transactional;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
//    @Transactional
    void crudTest() { //create, read, update, delete
       System.out.println("============================================================================================================================");
       List<Member> members1 = memberRepository.findAll();
       members1.forEach(System.out::println);

       System.out.println("============================================================================================================================");
       List<Member> members2 = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
       members2.forEach(System.out::println);

       System.out.println("============================================================================================================================");
       List<Member> members3 = memberRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
       members3.forEach(System.out::println);

       System.out.println("===========================================================================================================================");
       Member member1 = Member.builder().name("jack").email("jack@fastcampus.com").build();
       Member member2 = Member.builder().name("steve").email("steve@fastcampus.com").build();
       memberRepository.saveAll(Lists.newArrayList(member1, member2));
       memberRepository.findAll().forEach(System.out::println);

        System.out.println("===========================================================================================================================");
        memberRepository.save(Member.builder().name("jack").email("jack@fastcampus.com").build());
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
       /* Member member3 = memberRepository.getOne(1L);
        System.out.println(member3);*/

        Member member3 = memberRepository.findById(1L).orElse(null);
        System.out.println(member3);


    }

}