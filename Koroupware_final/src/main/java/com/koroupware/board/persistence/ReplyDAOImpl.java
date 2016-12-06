package com.koroupware.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sqlSession;
	private static String namespace = "com.koroupware.board.mappers.ReplyMapper";
	
	@Override
	public List<ReplyVO> replyList(int board_no) throws Exception {
		
		return sqlSession.selectList(namespace+".replyList", board_no);
	}

	@Override
	public void replyInsert(ReplyVO vo) throws Exception {
		System.out.println("1");
		sqlSession.insert(namespace+".replyInsert", vo);

	}

	@Override
	public void replyDelete(int reply_no) throws Exception {
		sqlSession.delete(namespace+".replyDelete", reply_no);

	}

	@Override
	public List<ReplyVO> listPage(int board_no, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(int board_no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
