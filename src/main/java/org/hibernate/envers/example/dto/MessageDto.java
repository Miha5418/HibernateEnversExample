package org.hibernate.envers.example.dto;

import lombok.Data;

@Data
public class MessageDto {

    private Long id;
    private String author;
    private String msg;
    private Long forumId;
}
