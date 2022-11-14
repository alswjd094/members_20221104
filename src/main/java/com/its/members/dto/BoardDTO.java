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
    private Long boardId;

    private MultipartFile boardFile;
    private String originalFileName_boards;
    private String storedFileName_boards;
    private int fileAttached_boards;
    private Long boardFileId;
}
