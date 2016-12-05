package com.koroupware.estimate.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.member.dto.EmpDTO;

@Repository
public class EstimateDAOImpl implements EstimateDAO{
	
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.koroupware.mappers.EstimateMapper";

	@Override
	public int attendCount(AttendVO attendVO) {
		String date = attendVO.getYear() + "/" + attendVO.getMonth();
		attendVO.setAttend_date(date);
		int count = sqlSession.selectOne(namespace + ".attendCount", attendVO);
		return count;
	}

	@Override
	public int empCount(int dept_no) {
		
		return sqlSession.selectOne(namespace+".empCount", dept_no);
	}

	@Override
	public List<EmpDTO> attendDept_EmpList(int dept_no) {
		List<EmpDTO> list = sqlSession.selectList(namespace+".attendDept_EmpList",dept_no);
		return list;
	}

	@Override
	public void insertAttendQuater(ResultVO resultVO) {
		sqlSession.insert(namespace+".insertAttendQuater", resultVO);
		
	}

	@Override
	public List<ResultVO> attendQuaterList() {
		List<ResultVO> list = sqlSession.selectList(namespace+".attendQuaterList");
		return list;
	}

	@Override
	public List<ResultDTO> attendQuaterDTOList() {
		List<ResultDTO> list = sqlSession.selectList(namespace+".attendQuaterDTOList");
		return list;
	}

}
