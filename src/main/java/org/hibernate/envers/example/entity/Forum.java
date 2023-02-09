package org.hibernate.envers.example.entity;

import lombok.Data;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "forum", schema = "forum")
@Audited
@AuditTable(value = "forum_aud", schema = "history")
@AuditOverride(forClass = ParentEntity.class)
public class Forum extends ParentEntity{

    @Id
    @SequenceGenerator(name = "forum_generator", sequenceName = "forum_seq", schema = "forum", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forum_generator")
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "forum", fetch = FetchType.LAZY)
    @AuditJoinTable
    private List<Message> messages;
}
