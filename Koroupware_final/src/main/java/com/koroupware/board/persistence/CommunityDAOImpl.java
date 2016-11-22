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
		System.out.println("dao");
		return sqlSession.insert(namespace+".insertCommunity", community);
	}

	@Override
	public List<CommunityVO> communityList() {
		return sqlSession.selectList(namespace+".listCommunity");
	}
}
