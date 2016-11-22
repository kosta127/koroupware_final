package com.koroupware.board.service;

import java.util.List;

import com.koroupware.board.domain.CommunityVO;

public interface CommunityService {

	public void communityRegist(CommunityVO community)throws Exception;
	public List<CommunityVO> communityList()throws Exception;
}
