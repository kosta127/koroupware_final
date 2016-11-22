package com.koroupware.emp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.emp.domain.TelVO;

@Repository
public class TelDAOImpl implements TelDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.mappers.TelMapper";
	
	@Override
	public void create(TelVO telVo) throws Exception {
		sqlSession.insert(namespace+".signUpTel", telVo);
	}
	
	@Override
	public List<TelVO> telList(int emp_no) throws Exception {
		return sqlSession.selectList(namespace+".telList");
	}

	@Override
	public void addTel(TelVO telVo) throws Exception {
		sqlSession.insert(namespace+".addTel", telVo);
	}

	@Override
	public void updateTel(TelVO telVo) throws Exception {
		sqlSession.update(namespace+".updateTel", telVo);
	}

	@Override
	public void deleteTel(int tel_no) throws Exception {
		sqlSession.delete(namespace+".deleteTel", tel_no);	
	}



}
