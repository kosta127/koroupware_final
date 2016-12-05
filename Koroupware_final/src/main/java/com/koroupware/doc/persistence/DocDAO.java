package com.koroupware.doc.persistence;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocFileVO;
import com.koroupware.doc.domain.DocHisVO;
import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.domain.DocVO;

public interface DocDAO {
	public int docInsert(DocVO doc);
	
	public List<DocVO> docList();
	public DocVO docDetail(int doc_no);	
	public String emp_nameSelect(int emp_no);
	public void doc_fileInsert(DocFileVO doc_file);
	public List<DocFileVO> doc_fileSelect(int doc_no);

	public void docDelete(int doc_no);
	public int nextDoc_no();
	public void docUpdate(DocVO doc);
	public String emp_nameGet(int emp_no);
	public void addAttach(DocFileVO vo) throws Exception;
	public int getDoc_no();
	public List<String> getAttach(Integer doc_no) throws Exception;
	public void deleteAttach(int doc_no) throws Exception;
	public void replaceAttach(String fullName,Integer doc_no) throws Exception;
}
