package com.its.members.controller;

import com.its.members.dto.BoardDTO;
import com.its.members.dto.CommentDTO;
import com.its.members.dto.PageDTO;
import com.its.members.service.BoardService;
import com.its.members.service.CommentService;
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
    @Autowired
    private CommentService commentService;

    @GetMapping("/writing")
    public String writingForm(){

        return"boardWriting";
    }

    @PostMapping("/writing")
    public String writing(@ModelAttribute BoardDTO boardDTO) throws IOException {
       boardService.writing(boardDTO);
            return"redirect:/paging";
    }

    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page",required = false, defaultValue = "1") int page){
        List<BoardDTO> pagingList = boardService.pagingList(page);
        model.addAttribute("findAll",pagingList);
        PageDTO pageDTO =  boardService.pagingParam(page);
        model.addAttribute("paging",pageDTO);
        return"boardPaging";
    }

    @GetMapping("/board")
    public String findById(@RequestParam("id")Long id,Model model,@RequestParam(value = "page",required = false, defaultValue = "1") int page){
        boardService.updateHits(id);
        BoardDTO findByIdResult = boardService.findById(id);
        model.addAttribute("page",page);
        model.addAttribute("findById",findByIdResult);
        System.out.println("findByIdResult = " + findByIdResult);
        List<CommentDTO> commentDTOList = commentService.findAllComment(id);
        model.addAttribute("commentList",commentDTOList);
        return "boardDetail";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id,Model model){
        BoardDTO updateForm = boardService.findById(id);
        model.addAttribute("findById",updateForm);
        return "boardUpdate";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO,Model model){
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("findById",dto);
        return"boardDetail";
    }

    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam("id")Long id){
        boardService.boardDelete(id);
        return "redirect:/paging";
    }
    @GetMapping("/search")
    public String search(@RequestParam("type") String type, @RequestParam("q") String q,Model model){
        List<BoardDTO> searchList = boardService.search(type,q);
        model.addAttribute("findAll",searchList);
        return"boardPaging";
    }
}
