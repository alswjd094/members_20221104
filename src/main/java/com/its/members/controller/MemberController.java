package com.its.members.controller;

import com.its.members.dto.MemberDTO;
import com.its.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/login")
    public String loginForm(){
        return "/memberLogin";
    }

    @PostMapping ("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session){
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult) {
            session.setAttribute("loginEmail",memberDTO.getMemberEmail());
            model.addAttribute("modelEmail", memberDTO.getMemberEmail());
            return "memberMain";
        }else{
            return "memberLogin";
        }
    }
}
