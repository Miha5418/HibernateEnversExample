package org.hibernate.envers.example.service;

import org.hibernate.envers.RevisionListener;
import org.hibernate.envers.example.entity.ExampleRevEntity;

public class ExampleListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        ExampleRevEntity exampleRevEntity = (ExampleRevEntity) revisionEntity;

        exampleRevEntity.setUsername("UserName");
    }
}
