package com.koroupware.elecauth.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.ApprovalPrimaryVO;
import com.koroupware.doc.domain.DocVO;
import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;
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

	@Override
	public void elecauthInsert(ElecauthVO ea) throws Exception {
		//전자결재 등록
		//added by jirung
		sqlSession.insert(namespace+".elecauthInsert", ea);
	}

	@Override
	public void approvalListInsert(ApprovalListVO al) throws Exception {
		//결재자리스트 입력
		//added by jirung
		sqlSession.insert(namespace+".approvalListInsert", al);
	}

	@Override
	public void elecauthReferrerInsert(ElecauthReferrerVO ref) throws Exception {
		//참조자리스트 입력
		//added by jirung
		sqlSession.insert(namespace+".elecauthReferrerInsert", ref);
	}

	@Override
	public EmpDetailVO empDetailSelect(int emp_no) throws Exception {
		// 사원 디테일 정보 가져옴
		// added by jirung
		return sqlSession.selectOne(namespace+".empDetailSelect", emp_no);
	}

	@Override
	public List<DocVO> docListSelect() throws Exception {
		// 양식으로 쓸 문서를 조회해옴
		return sqlSession.selectList(namespace+".docListSelect");
	}

	@Override
	public List<EmpDetailVO> empDetailList() throws Exception {
		return sqlSession.selectList(namespace+".empDetailListSelect");
	}

	@Override
	public void elecauthDelete(int elec_auth_no) throws Exception {
		//전자결재 삭제처리
		sqlSession.update(namespace+".elecauthDelete", elec_auth_no);
	}

	@Override
	public void elecauthOkReport(ApprovalPrimaryVO elecauthOkReport) throws Exception {
		sqlSession.update(namespace+".elecauthOkReport", elecauthOkReport);
	}

	@Override
	public void elecauthNoReport(ApprovalPrimaryVO elecauthNoReport) throws Exception {
		sqlSession.update(namespace+".elecauthNoReport", elecauthNoReport);		
	}

	

}
