package com.koroupware.attend.service;

import java.util.List;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.attend.dto.AttendDTO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.member.dto.EmpDTO;

public interface attendService {

	public void addAttend(AttendVO attendVO)throws Exception;
	public AttendVO attendCheck(AttendVO attendVO);
	public List<AttendDTO> attendList(int emp_no);

}
