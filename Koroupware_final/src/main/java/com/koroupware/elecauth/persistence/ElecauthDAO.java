package com.koroupware.elecauth.persistence;

import java.util.List;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.DocVO;
import com.koroupware.elecauth.domain.ElecauthDetailVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;

public interface ElecauthDAO {
	
	public List<ElecauthListVO> elecauthList() throws Exception;
	
	public ElecauthDetailVO elecauthDetail(Integer elec_auth_no) throws Exception;
	
	public void elecauthInsert(ElecauthVO ea) throws Exception; //added by jirung
	public void approvalListInsert(ApprovalListVO al) throws Exception; //added by jirung
	public void elecauthReferrerInsert(ElecauthReferrerVO ref) throws Exception; //added by jirung
	public EmpDetailVO empDetailSelect(int emp_no) throws Exception; //added by jirung
	public List<EmpDetailVO> empDetailList() throws Exception; //added by jr
	public List<DocVO> docListSelect() throws Exception; //added by jirung
	
}
