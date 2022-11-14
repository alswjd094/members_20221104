package com.its.members.service;

import com.its.members.dto.CommentDTO;
import com.its.members.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public void commentSave(CommentDTO commentDTO) {

        commentRepository.commentSave(commentDTO);
    }

    public List<CommentDTO> findAllComment(Long commentId) {
        return commentRepository.findAllComment(commentId);
    }
}
