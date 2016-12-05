package com.koroupware.doc.persistence;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocVO;


public interface DocBoxDAO {
	
	public void doc_boxInsert(DocBoxVO doc_box);
	
	public List<DocBoxVO> doc_boxList(int emp_no);
	
	public List<DocVO> doc_boxDetail(int doc_box_no);
	
	public void doc_boxUpdate(DocBoxVO doc_box);
	
	public void doc_boxDelete(int doc_box_no);
	
	public DocBoxVO doc_boxSelect(int doc_box_no);

}
