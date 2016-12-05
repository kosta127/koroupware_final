package com.koroupware.dept.service;

import java.util.List;

import com.koroupware.dept.domain.DeptVO;
import com.koroupware.dept.domain.OrgChartDTO;
import com.koroupware.dept.domain.OrgChartEmpVO;

public interface DeptService {
	public List<DeptVO> deptList() throws Exception;
	public List<OrgChartDTO> orgChartList() throws Exception;
	public OrgChartEmpVO orgChartEmpRead(Integer emp_no) throws Exception;
	public List<OrgChartEmpVO> orgChartTreeList() throws Exception;
}
