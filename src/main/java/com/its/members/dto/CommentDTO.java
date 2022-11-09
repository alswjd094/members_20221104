package com.its.members.dto;

import lombok.*;

import java.security.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String commentWriter;
    private String commentContents;
    private Long commentId;
    private Timestamp commentCreatedDate;
}
