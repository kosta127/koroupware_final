package com.koroupware.member.dto;

import java.sql.Date;

// 로그인 후  메인 페이지에 나타난 EmpVO의 데이터(화면 출력용)
public class EmpDTO {
	
	//로그인 용  
	private String emp_id; // + 사원 검색 
	private String emp_password; // + 사원 검색 
	private boolean useCookie;
	

	// 사원 검색
	private String dept_name; // + 사원 검색(부서이름)
	private String emp_name;  // + 문서 검색(문저 작성자)
	private String emp_email;
	private String emp_address;
	private Date emp_hiredate;
	private int emp_no;  // + 문서 검색(문서 작성자 정보확인용)
	
	// 문서 검색
	private int doc_no;
	private String doc_title;
	private String doc_explain;
	private String doc_contents;
	private Date doc_con_period;
	

	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public Date getEmp_hiredate() {
		return emp_hiredate;
	}
	public void setEmp_hiredate(Date emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getDoc_explain() {
		return doc_explain;
	}
	public void setDoc_explain(String doc_explain) {
		this.doc_explain = doc_explain;
	}
	public String getDoc_contents() {
		return doc_contents;
	}
	public void setDoc_contents(String doc_contents) {
		this.doc_contents = doc_contents;
	}
	public Date getDoc_con_period() {
		return doc_con_period;
	}
	public void setDoc_con_period(Date doc_con_period) {
		this.doc_con_period = doc_con_period;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "EmpDTO [emp_id=" + emp_id + ", emp_password=" + emp_password + ", useCookie=" + useCookie
				+ ", dept_name=" + dept_name + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_address="
				+ emp_address + ", emp_hiredate=" + emp_hiredate + ", emp_no=" + emp_no + ", doc_no=" + doc_no
				+ ", doc_title=" + doc_title + ", doc_explain=" + doc_explain + ", doc_contents=" + doc_contents
				+ ", doc_con_period=" + doc_con_period + "]";
	}
}
