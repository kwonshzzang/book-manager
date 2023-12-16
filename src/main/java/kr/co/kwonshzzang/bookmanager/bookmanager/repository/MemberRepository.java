package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    Member findByEmail(String email);
    Member getByEmail(String email);
    Member readByEmail(String email);
    Member queryByEmail(String email);
    Member searchByEmail(String email);
    Member streamByEmail(String email);
    Member findMemberByEmail(String email);

    Member findFirst1ByName(String name);
    Member findTop1ByName(String name);



}
