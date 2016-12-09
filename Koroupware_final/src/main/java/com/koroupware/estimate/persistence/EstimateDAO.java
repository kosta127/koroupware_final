package com.koroupware.estimate.persistence;

import java.util.List;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.member.dto.EmpDTO;

public interface EstimateDAO {

	int attendCount(AttendVO attendVO);
	
	int empCount(int dept_no);

	List<EmpDTO> attendDept_EmpList(int dept_no);

	void insertAttendQuater(ResultVO resultVO);

	List<ResultVO> attendQuaterList();

	List<ResultDTO> attendQuaterDTOList();

	int est_check(int emp_no);

}
