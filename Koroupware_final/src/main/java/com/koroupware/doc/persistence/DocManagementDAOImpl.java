package com.koroupware.doc.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;

import com.koroupware.doc.domain.DocManagementVO;

@Controller
public class DocManagementDAOImpl implements DocManagementDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.koroupware.mappers.DocManagementMapper";
	
	@Override
	public void doc_managementInsert(DocManagementVO vo) {
		sqlSession.insert(namespace+".insertDoc_management",vo);
	}

	@Override
	public void doc_boxDelete(int doc_box_no) {
		sqlSession.delete(namespace+".deleteDoc_box_management",doc_box_no);
	}

	@Override
	public void docDelete(DocManagementVO vo) {
		sqlSession.delete(namespace+".deleteDoc_management",vo);
	}

}
