package com.koroupware.elecauth.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReadApprovalVO;
import com.koroupware.elecauth.domain.ElecauthReadReferrerVO;

@Repository
public class ElecauthDAOImpl implements ElecauthDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.koroupware.mappers.ElecauthMapper";

	@Override
	public List<ElecauthListVO> elecauthList() throws Exception {
		List<ElecauthListVO> elecauthList=sqlSession.selectList(namespace+".elecauthList");
		
		return elecauthList;
	}

	@Override
	public ElecauthReadVO elecauthRead(Integer elec_auth_no) throws Exception {
		ElecauthReadVO elecauthRead=sqlSession.selectOne(namespace+".elecauthRead", elec_auth_no);
		
		return elecauthRead;
	}

	@Override
	public List<ElecauthReadApprovalVO> elecauthReadApproval(Integer elec_auth_no) throws Exception {
		List<ElecauthReadApprovalVO> elecauthReadApproval
			=sqlSession.selectList(namespace+".elecauthReadApproval", elec_auth_no);
		
		return elecauthReadApproval;
	}

	@Override
	public List<ElecauthReadReferrerVO> elecauthReadReferrer(Integer elec_auth_no) throws Exception {
		List<ElecauthReadReferrerVO> elecauthReadReferrer
			=sqlSession.selectList(namespace+".elecauthReadReferrer", elec_auth_no);
		
		return elecauthReadReferrer;
	}

}
