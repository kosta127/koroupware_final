package com.koroupware.doc.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocFileVO;
import com.koroupware.doc.domain.DocHisVO;
import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.domain.DocVO;

@Repository
public class DocDAOImpl implements DocDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "com.koroupware.mappers.DocMapper";
	
	
	@Override
	public int docInsert(DocVO doc) {
		return sqlsession.insert(namespace + ".insertDoc",doc);
	}

	@Override
	public List<DocVO> docList() {
		return sqlsession.selectList(namespace+".listDoc");
	}

	@Override
	public DocVO docDetail(int doc_no) {
		return sqlsession.selectOne(namespace+".detailDoc",doc_no);
	}



	@Override
	public String emp_nameSelect(int emp_no) {
		return sqlsession.selectOne(namespace+".selectEmp_name",emp_no);
	}


	@Override
	public void doc_fileInsert(DocFileVO doc_file) {
		sqlsession.insert(namespace+".insertDoc_file",doc_file);
	}

	@Override
	public List<DocFileVO> doc_fileSelect(int doc_no) {
		return sqlsession.selectList(namespace+".selectDoc_file",doc_no);
	}

	
	@Override
	public void docDelete(int doc_no) {
		sqlsession.delete(namespace+".deleteDoc",doc_no);
	}



	@Override
	public int nextDoc_no() {
		return sqlsession.selectOne(namespace+".nextDoc_no");
	}

	@Override
	public void docUpdate(DocVO doc) {
		sqlsession.update(namespace+".updateDoc",doc);
	}



	@Override
	public String emp_nameGet(int emp_no) {
		return sqlsession.selectOne(namespace+".selectEmp_name",emp_no);
	}

	@Override
	public void addAttach(DocFileVO vo) throws Exception {
		sqlsession.insert(namespace+".addAttach",vo);
	}

	@Override
	public int getDoc_no() {
		return sqlsession.selectOne(namespace+".getDoc_no");
	}

	@Override
	public List<String> getAttach(Integer doc_no) throws Exception {
		return sqlsession.selectList(namespace+".getAttach",doc_no);
	}

	@Override
	public void deleteAttach(int doc_no) throws Exception {
		sqlsession.delete(namespace+".deleteAttach",doc_no);
	}

	@Override
	public void replaceAttach(String fullName, Integer doc_no) throws Exception {
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("doc_no",doc_no);
		paramMap.put("fullName", fullName);
		sqlsession.insert(namespace+".replaceAttach",paramMap);
	}

	
}
