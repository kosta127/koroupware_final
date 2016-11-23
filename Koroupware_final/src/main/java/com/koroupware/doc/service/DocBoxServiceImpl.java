package com.koroupware.doc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocVO;
import com.koroupware.doc.persistence.DocBoxDAO;

@Service
public class DocBoxServiceImpl implements DocBoxService {

	@Inject
	private DocBoxDAO docboxDAO;
	
	@Override
	public void doc_boxRegist(DocBoxVO vo) {
		
		docboxDAO.doc_boxInsert(vo);
	}

	@Override
	public List<DocBoxVO> doc_boxList(int emp_no) {
		return docboxDAO.doc_boxList(emp_no);
	}

	@Override
	public List<DocVO> doc_boxRead(int doc_box_no) {
		return docboxDAO.doc_boxDetail(doc_box_no);
	}

	@Override
	public void doc_boxModify(DocBoxVO vo) {
		docboxDAO.doc_boxUpdate(vo);
	}

	@Override
	public DocBoxVO doc_boxGet(int doc_box_no) {
		return docboxDAO.doc_boxSelect(doc_box_no);
	}

	
	@Override
	public void doc_boxRemove(int doc_box_no) {
		docboxDAO.doc_boxDelete(doc_box_no);
	}

}
