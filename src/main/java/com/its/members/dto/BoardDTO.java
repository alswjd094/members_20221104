package com.its.members.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedDate;
    private int boardId;

    private MultipartFile boardFile;
    private String originalFileName_member;
    private String storedFileName_member;
    private int boardFileName;
}
