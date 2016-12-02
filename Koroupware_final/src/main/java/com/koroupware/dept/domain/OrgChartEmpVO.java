package com.koroupware.dept.domain; 

import java.io.Serializable;
import java.util.Date;

import com.koroupware.emp.domain.EmpVO;

public class OrgChartEmpVO extends EmpVO implements Serializable{
	private String position_name;
	private String office_name;
	private String dept_name;
	private String dept_work;
	private String classification;
	
	public OrgChartEmpVO(){}
	public OrgChartEmpVO(String position_name, String office_name, String dept_name, String dept_work,
			String classification) {
		this.position_name = position_name;
		this.office_name = office_name;
		this.dept_name = dept_name;
		this.dept_work = dept_work;
		this.classification = classification;
	}
	
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_work() {
		return dept_work;
	}
	public void setDept_work(String dept_work) {
		this.dept_work = dept_work;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	@Override
	public String toString() {
		return "OrgChartEmpVO [position_name=" + position_name + ", office_name=" + office_name + ", dept_name="
				+ dept_name + ", dept_work=" + dept_work + ", classification=" + classification + "]";
	}
}
