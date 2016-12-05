package com.koroupware.doc.domain;

import java.io.Serializable;
import java.util.Date;


public class DocFileVO implements Serializable{
	private String fullName;
	private int doc_no;
	private Date regadte;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}
	public Date getRegadte() {
		return regadte;
	}
	public void setRegadte(Date regadte) {
		this.regadte = regadte;
	}
	
	
	
	
}
