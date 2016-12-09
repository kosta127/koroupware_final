package com.koroupware.estimate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.attend.persistence.AttendDAO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.estimate.persistence.EstimateDAO;
import com.koroupware.member.dto.EmpDTO;

@Service
public class EstimateServiceImpl implements EstimateService{

	@Inject
	private EstimateDAO estimateDAO;
	// 인터페이스는 new가 되지 않으므로 꼭 임프라이해야 가지고 올 수 있음.
	
	@Override
	public int attendCount(AttendVO attendVO) throws Exception {
		return estimateDAO.attendCount(attendVO);
	}

	@Override
	public int empCount(int dept_no) throws Exception {
		return estimateDAO.empCount(dept_no);
	}

	@Override
	public List<EmpDTO> attendDept_EmpList(int dept_no) throws Exception {
		List<EmpDTO> attendDept_EmpList = estimateDAO.attendDept_EmpList(dept_no);
		return attendDept_EmpList;
	}

	@Override
	public void insertAttendQuater(ResultVO ResultVO) throws Exception {
		estimateDAO.insertAttendQuater(ResultVO);
		
	}

	@Override
	public List<ResultVO> AttendQuaterList() throws Exception {
		List<ResultVO> list = estimateDAO.attendQuaterList();
		return list;
	}

	@Override
	public List<ResultDTO> AttendQuaterDTOList() throws Exception {
		List<ResultDTO> list = estimateDAO.attendQuaterDTOList();
		return list;
	}

	@Override
	public int est_check(int emp_no) throws Exception {
		int result = estimateDAO.est_check(emp_no);
		return result;
	}
}
