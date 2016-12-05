package com.koroupware.attend.dto;

public class AttendDTO {
	  private int emp_no;
	  private String attend_date;
	  private int late;
	  private int attend_chk;
	  private double result;

	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getAttend_date() {
		return attend_date;
	}
	public void setAttend_date(String attend_date) {
		this.attend_date = attend_date;
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
	  
	  
}
