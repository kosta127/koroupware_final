package com.koroupware.dept.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.koroupware.dept.domain.DeptVO;
import com.koroupware.dept.domain.OrgChartDTO;
import com.koroupware.dept.domain.OrgChartEmpVO;
public interface DeptDAO {
	public List<DeptVO> deptList() throws Exception;
	public List<OrgChartEmpVO> orgChartList(Integer dept_no) throws Exception;
	public OrgChartEmpVO orgChartEmpSelect(Integer emp_no) throws Exception;
	public List<OrgChartEmpVO> orgChartTreeList() throws Exception;
}
