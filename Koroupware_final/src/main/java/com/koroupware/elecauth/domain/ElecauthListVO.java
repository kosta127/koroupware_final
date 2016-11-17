package com.koroupware.elecauth.domain;

import java.sql.Date;

public class ElecauthListVO {
	private int elec_auth_no;
	private String elec_auth_title;
	private Date elec_auth_regdate;
	private Date elec_auth_enddate;
	private String doc_title;
	private String dept_name;
	private String emp_name; 
	private String approval_list_pass;
	
	public ElecauthListVO(){}
	
	public ElecauthListVO(int elec_auth_no, String elec_auth_title, Date elec_auth_regdate, Date elec_auth_enddate,
			String doc_title, String dept_name, String emp_name, String approval_list_pass) {
		super();
		this.elec_auth_no = elec_auth_no;
		this.elec_auth_title = elec_auth_title;
		this.elec_auth_regdate = elec_auth_regdate;
		this.elec_auth_enddate = elec_auth_enddate;
		this.doc_title = doc_title;
		this.dept_name = dept_name;
		this.emp_name = emp_name;
		this.approval_list_pass = approval_list_pass;
	}


	public int getElec_auth_no() {
		return elec_auth_no;
	}
	public void setElec_auth_no(int elec_auth_no) {
		this.elec_auth_no = elec_auth_no;
	}
	public String getElec_auth_title() {
		return elec_auth_title;
	}
	public void setElec_auth_title(String elec_auth_title) {
		this.elec_auth_title = elec_auth_title;
	}
	public Date getElec_auth_regdate() {
		return elec_auth_regdate;
	}
	public void setElec_auth_regdate(Date elec_auth_regdate) {
		this.elec_auth_regdate = elec_auth_regdate;
	}
	public Date getElec_auth_enddate() {
		return elec_auth_enddate;
	}
	public void setElec_auth_enddate(Date elec_auth_enddate) {
		this.elec_auth_enddate = elec_auth_enddate;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
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
	public String getApproval_list_pass() {
		return approval_list_pass;
	}
	public void setApproval_list_pass(String approval_list_pass) {
		this.approval_list_pass = approval_list_pass;
	}
	
	
}
