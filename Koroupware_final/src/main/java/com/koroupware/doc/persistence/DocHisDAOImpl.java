package com.koroupware.doc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.doc.domain.DocHisVO;


@Repository
public class DocHisDAOImpl implements DocHisDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.mappers.DocHisMapper";
	@Override
	public void doc_hisInsert(DocHisVO vo) {
		sqlSession.insert(namespace+".insertDoc_his",vo);
	}

	@Override
	public List<DocHisVO> doc_hisList() {
		return sqlSession.selectList(namespace+".listDocHis");
	}

}
