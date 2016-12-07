package com.koroupware.attend.persistence;

import java.util.List;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.attend.dto.AttendDTO;
import com.koroupware.emp.domain.EmpVO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.member.dto.EmpDTO;

public interface AttendDAO {
	void attendInsert(AttendVO attendVO);
	AttendVO attendCheck(AttendVO attendVO);
	List<AttendDTO> attendList(int emp_no);



	
}
