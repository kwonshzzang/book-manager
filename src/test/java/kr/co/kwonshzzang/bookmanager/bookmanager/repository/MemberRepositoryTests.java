package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import jakarta.transaction.Transactional;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Gender;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
//    @Transactional
    void crudTest1() { //create, read, update, delete
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

    @Test
    void crudTest2() {
        System.out.println("============================================================================================================================");
        memberRepository.save(Member.builder().name("new martin").email("newmartin@fastcampus.com").build());
        memberRepository.flush();
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        memberRepository.saveAndFlush(Member.builder().name("new martin").email("newmartin@fastcampus.com").build());
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        long count = memberRepository.count();
        System.out.println("count : " + count);

        System.out.println("============================================================================================================================");
        boolean exists = memberRepository.existsById(1L);
        System.out.println("exists : " + exists);

        System.out.println("============================================================================================================================");
        memberRepository.delete(memberRepository.findById(1L).orElseThrow(RuntimeException::new));
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        memberRepository.deleteById(2L);
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
//        memberRepository.deleteAll();
        memberRepository.deleteAll(memberRepository.findAllById(Lists.newArrayList(2L, 3L)));
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        memberRepository.deleteAllInBatch(memberRepository.findAllById(Lists.newArrayList(4L, 5L)));
        memberRepository.findAll().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        memberRepository.deleteAllInBatch();
        memberRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crudTest3() {
        System.out.println("============================================================================================================================");
        memberRepository.findAll().forEach(System.out::println);
        Page<Member> members = memberRepository.findAll(PageRequest.of(1, 3));

        System.out.println(members);
        System.out.println("totalElements : " + members.getTotalElements());
        System.out.println("totalPages : " + members.getTotalPages());
        System.out.println("numberOfElements : " + members.getNumberOfElements());
        System.out.println("sort : " + members.getSort());
        System.out.println("size : " + members.getSize());
        members.getContent().forEach(System.out::println);

        System.out.println("============================================================================================================================");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<Member> example = Example.of(Member.builder().name("ma").email("fastcampus.com").build(), matcher);
        memberRepository.findAll(example).forEach(System.out::println);

        System.out.println("============================================================================================================================");
        memberRepository.findAll(Example.of(Member.builder().name("martin").email("martin@fastcampus.com").build()))
                .forEach(System.out::println);

        System.out.println("============================================================================================================================");
        Member member = new Member();
        member.setEmail("slow");
        ExampleMatcher matcher1 = ExampleMatcher.matching()
                .withMatcher("email", contains());
        memberRepository.findAll(Example.of(member, matcher1)).forEach(System.out::println);
    }

    @Test
    void crudTest4() {
        memberRepository.save(Member.builder().name("david").email("david@fastcampus").build());
        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setEmail("martin-updated@fastcampus.com");
        memberRepository.save(member);
    }

    @Test
    void queryMethod1() {
        System.out.println("============================================================================================================================");
//        System.out.println(memberRepository.findByName("martin"));
        System.out.println(memberRepository.findByName("dennis"));

        System.out.println("============================================================================================================================");
        System.out.println("findByEmail : " + memberRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + memberRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + memberRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + memberRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + memberRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + memberRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findMemberByEmail : " + memberRepository.findMemberByEmail("martin@fastcampus.com"));

        System.out.println("============================================================================================================================");
        System.out.println("findFirst1ByName : " + memberRepository.findFirst1ByName("martin"));
        System.out.println("findTop1ByName : " + memberRepository.findTop1ByName("martin"));
    }

    @Test
    void queryMethod2() {
        System.out.println("============================================================================================================================");
        System.out.println("findByEmailAndName : " + memberRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + memberRepository.findByEmailOrName("martin@fastcampus.com", "martin"));
        System.out.println("============================================================================================================================");
        System.out.println("findByCreatedAtAfter : " + memberRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + memberRepository.findByIdAfter(4L));
        System.out.println("============================================================================================================================");
        System.out.println("findByCreatedAtGreaterThan : " + memberRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + memberRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtBetween : " + memberRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + memberRepository.findByIdBetween(3L, 5L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + memberRepository.findByIdGreaterThanEqualAndIdLessThanEqual(3L, 5L));
    }

    @Test
    void queryMethod3() {
        System.out.println("============================================================================================================================");
        System.out.println("findByIdIsNotNull : " + memberRepository.findByIdIsNotNull());
        System.out.println("findByNameIn : " + memberRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));
        System.out.println("findByNameStartingWith : " + memberRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + memberRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + memberRepository.findByNameContains("art"));
        System.out.println("findByNameLike : " + memberRepository.findByNameLike("mar%"));
        System.out.println("findByNameLike : " + memberRepository.findByNameLike("%tin"));
        System.out.println("findByNameLike : " + memberRepository.findByNameLike("%art%"));
        System.out.println("findByNameLike : " + memberRepository.findByNameLike("%art%"));
        System.out.println("findByNameIs : " + memberRepository.findByNameIs("martin"));
        System.out.println("findByNameEquals : " + memberRepository.findByNameEquals("martin"));
    }

    @Test
    void queryMethod4() {
        System.out.println("============================================================================================================================");
        System.out.println("findTop1ByName : " + memberRepository.findTop1ByName("martin"));
        System.out.println("============================================================================================================================");
        System.out.println("findTop1ByNameOrderByIdDesc : " + memberRepository.findTop1ByNameOrderByIdDesc("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " + memberRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("============================================================================================================================");
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + memberRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("============================================================================================================================");
        System.out.println("findFirstByName : " + memberRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"))));
        System.out.println("findFirstByName : " + memberRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
    }

    @Test
    void pagingMethod() {
        System.out.println("============================================================================================================================");
        System.out.println("findByNameWithPaging : " + memberRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    void insertAndUpdate() {
        System.out.println("============================================================================================================================");
        Member member = new Member();

        member.setName("martin");
        member.setEmail("martin@fastcampus.com");

        memberRepository.save(member);

        System.out.println("============================================================================================================================");
        Member member2 = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member2.setName("marrrrrrtin");

        memberRepository.save(member2);
    }

    @Test
    void enumTest() {
        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setGender(Gender.MALE);

        memberRepository.save(member);

        System.out.println("============================================================================================================================");
        memberRepository.findAll().forEach(System.out::println);
        System.out.println("============================================================================================================================");
        System.out.println(memberRepository.findRowRecord().get("gender"));
    }

}