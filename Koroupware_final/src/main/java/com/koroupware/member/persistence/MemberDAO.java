package com.koroupware.member.persistence;

import java.util.List;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;



public interface MemberDAO {
	public List FindId_ListEmp(EmpVO empVO)throws Exception; // 아이디 찾기 다오
	public List FindNo_ListEmp(EmpVO empVO)throws Exception; // 비밀번호 찾기 다오
	public void SignUp(EmpVO empVO)throws Exception; // 회원가입 다오
	public EmpDTO login(EmpVO vo); // 로그인 다오
	public EmpVO FindEmail(int empVO_no); // 이메일찾기(smtp전송 용) 다오
	public void updatePwd(EmpVO vo); // 임시비번으로 수정 다오

}
