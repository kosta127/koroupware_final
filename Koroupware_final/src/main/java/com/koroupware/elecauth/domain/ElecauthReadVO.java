package com.koroupware.elecauth.domain;

import java.sql.Date;

public class ElecauthReadVO {
	private int elec_auth_no;
	private Date elec_auth_enddate;
	private Date elec_auth_regdate;
	private Date elec_auth_con_period;
	private String elec_auth_title;
	private String elec_auth_contents;
	private int emp_no;
	
	private String doc_title;
	private String emp_name;
	
	public int getElec_auth_no() {
		return elec_auth_no;
	}
	public void setElec_auth_no(int elec_auth_no) {
		this.elec_auth_no = elec_auth_no;
	}
	public Date getElec_auth_enddate() {
		return elec_auth_enddate;
	}
	public void setElec_auth_enddate(Date elec_auth_enddate) {
		this.elec_auth_enddate = elec_auth_enddate;
	}
	public Date getElec_auth_regdate() {
		return elec_auth_regdate;
	}
	public void setElec_auth_regdate(Date elec_auth_regdate) {
		this.elec_auth_regdate = elec_auth_regdate;
	}
	public Date getElec_auth_con_period() {
		return elec_auth_con_period;
	}
	public void setElec_auth_con_period(Date elec_auth_con_period) {
		this.elec_auth_con_period = elec_auth_con_period;
	}
	public String getElec_auth_title() {
		return elec_auth_title;
	}
	public void setElec_auth_title(String elec_auth_title) {
		this.elec_auth_title = elec_auth_title;
	}
	public String getElec_auth_contents() {
		return elec_auth_contents;
	}
	public void setElec_auth_contents(String elec_auth_contents) {
		this.elec_auth_contents = elec_auth_contents;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}	
	
}
