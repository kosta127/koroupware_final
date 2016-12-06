package com.koroupware.doc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.persistence.DocManagementDAO;

@Service
public class DocManagementServiceImpl implements DocManagementService {
	
	@Inject
	DocManagementDAO dao;
	
	
	
	@Override
	public void doc_managementRegist(DocManagementVO vo) {
		dao.doc_managementInsert(vo);
	}

	@Override
	public void doc_boxRemove(int doc_box_no) {
		dao.doc_boxDelete(doc_box_no);
	}

	@Override
	public void docRemove(DocManagementVO vo) {
		dao.docDelete(vo);
	}

}
