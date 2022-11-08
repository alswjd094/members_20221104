package com.its.members.controller;

import com.its.members.dto.BoardDTO;
import com.its.members.dto.PageDTO;
import com.its.members.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/writing")
    public String writingForm(){

        return"boardWriting";
    }

    @PostMapping("/writing")
    public String writing(@ModelAttribute BoardDTO boardDTO) throws IOException {
       boardService.writing(boardDTO);
            return"redirect:/paging";
    }
    @GetMapping("/board")
    public String board(Model model){
        List<BoardDTO> boardDTO = boardService.board();
        model.addAttribute("findAll",boardDTO);
        return"boardList";
    }
    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page",required = false, defaultValue = "1") int page){
        List<BoardDTO> pagingList = boardService.pagingList(page);
        model.addAttribute("findAll",pagingList);
        PageDTO pageDTO =  boardService.pagingParam(page);
        model.addAttribute("paging",pageDTO);
        return"boardPaging";
    }
}
