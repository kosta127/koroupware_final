package com.koroupware.attend.domain;

import java.io.Serializable;

import com.koroupware.emp.domain.EmpVO;

public class AttendVO extends EmpVO implements Serializable {
	private int emp_no;
	private String attend_date;
	private int late;
	private int attend_chk;
	private int year;
	private int month;
	
	public void count(int emp_no, int year, int month){
		setYear(year);
		setEmp_no(emp_no);
		setMonth(month);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getAttend_chk() {
		return attend_chk;
	}

	public void setAttend_chk(int attend_chk) {
		this.attend_chk = attend_chk;
	}

	public String getAttend_date() {
		return attend_date;
	}

	public void setAttend_date(String attend_date) {
		this.attend_date = attend_date;
	}

}
