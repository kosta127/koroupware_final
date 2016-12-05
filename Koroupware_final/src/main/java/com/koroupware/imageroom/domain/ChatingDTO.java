package com.koroupware.imageroom.domain;

import java.util.Date;

public class ChatingDTO extends ImageRoomHisVO{
	private String emp_name;
	private String dept_name;
	private String office_name;
	private String position_name;
	
	public ChatingDTO(){}
	public ChatingDTO(String emp_name, String dept_name, String office_name, String position_name) {
		super();
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.office_name = office_name;
		this.position_name = position_name;
	}
	public ChatingDTO(int image_room_his_no, String image_room_his_contents, Date image_room_his_regdate,
			Date image_room_his_deldate, int image_room_no, int emp_no){
		super(image_room_his_no, image_room_his_contents, image_room_his_regdate, image_room_his_deldate,
				image_room_no, emp_no);
	}
	public ChatingDTO(int image_room_his_no, String image_room_his_contents, Date image_room_his_regdate,
			Date image_room_his_deldate, int image_room_no, int emp_no, String emp_name, String dept_name,
			String office_name, String position_name) {
		super(image_room_his_no, image_room_his_contents, image_room_his_regdate, image_room_his_deldate, 
				image_room_no, emp_no);
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.office_name = office_name;
		this.position_name = position_name;
	}
	
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
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	@Override
	public String toString() {
		return "ChatingDTO [emp_name=" + emp_name + ", dept_name=" + dept_name + ", office_name=" + office_name
				+ ", position_name=" + position_name + "]";
	}
}
