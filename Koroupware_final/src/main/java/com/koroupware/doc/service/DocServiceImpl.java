package com.koroupware.doc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.koroupware.doc.domain.DocFileVO;
import com.koroupware.doc.domain.DocVO;
import com.koroupware.doc.persistence.DocDAO;

@Service
public class DocServiceImpl implements DocService {
	
	@Inject
	private DocDAO docDAO;
	
	@Transactional
	@Override
	public void docRegist(DocVO vo) throws Exception {
		docDAO.docInsert(vo);
		String[] files = vo.getFiles();
		int doc_no = docDAO.getDoc_no();
	
		DocFileVO doc_fileVO = new DocFileVO();
		doc_fileVO.setDoc_no(doc_no);
		
		if(files == null){
			return;
			}
		
		for(String fileName : files){
			doc_fileVO.setFullName(fileName);
			
			docDAO.addAttach(doc_fileVO);
		}
	}

	@Override
	public List<DocVO> docList() {
		return docDAO.docList();
	}

	@Override
	public DocVO docRead(int doc_no) {
		return docDAO.docDetail(doc_no);
	}
	
	@Transactional
	@Override
	public void docRemove(int doc_no) throws Exception {
		docDAO.deleteAttach(doc_no);
		docDAO.docDelete(doc_no);
	}

	@Override
	public void docModify(DocVO vo) throws Exception {
		docDAO.docUpdate(vo);
		
		Integer doc_no = docDAO.getDoc_no();
		docDAO.deleteAttach(doc_no);
		String[] files = vo.getFiles();
		if(files == null){return;}
		for(String fileName : files){
			docDAO.replaceAttach(fileName, doc_no);
		}
	}

	@Override
	public int next() {
		return docDAO.nextDoc_no();
	}

	@Override
	public String emp_nameGet(int emp_no) {
		return docDAO.emp_nameSelect(emp_no);
	}

	@Override
	public List<String> getAttach(Integer doc_no) throws Exception {
			return docDAO.getAttach(doc_no);
	}

}
