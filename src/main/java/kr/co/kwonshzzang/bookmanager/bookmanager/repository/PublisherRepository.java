package kr.co.kwonshzzang.bookmanager.bookmanager.repository;

import kr.co.kwonshzzang.bookmanager.bookmanager.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
