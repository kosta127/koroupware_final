package com.koroupware.elecauth.persistence;

import java.util.List;

import com.koroupware.elecauth.domain.ElecauthListVO;

public interface ElecauthDAO {
	
	public List<ElecauthListVO> elecauthList() throws Exception;
}
