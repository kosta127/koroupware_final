package com.koroupware.doc.service;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.domain.DocVO;

public interface DocManagementService {
	
	public void doc_managementRegist(DocManagementVO vo);
	public void doc_boxRemove(int doc_box_no);
	public void docRemove(DocManagementVO vo);
}
