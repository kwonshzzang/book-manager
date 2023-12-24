package kr.co.kwonshzzang.bookmanager.bookmanager.domain.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.MemberHistory;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.MemberHistoryRepository;
import kr.co.kwonshzzang.bookmanager.bookmanager.support.BeanUtils;

public class MemberEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = MemberHistory.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
        memberHistoryRepository.save(memberHistory);
    }

}
