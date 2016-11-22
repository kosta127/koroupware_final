package com.koroupware.emp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.emp.domain.TelVO;
import com.koroupware.emp.persistence.EmpDAO;
import com.koroupware.emp.persistence.TelDAO;

@Service
public class EmpTelServiceImpl implements EmpTelService {

	@Inject
	private EmpDAO empDao;
	
	@Inject
	private TelDAO telDao;

	@Transactional
	@Override
	public void signUp(EmpVO empVo, TelVO telVo) throws Exception { //회원가입
		empDao.create(empVo); //회원생성
		System.out.println("회원생성");
		telDao.create(telVo); //회원전화생성
	}

	@Override
	public List<String> empIdList() throws Exception { //전체 회원 아이디 목록
		return empDao.empId();
	}

	@Override
	public void empDataUpdate(EmpVO empVo) throws Exception { //회원정보수정
		empDao.update(empVo);
	}

	@Override
	public List<TelVO> telList(int emp_no) throws Exception { //회원이 보유한 전화번호 목록
		return telDao.telList(emp_no);
	}

	@Override
	public void addTel(TelVO telVo) throws Exception { //회원 전화번호 추가
		telDao.addTel(telVo);
	}

	@Override
	public void updateTel(TelVO telVo) throws Exception { //회원 전화번호 업데이트
		telDao.updateTel(telVo);
	}

	@Override
	public void deleteTel(int tel_no) throws Exception { //회원 전화번호 삭제
		telDao.deleteTel(tel_no);
	}

	@Override
	public EmpVO empList(int emp_no) throws Exception {
		return empDao.empList(emp_no);
	}


}
