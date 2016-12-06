package com.koroupware.elecauth.domain;

public class ElecauthReferrerVO{
	private int elec_auth_no;
	private int emp_no;
	
	public ElecauthReferrerVO(){}

	public ElecauthReferrerVO(int elec_auth_no, int emp_no) {
		super();
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
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

	@Override
	public String toString() {
		return "ElecauthReferrerVO [elec_auth_no=" + elec_auth_no + ", emp_no=" + emp_no + "]";
	}
	
	
}
