package com.koroupware.O.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.O.domain.Test;

@Repository
public class TestDAOImpl implements TestDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mappers.TestMapper";

	@Override
	public Test testSelect() {
		return sqlSession.selectOne(namespace+".selectTest");
	}

}
