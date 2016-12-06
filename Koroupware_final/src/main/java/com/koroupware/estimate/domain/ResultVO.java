package com.koroupware.estimate.domain;

public class ResultVO {

	private int emp_no;
	private String emp_name;
	private int result_year;
	private double quarterfirst;
	private double quartersecond;
	private double quarterthird;
	private double quarterforth;
	private double finalquarter;
	private double future_quater;
	
	public double getFuture_quater() {
		return future_quater;
	}
	public void setFuture_quater(double future_quater) {
		this.future_quater = future_quater;
	}
	public int getResult_year() {
		return result_year;
	}
	public void setResult_year(int result_year) {
		this.result_year = result_year;
	}
	public double getFinalquarter() {
		return finalquarter;
	}
	public void setFinalquarter(double finalquarter) {
		this.finalquarter = finalquarter;
	}
	public double getQuarterfirst() {
		return quarterfirst;
	}
	public void setQuarterfirst(double quarterfirst) {
		this.quarterfirst = quarterfirst;
	}
	
	public double getQuartersecond() {
		return quartersecond;
	}
	public void setQuartersecond(double quartersecond) {
		this.quartersecond = quartersecond;
	}
	
	public double getQuarterthird() {
		return quarterthird;
	}
	public void setQuarterthird(double quarterthird) {
		this.quarterthird = quarterthird;
	}
	
	public double getQuarterforth() {
		return quarterforth;
	}
	public void setQuarterforth(double quarterforth) {
		this.quarterforth = quarterforth;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
 	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


}
