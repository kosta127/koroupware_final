package com.koroupware.elecauth.service;

import java.util.List;

import com.koroupware.elecauth.domain.ElecauthListVO;

public interface ElecauthService {
	public List<ElecauthListVO> elecauthList() throws Exception;
}
