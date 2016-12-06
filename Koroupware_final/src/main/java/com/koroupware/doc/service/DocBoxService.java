package com.koroupware.doc.service;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocVO;

public interface DocBoxService {
	
	public void doc_boxRegist(DocBoxVO vo);
	
	public List<DocBoxVO> doc_boxList(int emp_no);
	
	public List<DocVO> doc_boxRead(int doc_box_no);
	
	public void doc_boxModify(DocBoxVO vo);
	
	public DocBoxVO doc_boxGet(int doc_box_no);
	
	public void doc_boxRemove(int doc_box_no);
}
