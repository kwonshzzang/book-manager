package kr.co.kwonshzzang.bookmanager.bookmanager.domain.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import kr.co.kwonshzzang.bookmanager.bookmanager.domain.listener.Auditable;

import java.time.LocalDateTime;

public class MyEntityListener {
    @PrePersist
    public void prePersist(Object o) {
        if(o instanceof Auditable) {
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object o) {
        if(o instanceof Auditable) {
            ((Auditable)o).setUpdatedAt(LocalDateTime.now());
        }
    }

}
