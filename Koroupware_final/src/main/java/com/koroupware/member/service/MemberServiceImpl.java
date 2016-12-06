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
	@Override
	public String findId(EmpVO empVO) throws Exception {
		String empVO_id=null;
		System.out.println("이름이 들어왔는가?? : "+ empVO.getEmp_name());
		System.out.println("주민번호가 들어왔는가?? : "+empVO.getEmp_residentnumber());
		
		List<EmpVO> list= dao.FindId_ListEmp(empVO);
		System.out.println("디비에 값을 가지고 왔는가? : "+ list);
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getEmp_residentnumber().equals(empVO.getEmp_residentnumber()) && list.get(i).getEmp_name().equals(empVO.getEmp_name())){
				empVO_id =list.get(i).getEmp_id();
				return empVO_id;
			}else{
				System.out.println("값이 없다고 뜨네요");
				empVO_id = null;
			}
		}

		return empVO_id;
	}

	// 회원 번호 찾기 서비스
	@Override
	public Integer findNo(EmpVO empVO) throws Exception {
		String emp_no = null;
		List<EmpVO> list = dao.FindNo_ListEmp(empVO);
		System.out.println("다오에서 받아온 것이 있나?? : "+list);
		
		for(int i=0; i<list.size(); i++){
			
			if(list.get(i).getEmp_email().equals(empVO.getEmp_email()) && list.get(i).getEmp_id().equals(empVO.getEmp_id())){
				return list.get(i).getEmp_no();
			}
		}
		return 0;
	}

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
		System.out.println(vo.getEmp_no());
		System.out.println(vo.getEmp_email());
		dao.updatePwd(vo);	
	}

}
 