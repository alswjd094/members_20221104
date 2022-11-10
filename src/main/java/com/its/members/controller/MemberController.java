package com.its.members.controller;

import com.its.members.dto.BoardDTO;
import com.its.members.dto.MemberDTO;
import com.its.members.dto.PageDTO;
import com.its.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return"index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/members")
    public String findAll(Model model){
        List<MemberDTO> memberList = memberService.findAll();
        model.addAttribute("memberList",memberList);
        System.out.println("memberList = " + memberList);
        return "memberList";
    }

    @GetMapping("/memberFindById")
    public String findById(@RequestParam("id") Long id,Model model){
        MemberDTO deleteForm = memberService.memberFindById(id);
        model.addAttribute("memberFindById",deleteForm);
        System.out.println("deleteForm = " + deleteForm);
        System.out.println("id = " + id + ", model = " + model);
        System.out.println("MemberController.memberFindById");
        return "memberDetail";
    }
    @GetMapping("/delete")
    public String delete (@RequestParam ("id") Long id){
        memberService.delete(id);
        return "redirect:/members";
    }
    @GetMapping("/myPage")
    public String myPageForm(Model model, HttpSession session){
        String memberEmail = (String) session.getAttribute("loginEmail");
        MemberDTO myPageForm = memberService.myPageForm(memberEmail);
        model.addAttribute("findByEmail",myPageForm);
        return "myPage";
    }

    @PostMapping("/myPage")
    public String myPage(@ModelAttribute MemberDTO memberDTO) {
        boolean myPageResult = memberService.myPage(memberDTO);
        if (myPageResult) {
            return "redirect:/memberFindById?id=" + memberDTO.getId();
        }else{
            return"index";
        }
    }
}
