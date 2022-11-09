package com.its.members.repository;

import com.its.members.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public void commentSave(CommentDTO commentDTO) {
        sql.insert("Comment.commentSave",commentDTO);
    }

    public List<CommentDTO> findAllComment(Long commentId) {
        return sql.selectList("Comment.findAllComment",commentId);
    }
}
