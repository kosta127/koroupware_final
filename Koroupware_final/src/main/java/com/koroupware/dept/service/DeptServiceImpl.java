package com.koroupware.dept.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.common.util.ETC;
import com.koroupware.dept.domain.DeptVO;
import com.koroupware.dept.domain.OrgChartDTO;
import com.koroupware.dept.domain.OrgChartEmpVO;
import com.koroupware.dept.persistence.DeptDAO;

@Service
public class DeptServiceImpl implements DeptService{
	@Inject
	private DeptDAO dao;
	
	@Override
	public List<DeptVO> deptList() throws Exception{
		return dao.deptList();
	}
	
	@Override
	public List<OrgChartDTO> orgChartList() throws Exception{
		List<OrgChartDTO> orgChartList = new ArrayList<OrgChartDTO>();
		List<DeptVO> deptList = dao.deptList();
		
		Iterator<DeptVO> iter = deptList.iterator();
		
		while(iter.hasNext()){
			DeptVO dept = iter.next();
			
			OrgChartDTO orgChart = new OrgChartDTO();
			
			List<OrgChartEmpVO> orgChartEmpModelList = dao.orgChartList(dept.getDept_no());
			
			String telephone = dept.getDept_telephone();
			dept.setDept_telephone(ETC.toTelephoneFormat(telephone));
			
			orgChart.setDeptVO(dept);
			orgChart.setOrgChartEmpVOList(orgChartEmpModelList);
			
			orgChartList.add(orgChart);
		}
		
		return orgChartList;
	}

	@Override
	public OrgChartEmpVO orgChartEmpRead(Integer emp_no) throws Exception{
		return dao.orgChartEmpSelect(emp_no);
	}

	@Override
	public List<OrgChartEmpVO> orgChartTreeList() throws Exception {
		return dao.orgChartTreeList();
	}
}
