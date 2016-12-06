package com.koroupware.estimate.service;

import java.util.List;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.member.dto.EmpDTO;

public interface EstimateService {
	
	public int attendCount(AttendVO attendVO)throws Exception;

	public List<EmpDTO> attendDept_EmpList(int dept_no) throws Exception;

	public List<ResultVO> AttendQuaterList() throws Exception;

	public int empCount(int dept_no) throws Exception;

	public void insertAttendQuater(ResultVO resultVO) throws Exception;

	public List<ResultDTO> AttendQuaterDTOList() throws Exception;
	
}
