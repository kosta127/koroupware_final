package com.koroupware.imageroom.domain;

import java.util.Date;

public class ImageRoomDTO extends ImageRoomVO{
	private String emp_name;
	private String dept_name;
	private String office_name;
	private String position_name;
	
	public ImageRoomDTO(){}
	public ImageRoomDTO(int image_room_no, String image_room_name, Date image_room_regdate,
			Date image_room_deldate, int emp_no){
		super(image_room_no, image_room_name, image_room_regdate, image_room_deldate, emp_no);
	}
	public ImageRoomDTO(String emp_name, String dept_name, String office_name, String position_name) {
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.office_name = office_name;
		this.position_name = position_name;
	}
	public ImageRoomDTO(int image_room_no, String image_room_name, Date image_room_regdate, Date image_room_deldate,
			int emp_no, String emp_name, String dept_name, String office_name, String position_name) {
		super(image_room_no, image_room_name, image_room_regdate, image_room_deldate, emp_no);
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
		return "ImageRoomDTO [emp_name=" + emp_name + ", dept_name=" + dept_name + ", office_name=" + office_name
				+ ", position_name=" + position_name + "]";
	}	
}
