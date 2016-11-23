package com.koroupware.doc.domain;

import java.io.Serializable;


public class DocManagementVO implements Serializable{
	private int doc_management_no;
	private int doc_no;
	private int doc_box_no;
	
	public int getDoc_management_no() {
		return doc_management_no;
	}
	public void setDoc_management_no(int doc_manage_no) {
		this.doc_management_no = doc_manage_no;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public int getDoc_box_no() {
		return doc_box_no;
	}
	public void setDoc_box_no(int doc_box_no) {
		this.doc_box_no = doc_box_no;
	}
	@Override
	public String toString() {
		return "DocManagementVO [doc_management_no=" + doc_management_no + ", doc_no=" + doc_no + ", doc_box_no="
				+ doc_box_no + "]";
	}
	
	
}
