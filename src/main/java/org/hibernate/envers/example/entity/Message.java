package org.hibernate.envers.example.entity;

import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@Entity
@Table(name = "message", schema = "forum")
@Audited
@AuditTable(value = "message_aud", schema = "history")
public class Message {

    @Id
    @SequenceGenerator(name = "message_generator", sequenceName = "message_seq", schema = "forum", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_generator")
    private Long id;

    private String author;

    private String msg;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "forum_id")
    private Forum forum;

}
