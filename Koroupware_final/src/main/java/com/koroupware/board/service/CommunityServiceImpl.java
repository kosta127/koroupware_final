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
		dao.communityInsert(community);
		
	}

	@Override
	public List<CommunityVO> communityList(int emp_no) throws Exception {
		return dao.communityList(emp_no);
	}
	
	
}
