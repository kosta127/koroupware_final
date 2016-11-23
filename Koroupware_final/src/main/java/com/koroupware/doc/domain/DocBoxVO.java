package com.koroupware.doc.domain;

import java.io.Serializable;
import java.util.Date;

public class DocBoxVO implements Serializable{
	private int doc_box_no;
	private int emp_no;
	private String doc_box_name;
	private Date doc_box_regdate;

	
	public Date getDoc_box_regdate() {
		return doc_box_regdate;
	}
	public void setDoc_box_regdate(Date doc_box_regdate) {
		this.doc_box_regdate = doc_box_regdate;
	}
	public int getDoc_box_no() {
		return doc_box_no;
	}
	public void setDoc_box_no(int doc_box_no) {
		this.doc_box_no = doc_box_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getDoc_box_name() {
		return doc_box_name;
	}
	public void setDoc_box_name(String doc_box_name) {
		this.doc_box_name = doc_box_name;
	}
	
	
	
}
