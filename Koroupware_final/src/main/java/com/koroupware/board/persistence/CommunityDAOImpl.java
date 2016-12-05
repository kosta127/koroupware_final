package com.koroupware.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.board.domain.CommunityVO;

@Repository
public class CommunityDAOImpl implements CommunityDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.board.mappers.CommunityMapper";

	@Override
	public int communityInsert(CommunityVO community) {
		return sqlSession.insert(namespace+".communityInsert", community);
	}

	@Override
	public List<CommunityVO> communityList(int emp_no) {
		return sqlSession.selectList(namespace+".communityList", emp_no);
	}

	@Override
	public int getCommunityNo() throws Exception {
		return sqlSession.selectOne(namespace+".maxNumber");
	}
}
