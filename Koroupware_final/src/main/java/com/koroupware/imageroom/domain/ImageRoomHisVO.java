package com.koroupware.imageroom.domain;

import java.util.Date;

public class ImageRoomHisVO {
	private int image_room_his_no;
	private String image_room_his_contents;
	private Date image_room_his_regdate;
	private Date image_room_his_deldate;
	private int image_room_no;
	private int emp_no;
	
	public ImageRoomHisVO(){}
	public ImageRoomHisVO(int image_room_his_no, String image_room_his_contents, Date image_room_his_regdate,
			Date image_room_his_deldate, int image_room_no, int emp_no) {
		this.image_room_his_no = image_room_his_no;
		this.image_room_his_contents = image_room_his_contents;
		this.image_room_his_regdate = image_room_his_regdate;
		this.image_room_his_deldate = image_room_his_deldate;
		this.image_room_no = image_room_no;
		this.emp_no = emp_no;
	}
	
	public int getImage_room_his_no() {
		return image_room_his_no;
	}
	public void setImage_room_his_no(int image_room_his_no) {
		this.image_room_his_no = image_room_his_no;
	}
	public String getImage_room_his_contents() {
		return image_room_his_contents;
	}
	public void setImage_room_his_contents(String image_room_his_contents) {
		this.image_room_his_contents = image_room_his_contents;
	}
	public Date getImage_room_his_regdate() {
		return image_room_his_regdate;
	}
	public void setImage_room_his_regdate(Date image_room_his_regdate) {
		this.image_room_his_regdate = image_room_his_regdate;
	}
	public Date getImage_room_his_deldate() {
		return image_room_his_deldate;
	}
	public void setImage_room_his_deldate(Date image_room_his_deldate) {
		this.image_room_his_deldate = image_room_his_deldate;
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
		return "ImageRoomHisVO [image_room_his_no=" + image_room_his_no + ", image_room_his_contents="
				+ image_room_his_contents + ", image_room_his_regdate=" + image_room_his_regdate
				+ ", image_room_his_deldate=" + image_room_his_deldate + ", image_room_no=" + image_room_no
				+ ", emp_no=" + emp_no + "]";
	}
}
