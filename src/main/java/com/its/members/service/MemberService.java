package com.its.members.service;

import com.its.members.dto.MemberDTO;
import com.its.members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) throws IOException {
//        int saveResult = memberRepository.save(memberDTO);
//        if(saveResult > 0){
//            return true;
//        }else {
//            return false;
//        }
        if (!memberDTO.getMemberFile().isEmpty()) {
            MultipartFile memberFile = memberDTO.getMemberFile();
            String originalFileName = memberFile.getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "-" + originalFileName;
            memberDTO.setOriginalFileName_profile(originalFileName);
            memberDTO.setStoredFileName_profile(storedFileName);
            String savePath = "C:\\spring_img" + storedFileName;
            memberFile.transferTo(new File(savePath));
            memberDTO.setMemberProfile(1);
            MemberDTO saveMember = memberRepository.save(memberDTO);
            memberRepository.saveFileName(saveMember);
        } else {
            memberDTO.setMemberProfile(0);
            memberRepository.save(memberDTO);
        }
    }
    public String emailDuplicateCheck(String memberEmail) {
        String duplicateResult = memberRepository.emailDuplicateCheck(memberEmail);
        if (duplicateResult == null) {
            return "ok";
        } else {
            return "no";
        }
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginResult = memberRepository.login(memberDTO);
        if(loginResult != null){
            return true;
        }else{
            return false;
        }
    }
}
