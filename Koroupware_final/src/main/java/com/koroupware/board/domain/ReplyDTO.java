package com.koroupware.board.domain;

import java.sql.Timestamp;

public class ReplyDTO extends ReplyVO{
	private String emp_name;
	private String dept_name;
	private String position_name;
	private String office_name;
	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	
	public ReplyDTO(){}
	public ReplyDTO(int reply_no, String reply_contents, Timestamp reply_regdate, Timestamp reply_deldate, int emp_no,
			int board_no){
		super(reply_no, reply_contents, reply_regdate, reply_deldate, emp_no, board_no);
	}
	public ReplyDTO(int reply_no, String reply_contents, Timestamp reply_regdate, Timestamp reply_deldate, int emp_no,
			int board_no, String emp_name, String dept_name, String position_name, String office_name) {
		super(reply_no, reply_contents, reply_regdate, reply_deldate, emp_no, board_no);
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.position_name = position_name;
		this.office_name = office_name;
	}
	public ReplyDTO(String emp_name, String dept_name, String position_name, String office_name) {
		super();
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.position_name = position_name;
		this.office_name = office_name;
	}
	@Override
	public String toString() {
		return "ReplyDTO [emp_name=" + emp_name + ", dept_name=" + dept_name + ", position_name=" + position_name
				+ ", office_name=" + office_name + "]";
	}
}
