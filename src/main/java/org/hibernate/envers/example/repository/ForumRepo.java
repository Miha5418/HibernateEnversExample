package org.hibernate.envers.example.repository;

import org.hibernate.envers.example.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepo extends JpaRepository<Forum, Long> {
}
