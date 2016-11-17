package com.koroupware.elecauth.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
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
	public ElecauthReadVO elecauthRead(Integer elec_auth_no) throws Exception {
		
		return dao.elecauthRead(elec_auth_no);
	}

}
