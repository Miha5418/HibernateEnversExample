package org.hibernate.envers.example.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.hibernate.envers.example.dto.ForumDto;
import org.hibernate.envers.example.entity.Forum;
import org.hibernate.envers.example.repository.ForumRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ForumService {

    private final ForumRepo forumRepo;


    @Transactional
    public void save(ForumDto dto) {

        Forum entity = new Forum();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        forumRepo.save(entity);
    }

    @Transactional
    public void update(ForumDto dto) {
        val entity = forumRepo.getById(dto.getId());

        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        forumRepo.save(entity);
    }

    @Transactional
    public void delete(ForumDto dto) {
        forumRepo.deleteById(dto.getId());
    }
}