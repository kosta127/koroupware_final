package com.koroupware.elecauth.domain;

import java.io.Serializable;
import java.sql.Date;

public class ApprovalListVO implements Serializable{
	private int elec_auth_no;
	private int emp_no;
	private String approval_list_pass;
	private int approval_list_step ;
	private Date approval_list_date;
	 
	public ApprovalListVO(){}
	
	public ApprovalListVO(int elec_auth_no, int emp_no, String approval_list_pass, int approval_list_step, Date approval_list_date) {
		super();
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
		this.approval_list_pass = approval_list_pass;
		this.approval_list_step = approval_list_step;
		this.approval_list_date = approval_list_date;
	}

	public int getElec_auth_no() {
		return elec_auth_no;
	}

	public void setElec_auth_no(int elec_auth_no) {
		this.elec_auth_no = elec_auth_no;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getApproval_list_pass() {
		return approval_list_pass;
	}

	public void setApproval_list_pass(String approval_list_pass) {
		this.approval_list_pass = approval_list_pass;
	}

	public int getApproval_list_step() {
		return approval_list_step;
	}

	public void setApproval_list_step(int approval_list_step) {
		this.approval_list_step = approval_list_step;
	}

	public Date getApproval_list_date() {
		return approval_list_date;
	}

	public void setApproval_list_date(Date approval_list_date) {
		this.approval_list_date = approval_list_date;
	}

	@Override
	public String toString() {
		return "ApprovalListVO [elec_auth_no=" + elec_auth_no + ", emp_no=" + emp_no + ", approval_list_pass="
				+ approval_list_pass + ", approval_list_step=" + approval_list_step + ", approval_list_date="
				+ approval_list_date + "]";
	}
	
	
	
}
