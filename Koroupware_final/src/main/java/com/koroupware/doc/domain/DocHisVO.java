package com.koroupware.doc.domain;

import java.io.Serializable;
import java.util.Date;

public class DocHisVO implements Serializable{
	private int doc_his_no;
	private int emp_no;
	private int doc_no;
	private String doc_his_reason_change;
	private String doc_his_revise;
	private Date doc_his_moddate;
	
	public Date getDoc_his_moddate() {
		return doc_his_moddate;
	}
	public void setDoc_his_moddate(Date doc_his_moddate) {
		this.doc_his_moddate = doc_his_moddate;
	}
	public int getDoc_his_no() {
		return doc_his_no;
	}
	public void setDoc_his_no(int doc_his_no) {
		this.doc_his_no = doc_his_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public String getDoc_his_reason_change() {
		return doc_his_reason_change;
	}
	public void setDoc_his_reason_change(String doc_his_reason_change) {
		this.doc_his_reason_change = doc_his_reason_change;
	}
	public String getDoc_his_revise() {
		return doc_his_revise;
	}
	public void setDoc_his_revise(String doc_his_revise) {
		this.doc_his_revise = doc_his_revise;
	}
	@Override
	public String toString() {
		return "DocHis [doc_his_no=" + doc_his_no + ", emp_no=" + emp_no + ", doc_no=" + doc_no
				+ ", doc_his_reason_change=" + doc_his_reason_change + ", doc_his_revise=" + doc_his_revise
				+ ", doc_his_moddate=" + doc_his_moddate + "]";
	}
	
}
