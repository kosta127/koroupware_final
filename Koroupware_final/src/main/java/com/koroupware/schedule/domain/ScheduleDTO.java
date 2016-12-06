package com.koroupware.schedule.domain;

public class ScheduleDTO {
	private int year;
	private int month;
	private int day;
	private int startDay;
	private int endDay;
	
	
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	@Override
	public String toString() {
		return "ScheduleDTO [year=" + year + ", month=" + month + ", day=" + day + ", startDay=" + startDay
				+ ", endDay=" + endDay + "]";
	}
	
	
	
}
