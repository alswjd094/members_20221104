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
        int result = sql.insert("Board.writing",boardDTO);
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
        BoardDTO boardDTO = sql.selectOne("Board.findById",id);
        if(boardDTO.getFileAttached_boards()==1) {
            return sql.selectOne("Board.findByIdFile", id);
        }else{
            return boardDTO;
        }
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update",boardDTO);
    }

    public void boardDelete(Long id) {
        sql.delete("Board.boardDelete",id);
    }

    public List<BoardDTO> search(Map<String, String> searchParams) {
        return sql.selectList("Board.search",searchParams);
    }
}
