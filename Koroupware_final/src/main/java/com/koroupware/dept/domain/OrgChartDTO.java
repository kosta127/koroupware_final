package com.koroupware.dept.domain;

import java.util.List;

public class OrgChartDTO {
	private DeptVO deptVO;
	private List<OrgChartEmpVO> orgChartEmpVOList;
	
	public OrgChartDTO(){}
	public OrgChartDTO(DeptVO deptVO, List<OrgChartEmpVO> orgChartEmpVOList) {
		this.deptVO = deptVO;
		this.orgChartEmpVOList = orgChartEmpVOList;
	}
	
	public DeptVO getDeptVO() {
		return deptVO;
	}
	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}
	public List<OrgChartEmpVO> getOrgChartEmpVOList() {
		return orgChartEmpVOList;
	}
	public void setOrgChartEmpVOList(List<OrgChartEmpVO> orgChartEmpVOList) {
		this.orgChartEmpVOList = orgChartEmpVOList;
	}
	
	@Override
	public String toString() {
		return "OrgChartDTO [deptVO=" + deptVO + ", orgChartEmpVOList=" + orgChartEmpVOList + "]";
	}
}
