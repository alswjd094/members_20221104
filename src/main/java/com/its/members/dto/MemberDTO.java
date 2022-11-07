package com.its.members.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberMobile;

    private MultipartFile memberFile;
    private String originalFileName_profile;
    private String storedFileName_profile;
    private int memberProfile;
}
