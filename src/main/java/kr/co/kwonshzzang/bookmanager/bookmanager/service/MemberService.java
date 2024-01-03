package kr.co.kwonshzzang.bookmanager.bookmanager.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final EntityManager entityManager;
    private final MemberRepository memberRepository;


    @Transactional
    public void put() {
        //비영속상태(new/transient)
        Member member = Member.builder().name("newMember").email("newMember@fastcampus.com").build();

        //영속상태(managed) : 영속성 컨텐스트에서 관리(저장)되는 상태
        entityManager.persist(member);

        //준영속상태(detached) : 영속성 컨텍스트에서 관리되었다가 분리된 상태, detach, clear, close
        entityManager.detach(member);

        member.setName("newMemberAfterPersist");
        //다시 영속 상태로
        entityManager.merge(member);
        //영속성 컨텍스트를 DB로 반영
        entityManager.flush();
        //다시 준영속상태로
        entityManager.clear();

        //삭제상태 : 엔티티를 영속성 컨텍스트와 DB에서 삭제한 상태
        Member member1 = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        entityManager.remove(member1);

//        member1.setName("1111111");
//        entityManager.merge(member1);


    }
}
