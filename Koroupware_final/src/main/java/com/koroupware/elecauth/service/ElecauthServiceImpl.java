package com.koroupware.elecauth.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.DocVO;
import com.koroupware.elecauth.domain.ElecauthDetailVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;
import com.koroupware.elecauth.persistence.ElecauthDAO;

@Service
public class ElecauthServiceImpl implements ElecauthService {
	
	@Inject
	private ElecauthDAO dao;

	@Override
	public List<ElecauthListVO> elecauthList() throws Exception {
		
		return dao.elecauthList();
	}

	@Override
	public ElecauthDetailVO elecauthDetail(Integer elec_auth_no) throws Exception {
		
		return dao.elecauthDetail(elec_auth_no);
	}

	@Transactional
	@Override
	public void elecauthRegist(ElecauthVO ea, List<ApprovalListVO> approvals, List<ElecauthReferrerVO> referrers)
			throws Exception {
		// 전자 결재 등록
		// added by jirung
		dao.elecauthInsert(ea);
		for(ApprovalListVO al : approvals) 
			dao.approvalListInsert(al);
		for(ElecauthReferrerVO ref : referrers) 
			dao.elecauthReferrerInsert(ref);
	}

	@Override
	public EmpDetailVO empDetailRead(int emp_no) throws Exception{
		// 사원 디테일 정보 조회해옴
		// added by jirung
		return dao.empDetailSelect(emp_no);
	}

	@Override
	public List<DocVO> docListSelect() throws Exception {
		// 양식으로 쓸 문서 목록 조회
		return dao.docListSelect();
	}

	@Override
	public List<EmpDetailVO> empListSelect() throws Exception {
		// 사원 목록 조회
		return dao.empDetailList();
	}
	
	

}
