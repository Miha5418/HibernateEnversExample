package org.hibernate.envers.example.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.envers.example.dto.ForumDto;
import org.hibernate.envers.example.service.ForumService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
public class ForumController {

    private final ForumService forumService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createForum(@RequestBody ForumDto dto) {
        forumService.save(dto);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateForum(@RequestBody ForumDto dto) {
        forumService.update(dto);
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteForum(@RequestBody ForumDto dto) {
        forumService.delete(dto);
    }
}
