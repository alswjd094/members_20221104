package com.its.members.controller;

import com.its.members.dto.CommentDTO;
import com.its.members.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/commentSave")
    public @ResponseBody List<CommentDTO> commentSave(@ModelAttribute CommentDTO commentDTO){
        commentService.commentSave(commentDTO);
        List<CommentDTO> commentDTOList = commentService.findAllComment(commentDTO.getCommentId());
        return commentDTOList;
    }
}
