package com.koroupware.emp.persistence;

import java.util.List;

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

	@Override
	public List<String> EmpAll() throws Exception {
		return sqlSession.selectList(namespace+".empData");
	}

	@Override
	public void update(EmpVO empVo) throws Exception {
		sqlSession.update(namespace+".empDataUpdate", empVo);
	}

}
