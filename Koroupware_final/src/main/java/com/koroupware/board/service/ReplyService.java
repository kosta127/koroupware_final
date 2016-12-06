package com.koroupware.board.service;

import java.util.List;

import com.koroupware.board.domain.ReplyVO;

public interface ReplyService {
	public void replyRegist(ReplyVO vo)throws Exception;
	public List<ReplyVO> replyList(int board_no)throws Exception;
	public void replyRemove(int reply_no)throws Exception;
}
