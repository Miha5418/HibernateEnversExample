package org.hibernate.envers.example.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.example.dto.MessageDto;
import org.hibernate.envers.example.entity.ParentEntity;
import org.hibernate.envers.example.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createForum(@RequestBody MessageDto dto) {
        messageService.save(dto);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateForum(@RequestBody MessageDto dto) {
        messageService.update(dto);
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteForum(@RequestBody MessageDto dto) {
        messageService.delete(dto);
    }
}
