package com.koroupware.board.persistence;

import java.util.List;

import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> replyList(int board_no)throws Exception;
	public void replyInsert(ReplyVO vo)throws Exception;
	public void replyDelete(int reply_no)throws Exception;
	public List<ReplyVO> listPage(int board_no, Criteria cri)throws Exception;
	public int count(int board_no)throws Exception;

}
