package com.koroupware.elecauth.service;

import java.util.List;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.DocVO;
import com.koroupware.elecauth.domain.ElecauthDetailVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;

public interface ElecauthService {
	public List<ElecauthListVO> elecauthList() throws Exception;
	
	public ElecauthDetailVO elecauthDetail(Integer elec_auth_no) throws Exception;
	
	public void elecauthRegist(ElecauthVO ea, 
			List<ApprovalListVO> approvals,
			List<ElecauthReferrerVO> referrers) throws Exception; //added by jirung
	public EmpDetailVO empDetailRead(int emp_no) throws Exception; //added by jirung
	public List<DocVO> docListSelect() throws Exception; //added by jirung
	public List<EmpDetailVO> empListSelect() throws Exception; //added by jirung
}
