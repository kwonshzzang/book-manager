package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByNameIs(String name);
    List<Member> findByNameEquals(String name);


    Member findByEmail(String email);
    Member getByEmail(String email);
    Member readByEmail(String email);
    Member queryByEmail(String email);
    Member searchByEmail(String email);
    Member streamByEmail(String email);
    Member findMemberByEmail(String email);

    Member findFirst1ByName(String name);
    Member findTop1ByName(String name);

    List<Member> findByEmailAndName(String email, String name);
    List<Member> findByEmailOrName(String email, String name);

    List<Member> findByCreatedAtAfter(LocalDateTime yesterday);
    List<Member> findByIdAfter(Long id);


    List<Member> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<Member> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<Member> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<Member> findByIdBetween(Long id1, Long id);
    List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Member> findByIdIsNotNull();
    List<Member> findByNameIn(List<String> names);
    List<Member> findByNameStartingWith(String name);
    List<Member> findByNameEndingWith(String name);
    List<Member> findByNameContains(String name);
    List<Member> findByNameLike(String name);







}
