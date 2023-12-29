package kr.co.kwonshzzang.bookmanager.bookmanager.domain.listener;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Member;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.MemberHistory;
import kr.co.kwonshzzang.bookmanager.bookmanager.repository.MemberHistoryRepository;
import kr.co.kwonshzzang.bookmanager.bookmanager.support.BeanUtils;

public class MemberEntityListener {
    @PostPersist
    @PostUpdate
    public void postPersistAndPreUpdate(Object o) {
        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = MemberHistory.builder()
                .member(member)
                .name(member.getName())
                .email(member.getEmail())
                .build();
        memberHistoryRepository.save(memberHistory);
    }

}
