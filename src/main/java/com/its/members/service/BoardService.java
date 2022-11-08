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
            String storedFileNameBoard = System.currentTimeMillis() + "-" + originalFileNameBoard;
            boardDTO.setOriginalFileName_member(originalFileNameBoard);
            boardDTO.setStoredFileName_member(storedFileNameBoard);
            String savePath2 = "C:\\spring_img\\" + storedFileNameBoard;
            boardFile.transferTo(new File(savePath2));
            boardDTO.setBoardFileName(1);
            BoardDTO savedBoard = boardRepository.writing(boardDTO);
            boardRepository.saveFileName2(savedBoard);
        } else {
            boardDTO.setBoardFileName(0);
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
}