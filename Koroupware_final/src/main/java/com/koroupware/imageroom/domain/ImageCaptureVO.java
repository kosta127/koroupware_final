package com.koroupware.imageroom.domain;

import java.util.Date;

public class ImageCaptureVO {
	private int image_capture_no;
	private String image_capture_contents;
	private String image_capture_explain;
	private Date image_capture_regdate;
	private int image_room_no;
	private int emp_no;
	
	public ImageCaptureVO(){}
	public ImageCaptureVO(int image_capture_no, String image_capture_contents, String image_capture_explain,
			Date image_capture_regdate, int image_room_no, int emp_no) {
		this.image_capture_no = image_capture_no;
		this.image_capture_contents = image_capture_contents;
		this.image_capture_explain = image_capture_explain;
		this.image_capture_regdate = image_capture_regdate;
		this.image_room_no = image_room_no;
		this.emp_no = emp_no;
	}
	
	public int getImage_capture_no() {
		return image_capture_no;
	}
	public void setImage_capture_no(int image_capture_no) {
		this.image_capture_no = image_capture_no;
	}
	public String getImage_capture_contents() {
		return image_capture_contents;
	}
	public void setImage_capture_contents(String image_capture_contents) {
		this.image_capture_contents = image_capture_contents;
	}
	public String getImage_capture_explain() {
		return image_capture_explain;
	}
	public void setImage_capture_explain(String image_capture_explain) {
		this.image_capture_explain = image_capture_explain;
	}
	public Date getImage_capture_regdate() {
		return image_capture_regdate;
	}
	public void setImage_capture_regdate(Date image_capture_regdate) {
		this.image_capture_regdate = image_capture_regdate;
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
		return "ImageCaptureVO [image_capture_no=" + image_capture_no + ", image_capture_contents="
				+ image_capture_contents + ", image_capture_explain=" + image_capture_explain
				+ ", image_capture_regdate=" + image_capture_regdate + ", image_room_no=" + image_room_no + ", emp_no="
				+ emp_no + "]";
	}
}
