package com.koroupware.imageroom.domain;

import java.util.Date;

import com.koroupware.dept.domain.EmpVO;

public class EmpDTO extends EmpVO{
	private String dept_name;
	private String office_name;
	private String position_name;
	
	public EmpDTO(){}
	public EmpDTO(int emp_no, String emp_name, String emp_email, String emp_id, String emp_address, Date emp_hiredate,
			String emp_img, int emp_superior, int emp_reporter){
		super(emp_no, emp_name, emp_email, emp_id, emp_address, emp_hiredate, emp_img, emp_superior, emp_reporter);
	}
	public EmpDTO(String dept_name, String office_name, String position_name) {
		super();
		this.dept_name = dept_name;
		this.office_name = office_name;
		this.position_name = position_name;
	}
	public EmpDTO(int emp_no, String emp_name, String emp_email, String emp_id, String emp_address, Date emp_hiredate,
			String emp_img, int emp_superior, int emp_reporter, String dept_name, String office_name,
			String position_name) {
		super(emp_no, emp_name, emp_email, emp_id, emp_address, emp_hiredate, emp_img, emp_superior, emp_reporter);
		this.dept_name = dept_name;
		this.office_name = office_name;
		this.position_name = position_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	@Override
	public String toString() {
		return "EmpDTO [dept_name=" + dept_name + ", office_name=" + office_name + ", position_name=" + position_name
				+ "]";
	}
}
