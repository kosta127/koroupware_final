package com.koroupware.imageroom.domain;

import java.util.Date;

public class ImageRoomVO {
	private int image_room_no;
	private String image_room_name;
	private Date image_room_regdate;
	private Date image_room_deldate;
	private int emp_no;
	
	public ImageRoomVO(){}
	public ImageRoomVO(int image_room_no, String image_room_name, Date image_room_regdate, Date image_room_deldate,
			int emp_no) {
		this.image_room_no = image_room_no;
		this.image_room_name = image_room_name;
		this.image_room_regdate = image_room_regdate;
		this.image_room_deldate = image_room_deldate;
		this.emp_no = emp_no;
	}
	
	public int getImage_room_no() {
		return image_room_no;
	}
	public void setImage_room_no(int image_room_no) {
		this.image_room_no = image_room_no;
	}
	public String getImage_room_name() {
		return image_room_name;
	}
	public void setImage_room_name(String image_room_name) {
		this.image_room_name = image_room_name;
	}
	public Date getImage_room_regdate() {
		return image_room_regdate;
	}
	public void setImage_room_regdate(Date image_room_regdate) {
		this.image_room_regdate = image_room_regdate;
	}
	public Date getImage_room_deldate() {
		return image_room_deldate;
	}
	public void setImage_room_deldate(Date image_room_deldate) {
		this.image_room_deldate = image_room_deldate;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	
	@Override
	public String toString() {
		return "ImageRoomVO [image_room_no=" + image_room_no + ", image_room_name=" + image_room_name
				+ ", image_room_regdate=" + image_room_regdate + ", image_room_deldate=" + image_room_deldate
				+ ", emp_no=" + emp_no + "]";
	}
}
