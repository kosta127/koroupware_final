package com.koroupware.member.persistence;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.koroupware.member.mapper.memberMapper";

	//아이디 찾기 다오
	@Override
	public List FindId_ListEmp(EmpVO empVO) throws Exception {
		return sqlSession.selectList(namespace + ".FindId_ListEmp", empVO);
	}
	
	// 회원 번호 찾기 다오
	@Override
	public List FindNo_ListEmp(EmpVO empVO) throws Exception {

		return sqlSession.selectList(namespace + ".FindNo_ListEmp", empVO);
	}

	// 회원 가입 다오
	@Override
	public void SignUp(EmpVO empVO) throws Exception {
		sqlSession.insert(namespace + ".SignUp", empVO);

	}

	// 로그인 하여 메인 페이지에 가지고 올 데이터    다오
	@Override
	public EmpDTO login(EmpVO vo) {
		return sqlSession.selectOne(namespace + ".login", vo);
	}

	
	// smtp에 사용할 사용자 이메일 찾기 다오
	@Override
	public EmpVO FindEmail(int empVO_no) {
		return sqlSession.selectOne(namespace+".find_Email", empVO_no);
	}

	// 임시비밀번호 저장 다오
	@Override
	public void updatePwd(EmpVO vo) {
		sqlSession.update(namespace+".updatePwd", vo);
	}

}
