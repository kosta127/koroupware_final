package com.koroupware.doc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocVO;

@Repository
public class DocBoxDAOImpl implements DocBoxDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.mappers.DocBoxMapper";
	
	@Override
	public void doc_boxInsert(DocBoxVO doc_box) {
		sqlSession.insert(namespace+".insertDoc_box",doc_box);
	}

	@Override
	public List<DocBoxVO> doc_boxList(int emp_no) {
		
		return sqlSession.selectList(namespace+".listDoc_box",emp_no);
	}

	@Override
	public List<DocVO> doc_boxDetail(int doc_box_no) {
		return sqlSession.selectList(namespace+".detailDoc_box",doc_box_no);
	}

	@Override
	public void doc_boxUpdate(DocBoxVO doc_box) {
		sqlSession.update(namespace+".updateDoc_box_name",doc_box);
	}

	@Override
	public void doc_boxDelete(int doc_box_no) {
		sqlSession.delete(namespace+".deleteDoc_box",doc_box_no);
	}

	@Override
	public DocBoxVO doc_boxSelect(int doc_box_no) {
		return sqlSession.selectOne(namespace+".selectDoc_box",doc_box_no);
	}

}
