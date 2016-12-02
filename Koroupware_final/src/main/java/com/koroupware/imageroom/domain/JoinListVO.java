package com.koroupware.imageroom.domain;

public class JoinListVO {
	private int image_room_no;
	private int emp_no;
	
	public JoinListVO(int image_room_no, int emp_no) {
		this.image_room_no = image_room_no;
		this.emp_no = emp_no;
	}
	
	public int getImage_room_no() {
		return image_room_no;
	}
	public void setImage_room_no(int image_room_no) {
		this.image_room_no = image_room_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	
	@Override
	public String toString() {
		return "JoinListVO [image_room_no=" + image_room_no + ", emp_no=" + emp_no + "]";
	}
}
