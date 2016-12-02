package com.koroupware.dept.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.dept.domain.DeptVO;
import com.koroupware.dept.domain.OrgChartDTO;
import com.koroupware.dept.domain.OrgChartEmpVO;

@Repository
public class DeptDAOImpl implements DeptDAO{
	private static final String NAMESPACE = "com.koroupware.mappers.DeptMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public List<DeptVO> deptList() throws Exception {
		return session.selectList(NAMESPACE + ".deptList");
	}

	@Override
	public List<OrgChartEmpVO> orgChartList(Integer dept_no) throws Exception {
		return session.selectList(NAMESPACE + ".orgChartList", dept_no);
	}

	@Override
	public OrgChartEmpVO orgChartEmpSelect(Integer emp_no) throws Exception {
		return session.selectOne(NAMESPACE + ".orgChartEmpRead", emp_no);
	}

	@Override
	public List<OrgChartEmpVO> orgChartTreeList() throws Exception {
		return session.selectList(NAMESPACE + ".orgChartTreeList");
	}
}
