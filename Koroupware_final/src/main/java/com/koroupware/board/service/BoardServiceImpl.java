package com.koroupware.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koroupware.board.domain.BoardFileVO;
import com.koroupware.board.domain.BoardVO;
import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.SearchCriteria;
import com.koroupware.board.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	@Transactional
	@Override
	public void boardRegist(BoardVO board) throws Exception {
		dao.boardInsert(board);
		String[] files = board.getFiles();
		int board_no = dao.getBoardNo();
		
		BoardFileVO filevo = new BoardFileVO();
		filevo.setBoard_no(board_no);
		
		if(files==null){
			return;
		}
		 
		for(String fileName:files){
			filevo.setFullName(fileName);
			dao.fileInsert(filevo);
		}
	}

	@Override
	public List<BoardVO> boardList(int category_no) throws Exception {
		return dao.boardList(category_no);
	}

	@Override
	public void boardModify(BoardVO board) throws Exception {
		dao.boardUpdate(board);
		
	}

	@Override
	public void boardRemove(int board_no) throws Exception {
		dao.boardDelete(board_no);
		
	}
 
	@Transactional
	@Override
	public BoardVO boardRead(int board_no) throws Exception {
		dao.updateViewCnt(board_no);
		dao.updateRecCnt(board_no);
		
		return dao.boardSelect(board_no);
	}

	@Override
	public List<BoardVO> listCriteria(SearchCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(SearchCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<String> getAttach(int board_no) throws Exception {
		return dao.getAttach(board_no);
	}

	@Override
	public void recModifyCnt(int board_no) throws Exception {
		dao.updateRecCnt(board_no);
	}

}
