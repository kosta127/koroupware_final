package com.koroupware.board.persistence;

import java.util.List;

import com.koroupware.board.domain.CommunityVO;

public interface CommunityDAO {

	public int communityInsert(CommunityVO community)throws Exception;
	public List<CommunityVO> communityList(int emp_no)throws Exception;
	public int getCommunityNo()throws Exception;
}
