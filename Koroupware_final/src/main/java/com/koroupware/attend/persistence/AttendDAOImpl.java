package com.koroupware.attend.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.attend.domain.AttendVO;

import com.koroupware.attend.dto.AttendDTO;


@Repository
public class AttendDAOImpl implements AttendDAO {
	// Repository 꼭 할 것!!!! 안하면 어노테이션 나옴

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.koroupware.mappers.AttendMapper";

	@Override
	public void attendInsert(AttendVO attendVO) {
		sqlSession.insert(namespace + ".attendInsert", attendVO);
	}

	@Override
	public AttendVO attendCheck(AttendVO attendVO) {
		attendVO = sqlSession.selectOne(namespace + ".attendCheck", attendVO);
		System.out.println(attendVO);
		return attendVO;
	}

	@Override
	public List<AttendDTO> attendList(int emp_no) {

		List<AttendDTO> list = sqlSession.selectList(namespace + ".attendList", emp_no);
		return list;
	}

}
