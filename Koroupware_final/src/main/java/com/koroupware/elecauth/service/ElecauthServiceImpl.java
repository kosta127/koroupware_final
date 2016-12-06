package com.koroupware.elecauth.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.ApprovalPrimaryVO;
import com.koroupware.elecauth.domain.ElecauthDocVO;
import com.koroupware.elecauth.domain.ElecauthDeleteVO;
import com.koroupware.elecauth.domain.ElecauthListCond;
import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;
import com.koroupware.elecauth.domain.ElecauthReadApprovalVO;
import com.koroupware.elecauth.domain.ElecauthReadReferrerVO;
import com.koroupware.elecauth.persistence.ElecauthDAO;

@Service
public class ElecauthServiceImpl implements ElecauthService {
	
	@Inject
	private ElecauthDAO dao;

	@Override
	public List<ElecauthListVO> elecauthList(int emp_no, boolean isReceive, String flag) throws Exception {
		return dao.elecauthList(new ElecauthListCond(emp_no, isReceive, flag));
	}

	@Override
	public ElecauthReadVO elecauthRead(Integer elec_auth_no) throws Exception {
		
		return dao.elecauthRead(elec_auth_no);
	}

	@Override
	public List<ElecauthReadApprovalVO> elecauthReadApproval(Integer elec_auth_no) throws Exception {
		
		return dao.elecauthReadApproval(elec_auth_no);
	}

	@Override
	public List<ElecauthReadReferrerVO> elecauthReadReferrer(Integer elec_auth_no) throws Exception {
		
		return dao.elecauthReadReferrer(elec_auth_no);
	}

	@Override
	@Transactional
	public void elecauthRegist(ElecauthVO ea, List<ApprovalListVO> approvals, List<ElecauthReferrerVO> referrers)
			throws Exception {
		// 전자 결재 등록
		// added by jirung
		int elecauthNo = getElecauthNo();
		ea.setElec_auth_no(elecauthNo);
		dao.elecauthInsert(ea);
		for(ApprovalListVO al : approvals){
			al.setElec_auth_no(elecauthNo);
			dao.approvalListInsert(al);
		}
		for(ElecauthReferrerVO ref : referrers) {
			ref.setElec_auth_no(elecauthNo);
			dao.elecauthReferrerInsert(ref);
		}
	}

	@Override
	public EmpDetailVO empDetailRead(int emp_no) throws Exception{
		// 사원 디테일 정보 조회해옴
		// added by jirung
		return dao.empDetailSelect(emp_no);
	}

	@Override
	public List<ElecauthDocVO> docListSelect() throws Exception {
		// 양식으로 쓸 문서 목록 조회
		return dao.docListSelect();
	}

	@Override
	public List<EmpDetailVO> empListSelect() throws Exception {
		// 사원 목록 조회
		return dao.empDetailList();
	}

	@Override
	public void elecauthDelete(ElecauthDeleteVO elecauthDelete) throws Exception {
		//전자결재 삭제
		dao.elecauthDelete(elecauthDelete);
	}

	@Override
	public void elecauthOkReport(ApprovalPrimaryVO elecauthOkReport) throws Exception {
		// 전자결재 승인
		dao.elecauthOkReport(elecauthOkReport);
	}

	@Override
	public void elecauthNoReport(ApprovalPrimaryVO elecauthNoReport) throws Exception {
		// 전자결재 거절
		dao.elecauthNoReport(elecauthNoReport);
	}

	@Override
	public int getElecauthNo() throws Exception {
		return dao.getElecauthNo();
	}
	
	

}
