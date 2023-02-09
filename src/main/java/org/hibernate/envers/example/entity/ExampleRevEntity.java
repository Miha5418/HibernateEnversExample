package org.hibernate.envers.example.entity;

import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.hibernate.envers.example.service.ExampleListener;

import javax.persistence.*;


@Data
@Entity
@RevisionEntity(ExampleListener.class)
@Table(name = "REVINFO", schema = "history")
public class ExampleRevEntity {

    @Id
    @RevisionNumber
    @GeneratedValue(generator = "CustomerAuditRevisionSeq")
    @SequenceGenerator(name = "CustomerAuditRevisionSeq", sequenceName = "customer_audit_revision_seq", schema = "history", allocationSize = 1)
    private int id;

    @RevisionTimestamp
    private long timestamp;

    private String username;

}
