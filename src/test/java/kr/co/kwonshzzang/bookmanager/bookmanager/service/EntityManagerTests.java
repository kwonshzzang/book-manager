package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class EntityManagerTests {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select m from Member m").getResultList());
    }

    @Test
    void cacheFindTest() {
        System.out.println("============================================================================================================================");
        System.out.println(memberRepository.findById(1L).orElseThrow(RuntimeException::new));
        System.out.println(memberRepository.findById(1L).orElseThrow(RuntimeException::new));
        System.out.println(memberRepository.findById(1L).orElseThrow(RuntimeException::new));

        System.out.println("============================================================================================================================");
        System.out.println(memberRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(memberRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(memberRepository.findByEmail("martin@fastcampus.com"));

    }

    @Test
    void cacheFindTest2() {
        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setName("marrrrrrrtin");

        memberRepository.save(member);

        member.setEmail("marrrrrtin@fastcampus.com");

        memberRepository.save(member);

        System.out.println(memberRepository.findAll());
    }
}
