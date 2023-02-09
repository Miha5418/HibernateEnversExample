package org.hibernate.envers.example.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.hibernate.envers.example.dto.ForumDto;
import org.hibernate.envers.example.dto.MessageDto;
import org.hibernate.envers.example.entity.Forum;
import org.hibernate.envers.example.entity.Message;
import org.hibernate.envers.example.repository.ForumRepo;
import org.hibernate.envers.example.repository.MessageRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;
    private final ForumRepo forumRepo;


    @Transactional
    public void save(MessageDto dto) {

        val forum = forumRepo.getById(dto.getForumId());

        Message entity = new Message();
        entity.setAuthor(dto.getAuthor());
        entity.setMsg(dto.getMsg());
        entity.setForum(forum);

        messageRepo.save(entity);

    }

    @Transactional
    public void update(MessageDto dto) {
        val forum = forumRepo.getById(dto.getForumId());
        val message = messageRepo.getById(dto.getId());

        message.setForum(forum);
        message.setMsg(dto.getMsg());
        message.setAuthor(dto.getAuthor());
        messageRepo.save(message);
    }

    @Transactional
    public void delete(MessageDto dto) {
        messageRepo.deleteById(dto.getId());
    }


}
