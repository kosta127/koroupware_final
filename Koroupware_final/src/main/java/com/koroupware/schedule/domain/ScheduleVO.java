package com.koroupware.schedule.domain;

import java.sql.Timestamp;

public class ScheduleVO {
	private int schedule_no;
	private String schedule_distinct;
	private Timestamp schedule_regdate;
	private Timestamp schedule_deldate;
	private String schedule_title;
	private String schedule_contents;
	private Timestamp schedule_start;
	private Timestamp schedule_end;
	private int emp_no;
	
	public int getSchedule_no() {
		return schedule_no;
	}
	public void setSchedule_no(int schedule_no) {
		this.schedule_no = schedule_no;
	}
	public String getSchedule_distinct() {
		return schedule_distinct;
	}
	public void setSchedule_distinct(String schedule_distinct) {
		this.schedule_distinct = schedule_distinct;
	}
	public Timestamp getSchedule_regdate() {
		return schedule_regdate;
	}
	public void setSchedule_regdate(Timestamp schedule_regdate) {
		this.schedule_regdate = schedule_regdate;
	}
	public Timestamp getSchedule_deldate() {
		return schedule_deldate;
	}
	public void setSchedule_deldate(Timestamp schedule_deldate) {
		this.schedule_deldate = schedule_deldate;
	}
	public String getSchedule_title() {
		return schedule_title;
	}
	public void setSchedule_title(String schedule_title) {
		this.schedule_title = schedule_title;
	}
	public String getSchedule_contents() {
		return schedule_contents;
	}
	public void setSchedule_contents(String schedule_contents) {
		this.schedule_contents = schedule_contents;
	}
	public Timestamp getSchedule_start() {
		return schedule_start;
	}
	public void setSchedule_start(Timestamp schedule_start) {
		this.schedule_start = schedule_start;
	}
	public Timestamp getSchedule_end() {
		return schedule_end;
	}
	public void setSchedule_end(Timestamp schedule_end) {
		this.schedule_end = schedule_end;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	@Override
	public String toString() {
		return "ScheduleVO [schedule_no=" + schedule_no + ", schedule_distinct=" + schedule_distinct
				+ ", schedule_regdate=" + schedule_regdate + ", schedule_deldate=" + schedule_deldate
				+ ", schedule_title=" + schedule_title + ", schedule_contents=" + schedule_contents
				+ ", schedule_start=" + schedule_start + ", schedule_end=" + schedule_end + ", emp_no=" + emp_no + "]";
	}
	
	
}
