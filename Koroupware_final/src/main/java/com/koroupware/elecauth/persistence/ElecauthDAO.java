package com.koroupware.elecauth.persistence;

import java.util.List;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.ApprovalPrimaryVO;
import com.koroupware.elecauth.domain.DocVO;
import com.koroupware.elecauth.domain.ElecauthDeleteVO;
import com.koroupware.elecauth.domain.ElecauthListCond;
import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;
import com.koroupware.elecauth.domain.ElecauthReadApprovalVO;
import com.koroupware.elecauth.domain.ElecauthReadReferrerVO;

public interface ElecauthDAO {
	
	public List<ElecauthListVO> elecauthList(ElecauthListCond elecauthListCond) throws Exception;
	
	public ElecauthReadVO elecauthRead(Integer elec_auth_no) throws Exception;
	
	public List<ElecauthReadApprovalVO> elecauthReadApproval(Integer elec_auth_no) throws Exception;
	
	public List<ElecauthReadReferrerVO> elecauthReadReferrer(Integer elec_auth_no) throws Exception;
	
	public void elecauthDelete(ElecauthDeleteVO elecauthDelete) throws Exception;
	
	public void elecauthOkReport(ApprovalPrimaryVO elecauthOkReport) throws Exception;
	public void elecauthNoReport(ApprovalPrimaryVO elecauthNoReport) throws Exception;
	
	public void elecauthInsert(ElecauthVO ea) throws Exception; //added by jirung
	public void approvalListInsert(ApprovalListVO al) throws Exception; //added by jirung
	public void elecauthReferrerInsert(ElecauthReferrerVO ref) throws Exception; //added by jirung
	public EmpDetailVO empDetailSelect(int emp_no) throws Exception; //added by jirung
	public List<EmpDetailVO> empDetailList() throws Exception; //added by jr
	public List<DocVO> docListSelect() throws Exception; //added by jirung
	
}
