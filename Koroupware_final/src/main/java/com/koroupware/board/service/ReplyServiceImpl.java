package com.koroupware.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.board.domain.ReplyVO;
import com.koroupware.board.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	@Override
	public void replyRegist(ReplyVO vo) throws Exception {
		System.out.println("3");
		dao.replyInsert(vo);
		
	}

	@Override
	public List<ReplyVO> replyList(int board_no) throws Exception {
		return dao.replyList(board_no);
	}

	@Override
	public void replyRemove(int reply_no) throws Exception {
		dao.replyDelete(reply_no);
		
	}

}
