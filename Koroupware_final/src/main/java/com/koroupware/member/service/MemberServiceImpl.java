package com.koroupware.member.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.member.domain.EmailVO;
import com.koroupware.emp.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;
import com.koroupware.member.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	 
	@Inject
	private MemberDAO dao;

	// 아이디 찾기 서비스
/*	@Override
	public String findId(EmpVO empVO) throws Exception {
		String empVO_id=null;
		List<EmpVO> list= dao.FindId_ListEmp(empVO);
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_residentnumber().equals(empVO.getEmp_residentnumber())){
				empVO_id =list.get(i).getEmp_id();
				return empVO_id;
			}
		}
		return "null";
	}

	// 회원 번호 찾기 서비스
	@Override
	public Integer findNo(EmpVO empVO) throws Exception {
		String emp_no = null;
		List<EmpVO> list = dao.FindNo_ListEmp(empVO);
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_residentnumber().equals(empVO.getEmp_residentnumber()) && list.get(i).getEmp_id().equals(empVO.getEmp_id())){
				System.out.println(list.get(i).getEmp_no());
				return list.get(i).getEmp_no();
			}
		}
		return 0;
	}
*/
	//회원가입 서비스
	@Override
	public void SignUp(EmpVO empVO) throws Exception {
	 System.out.println(empVO.getEmp_id());
	 dao.SignUp(empVO);
	}

	//로그인 서비스
	@Override
	public EmpDTO login(EmpVO vo) {
		return dao.login(vo);
	}

	// smtp용 이메일 찾기 서비스
	@Override
	public EmpVO findEmail(int empVO_no) {
		return dao.FindEmail(empVO_no);
	}

	// 임시비밀번호 수정 서비스
	@Override
	public void updatePwd(EmpVO vo) {
		dao.updatePwd(vo);	
	}

	@Override
	public String findId(EmpVO emp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findNo(EmpVO emp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
 