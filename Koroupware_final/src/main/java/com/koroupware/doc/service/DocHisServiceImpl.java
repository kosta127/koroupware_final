package com.koroupware.doc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.doc.domain.DocHisVO;
import com.koroupware.doc.persistence.DocHisDAO;

@Service
public class DocHisServiceImpl implements DocHisService {
	@Inject
	private DocHisDAO dao;
	
	@Override
	public void doc_hisRegist(DocHisVO vo) {
		dao.doc_hisInsert(vo);
	}

	@Override
	public List<DocHisVO> doc_hisList() {
		return dao.doc_hisList();
	}

}
