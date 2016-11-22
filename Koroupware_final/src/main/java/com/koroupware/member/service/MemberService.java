package com.koroupware.member.service;

import java.util.Map;

import com.koroupware.member.domain.EmailVO;
import com.koroupware.member.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;


public interface MemberService {

	public String findId(EmpVO emp) throws Exception; //아이디 찾기 서비스
	public Integer findNo(EmpVO emp) throws Exception; // 회원 번호 찾기 서비스
	public void SignUp(EmpVO emp)throws Exception; // 회원가입 서비스
	public EmpDTO login(EmpVO vo); // 로그인 서비스
	public EmpVO findEmail(int empVO_no); // smtp용 이메일 찾기 서비스
	public void updatePwd(EmpVO vo); //임시 비밀번호 수정 서비스
}
