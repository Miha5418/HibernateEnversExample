package org.hibernate.envers.example.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class ParentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

}
