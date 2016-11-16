package com.koroupware.emp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.emp.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.mappers.EmpMapper";
	
	@Override
	public void create(EmpVO empVo) throws Exception {
		sqlSession.insert(namespace+".signUp", empVo);
	}

}
