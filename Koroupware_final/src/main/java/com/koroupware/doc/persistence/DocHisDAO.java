package com.koroupware.doc.persistence;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocFileVO;
import com.koroupware.doc.domain.DocHisVO;
import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.domain.DocVO;

public interface DocHisDAO {
	
	public void doc_hisInsert(DocHisVO vo);
	
	public List<DocHisVO> doc_hisList();

}
