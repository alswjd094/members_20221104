package com.its.members.service;

import com.its.members.commons.PagingConst;
import com.its.members.dto.MemberDTO;
import com.its.members.dto.PageDTO;
import com.its.members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            System.out.println("originalFileName = " + originalFileName);
            String storedFileName = System.currentTimeMillis() + "-" + originalFileName;
            System.out.println("storedFileName = " + storedFileName);
            memberDTO.setOriginalFileName_profile(originalFileName);
            memberDTO.setStoredFileName_profile(storedFileName);
            String savePath = "C:\\spring_img_profile\\" + storedFileName;
            memberFile.transferTo(new File(savePath));
            memberDTO.setFileAttached_members(1);

            memberDTO.setMemberProfile(memberDTO.getStoredFileName_profile());

            MemberDTO saveMember = memberRepository.save(memberDTO);
            memberRepository.saveFileName(saveMember);

        } else {
            memberDTO.setFileAttached_members(0);
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

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO memberFindById(Long id) {

        return memberRepository.memberFindById(id);
    }

    public void delete(Long id) {

        memberRepository.delete(id);
    }


    public MemberDTO myPageForm(String memberEmail) {

        return memberRepository.myPageForm(memberEmail);
    }

    public boolean myPage(MemberDTO memberDTO) {
        int myPageResult = memberRepository.myPage(memberDTO);
        if(myPageResult > 0){
            return true;
        }else{
            return false;
        }
    }
}
