	package com.koroupware.doc.service;

import java.util.List;

import com.koroupware.doc.domain.DocVO;

public interface DocService {
	public void docRegist(DocVO vo) throws Exception;
	public List<DocVO> docList();
	public DocVO docRead(int doc_no);
	public void docRemove(int doc_no) throws Exception;
	public void docModify(DocVO vo) throws Exception;
	public int next();
	public String emp_nameGet(int emp_no);
	public List<String> getAttach(Integer doc_no) throws Exception;
}
