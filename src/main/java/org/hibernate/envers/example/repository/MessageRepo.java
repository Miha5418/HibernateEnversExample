package org.hibernate.envers.example.repository;

import org.hibernate.envers.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
