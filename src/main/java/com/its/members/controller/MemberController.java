package com.its.members.controller;

import com.its.members.dto.MemberDTO;
import com.its.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String saveForm(){
        return "/memberSave";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) throws IOException {
       memberService.save(memberDTO);
            return "/memberLogin";

    }

    @PostMapping("/duplicate-check")
    public @ResponseBody String emailDuplicateCheck(@RequestParam("inputEmail") String memberEmail){
        System.out.println("memberEmail = " + memberEmail);
        System.out.println("MemberController.emailDuplicateCheck");
        String duplicateResult = memberService.emailDuplicateCheck(memberEmail);
        return duplicateResult;
    }
}
