package com.koroupware.member.dto;

import java.sql.Date;

// 로그인 후  메인 페이지에 나타난 EmpVO의 데이터(화면 출력용)
public class EmpDTO {
	
	//로그인 용  
	private String emp_id; // + 사원 검색 
	private String emp_password; // + 사원 검색 
	private boolean useCookie;
	
	private int dept_no;//
	private int office_no;//
	private int position_no;//
	private int emp_superior;//
	private int emp_reporter;//
	private String emp_approvalyn;//
	private String emp_residentNum_left;
	private String emp_residentNum_right;
	private Date emp_resigndate;
	private String emp_email_sign;//
	private String emp_elec_auth_signkey;
	private String emp_img;
	private String emp_elec_auth_img;
	private Date emp_login;
	private String emp_residentnumber;
	
	

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
	
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public int getOffice_no() {
		return office_no;
	}
	public void setOffice_no(int office_no) {
		this.office_no = office_no;
	}
	public int getPosition_no() {
		return position_no;
	}
	public void setPosition_no(int position_no) {
		this.position_no = position_no;
	}
	public int getEmp_superior() {
		return emp_superior;
	}
	public void setEmp_superior(int emp_superior) {
		this.emp_superior = emp_superior;
	}
	public int getEmp_reporter() {
		return emp_reporter;
	}
	public void setEmp_reporter(int emp_reporter) {
		this.emp_reporter = emp_reporter;
	}
	public String getEmp_approvalyn() {
		return emp_approvalyn;
	}
	public void setEmp_approvalyn(String emp_approvalyn) {
		this.emp_approvalyn = emp_approvalyn;
	}
	public String getEmp_residentNum_left() {
		return emp_residentNum_left;
	}
	public void setEmp_residentNum_left(String emp_residentNum_left) {
		this.emp_residentNum_left = emp_residentNum_left;
	}
	public String getEmp_residentNum_right() {
		return emp_residentNum_right;
	}
	public void setEmp_residentNum_right(String emp_residentNum_right) {
		this.emp_residentNum_right = emp_residentNum_right;
	}
	public Date getEmp_resigndate() {
		return emp_resigndate;
	}
	public void setEmp_resigndate(Date emp_resigndate) {
		this.emp_resigndate = emp_resigndate;
	}
	public String getEmp_email_sign() {
		return emp_email_sign;
	}
	public void setEmp_email_sign(String emp_email_sign) {
		this.emp_email_sign = emp_email_sign;
	}
	public String getEmp_elec_auth_signkey() {
		return emp_elec_auth_signkey;
	}
	public void setEmp_elec_auth_signkey(String emp_elec_auth_signkey) {
		this.emp_elec_auth_signkey = emp_elec_auth_signkey;
	}
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}
	public String getEmp_elec_auth_img() {
		return emp_elec_auth_img;
	}
	public void setEmp_elec_auth_img(String emp_elec_auth_img) {
		this.emp_elec_auth_img = emp_elec_auth_img;
	}
	public Date getEmp_login() {
		return emp_login;
	}
	public void setEmp_login(Date emp_login) {
		this.emp_login = emp_login;
	}
	public String getEmp_residentnumber() {
		return emp_residentnumber;
	}
	public void setEmp_residentnumber(String emp_residentnumber) {
		this.emp_residentnumber = emp_residentnumber;
	}
	@Override
	public String toString() {
		return "EmpDTO [emp_id=" + emp_id + ", emp_password=" + emp_password + ", useCookie=" + useCookie + ", dept_no="
				+ dept_no + ", office_no=" + office_no + ", position_no=" + position_no + ", emp_superior="
				+ emp_superior + ", emp_reporter=" + emp_reporter + ", emp_approvalyn=" + emp_approvalyn
				+ ", emp_residentNum_left=" + emp_residentNum_left + ", emp_residentNum_right=" + emp_residentNum_right
				+ ", emp_resigndate=" + emp_resigndate + ", emp_email_sign=" + emp_email_sign
				+ ", emp_elec_auth_signkey=" + emp_elec_auth_signkey + ", emp_img=" + emp_img + ", emp_elec_auth_img="
				+ emp_elec_auth_img + ", emp_login=" + emp_login + ", emp_residentnumber=" + emp_residentnumber
				+ ", dept_name=" + dept_name + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_address="
				+ emp_address + ", emp_hiredate=" + emp_hiredate + ", emp_no=" + emp_no + ", doc_no=" + doc_no
				+ ", doc_title=" + doc_title + ", doc_explain=" + doc_explain + ", doc_contents=" + doc_contents
				+ ", doc_con_period=" + doc_con_period + "]";
	}

}
