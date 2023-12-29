package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
    List<MemberHistory> findAllByMemberId(Long memberId);
}
