package com.koroupware.dept.domain;

import java.io.Serializable;

public class DeptVO implements Serializable{
	private int dept_no;
	private String dept_name;
	private String dept_work;
	private String dept_address;
	private String dept_telephone;

	public DeptVO(){}
	public DeptVO(int dept_no, String dept_name, String dept_work, String dept_address, String dept_telephone) {
		this.dept_no = dept_no;
		this.dept_name = dept_name;
		this.dept_work = dept_work;
		this.dept_address = dept_address;
		this.dept_telephone = dept_telephone;
	}

	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
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
	public String getDept_address() {
		return dept_address;
	}
	public void setDept_address(String dept_address) {
		this.dept_address = dept_address;
	}
	public String getDept_telephone() {
		return dept_telephone;
	}
	public void setDept_telephone(String dept_telephone) {
		this.dept_telephone = dept_telephone;
	}
	
	@Override
	public String toString() {
		return "Dept [dept_no=" + dept_no + ", dept_name=" + dept_name + ", dept_work=" + dept_work + ", dept_address="
				+ dept_address + ", dept_telephone=" + dept_telephone + "]";
	}
}
