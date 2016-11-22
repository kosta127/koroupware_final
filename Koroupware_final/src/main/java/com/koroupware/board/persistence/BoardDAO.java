package com.koroupware.board.persistence;

import java.util.List;

import com.koroupware.board.domain.BoardFileVO;
import com.koroupware.board.domain.BoardVO;
import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.SearchCriteria;

public interface BoardDAO {

	public void boardInsert(BoardVO vo)throws Exception;
	public List<BoardVO> boardList()throws Exception;
	public void boardUpdate(BoardVO vo)throws Exception;
	public void boardDelete(int board_no)throws Exception;
	public BoardVO boardSelect(int board_no)throws Exception;
	public List<BoardVO> listCriteria(SearchCriteria cri)throws Exception;
	public int countPaging(SearchCriteria cri)throws Exception;
	public void updateViewCnt(int board_no)throws Exception;
	public void fileInsert(BoardFileVO fileVO)throws Exception;
	public int getBoardNo()throws Exception;
	public List<String> getAttach(int board_no)throws Exception;
	public void deleteAttach(int board_no)throws Exception;
	public void updateRecCnt(int board_no)throws Exception;
	
}
