package com.its.members.repository;

import com.its.members.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public BoardDTO writing(BoardDTO boardDTO) {
        sql.insert("Board.writing",boardDTO);
        return boardDTO;
    }

    public void saveFileName2(BoardDTO boardDTO) {

        sql.insert("Board.saveFileName2",boardDTO);
    }

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Board.pagingList",pagingParams);
    }

    public int boardCount() {

        return sql.selectOne("Board.boardCount");
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits",id);
    }

    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById",id);
    }
}
