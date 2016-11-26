package com.koroupware.elecauth.domain;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.koroupware.elecauth.dto.ElecauthDTO;

public class ElecauthVO implements Serializable {
	private int elec_auth_no;
	private int emp_no;
	private int doc_no;
	private int elec_auth_management_dept_no;	
	private String elec_auth_title;
	private String elec_auth_contents;
	private Date elec_auth_enddate;
	private String elec_auth_temporary_saveYN;
	private Date elec_auth_con_period;
	private Date elec_auth_regdate;
	private Date elec_auth_deldate;

	public ElecauthVO() {
		this.elec_auth_temporary_saveYN = "N"; //DEFAULT
	}
	
	public ElecauthVO(ElecauthDTO dto){
		this();
		this.emp_no = dto.getEmp_no();
		this.doc_no = dto.getDoc_no();
		this.elec_auth_management_dept_no = dto.getElec_auth_management_dept_no();
		this.elec_auth_title = dto.getElec_auth_title();
		this.elec_auth_contents = dto.getElec_auth_contents();
		this.elec_auth_enddate = Date.valueOf(dto.getElec_auth_enddate());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar conDate = Calendar.getInstance();
		conDate.roll(Calendar.YEAR, dto.getElec_auth_con_period());
		this.elec_auth_con_period = Date.valueOf(sdf.format(conDate.getTime()));
	}

	public ElecauthVO(int elec_auth_no, int emp_no, int doc_no, int elec_auth_management_dept_no, String elec_auth_title,
			String elec_auth_contents, Date elec_auth_enddate, String elec_auth_temporary_saveYN,
			Date elec_auth_con_period, Date elec_auth_regdate, Date elec_auth_deldate) {
		this();
		this.elec_auth_no = elec_auth_no;
		this.emp_no = emp_no;
		this.doc_no = doc_no;
		this.elec_auth_management_dept_no = elec_auth_management_dept_no;
		this.elec_auth_title = elec_auth_title;
		this.elec_auth_contents = elec_auth_contents;
		this.elec_auth_enddate = elec_auth_enddate;
		this.elec_auth_temporary_saveYN = elec_auth_temporary_saveYN;
		this.elec_auth_con_period = elec_auth_con_period;
		this.elec_auth_regdate = elec_auth_regdate;
		this.elec_auth_deldate = elec_auth_deldate;
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

	public int getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}

	public int getElec_auth_management_dept_no() {
		return elec_auth_management_dept_no;
	}

	public void setElec_auth_management_dept_no(int elec_auth_management_dept_no) {
		this.elec_auth_management_dept_no = elec_auth_management_dept_no;
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

	public Date getElec_auth_enddate() {
		return elec_auth_enddate;
	}
	
	public void setElec_auth_enddate(Date elec_auth_enddate) {
		this.elec_auth_enddate = elec_auth_enddate;
	}

	public String getElec_auth_temporary_saveYN() {
		return elec_auth_temporary_saveYN;
	}

	public void setElec_auth_temporary_saveYN(String elec_auth_temporary_saveYN) {
		this.elec_auth_temporary_saveYN = elec_auth_temporary_saveYN;
	}

	public Date getElec_auth_con_period() {
		return elec_auth_con_period;
	}

	public void setElec_auth_con_period(Date elec_auth_con_period) {
		this.elec_auth_con_period = elec_auth_con_period;
	}

	public Date getElec_auth_regdate() {
		return elec_auth_regdate;
	}

	public void setElec_auth_regdate(Date elec_auth_regdate) {
		this.elec_auth_regdate = elec_auth_regdate;
	}

	public Date getElec_auth_deldate() {
		return elec_auth_deldate;
	}

	public void setElec_auth_deldate(Date elec_auth_deldate) {
		this.elec_auth_deldate = elec_auth_deldate;
	}

	@Override
	public String toString() {
		return "ElecauthVO [elec_auth_no=" + elec_auth_no + ", emp_no=" + emp_no + ", doc_no=" + doc_no
				+ ", elec_auth_management_dept_no=" + elec_auth_management_dept_no + ", elec_auth_title="
				+ elec_auth_title + ", elec_auth_contents=" + elec_auth_contents + ", elec_auth_enddate="
				+ elec_auth_enddate + ", elec_auth_temporary_saveYN=" + elec_auth_temporary_saveYN
				+ ", elec_auth_con_period=" + elec_auth_con_period + ", elec_auth_regdate=" + elec_auth_regdate
				+ ", elec_auth_deldate=" + elec_auth_deldate + "]";
	}
	
}