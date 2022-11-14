package com.its.members.service;

import com.its.members.commons.PagingConst;
import com.its.members.dto.BoardDTO;
import com.its.members.dto.PageDTO;
import com.its.members.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void writing(BoardDTO boardDTO) throws IOException {
//        int writingResult = boardRepository.writing(boardDTO);
//        if(writingResult>0){
//            return true;
//        }else{
//            return false;
//        }
        if (!boardDTO.getBoardFile().isEmpty()) {
            MultipartFile boardFile = boardDTO.getBoardFile();
            String originalFileNameBoard = boardFile.getOriginalFilename();
            System.out.println("originalFileNameBoard = " + originalFileNameBoard);
            String storedFileNameBoard = System.currentTimeMillis() + "-" + originalFileNameBoard;
            System.out.println("storedFileNameBoard = " + storedFileNameBoard);
            boardDTO.setOriginalFileName_boards(originalFileNameBoard);
            boardDTO.setStoredFileName_boards(storedFileNameBoard);
            String savePath2 = "C:\\spring_img\\" + storedFileNameBoard;
            boardFile.transferTo(new File(savePath2));
            boardDTO.setFileAttached_boards(1);
            //이메일로 멤버테이블 조회
//            boardRepository.findById(boardDTO.getId());
//            boardRepository.findById(boardDTO.getBoardId());
            BoardDTO savedBoard = boardRepository.writing(boardDTO);
            boardRepository.saveFileName2(savedBoard);
        } else {
            boardDTO.setFileAttached_boards(0);
            boardRepository.writing(boardDTO);
        }
    }

    public List<BoardDTO> pagingList(int page) {
        int pagingStart = (page - 1) * PagingConst.PAGE_LIMIT;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", PagingConst.PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;

    }

    public PageDTO pagingParam(int page) {
        int boardCount = boardRepository.boardCount();
        int maxPage = (int) (Math.ceil((double) boardCount / PagingConst.PAGE_LIMIT));
        int startPage = (((int) (Math.ceil((double) page / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;

        int endPage = startPage + PagingConst.BLOCK_LIMIT - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }

        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void boardDelete(Long id) {
        boardRepository.boardDelete(id);
    }

    public List<BoardDTO> search(String type, String q) {
        Map<String, String> searchParams = new HashMap<>();
        searchParams.put("type",type);
        searchParams.put("q",q);
        List<BoardDTO> searchList = boardRepository.search(searchParams);
        return searchList;
    }
}