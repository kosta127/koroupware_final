package com.koroupware.elecauth.persistence;

import java.util.List;

import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;

public interface ElecauthDAO {
	
	public List<ElecauthListVO> elecauthList() throws Exception;
	
	public ElecauthReadVO elecauthRead(Integer elec_auth_no) throws Exception;
}
