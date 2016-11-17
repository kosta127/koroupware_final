package com.koroupware.elecauth.persistence;

import java.util.List;

import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReadApprovalVO;
import com.koroupware.elecauth.domain.ElecauthReadReferrerVO;

public interface ElecauthDAO {
	
	public List<ElecauthListVO> elecauthList() throws Exception;
	
	public ElecauthReadVO elecauthRead(Integer elec_auth_no) throws Exception;
	
	public List<ElecauthReadApprovalVO> elecauthReadApproval(Integer elec_auth_no) throws Exception;
	
	public List<ElecauthReadReferrerVO> elecauthReadReferrer(Integer elec_auth_no) throws Exception;
}
