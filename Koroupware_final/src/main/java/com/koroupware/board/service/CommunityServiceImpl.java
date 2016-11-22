package com.koroupware.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.board.domain.CommunityVO;
import com.koroupware.board.persistence.CommunityDAO;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Inject CommunityDAO dao;

	@Override
	public void communityRegist(CommunityVO community) throws Exception {
		System.out.println("service");
		dao.communityInsert(community);
		
	}

	@Override
	public List<CommunityVO> communityList() throws Exception {
		return dao.communityList();
	}
	
	
}
