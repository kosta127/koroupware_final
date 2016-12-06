package com.koroupware.doc.service;

import java.util.List;

import com.koroupware.doc.domain.DocHisVO;

public interface DocHisService {
	public void doc_hisRegist(DocHisVO vo);
	
	public List<DocHisVO> doc_hisList();
}
