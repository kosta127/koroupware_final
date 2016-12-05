package com.koroupware.doc.persistence;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.domain.DocVO;


public interface DocManagementDAO {
	public void doc_managementInsert(DocManagementVO vo);
	public void doc_boxDelete(int doc_box_no);
	public void docDelete(DocManagementVO vo);

}
