package com.koroupware.board.service;

import java.util.List;

import com.koroupware.board.domain.BoardVO;
import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.SearchCriteria;

public interface BoardService {

	public void boardRegist(BoardVO board)throws Exception;
	public List<BoardVO> boardList(int category_no)throws Exception;
	public void boardModify(BoardVO board)throws Exception;
	public void boardRemove(int board_no)throws Exception;
	public BoardVO boardRead(int board_no)throws Exception;
	public List<BoardVO> listCriteria(SearchCriteria cri)throws Exception;
	public int listCountCriteria(SearchCriteria cri)throws Exception;
	public List<String> getAttach(int board_no)throws Exception;
	//public void recModifyCnt(int board_no)throws Exception;
}
