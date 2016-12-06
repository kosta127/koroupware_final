package com.koroupware.doc.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;



public class DocVO implements Serializable{
	private int doc_no;
	private String doc_title;
	private String doc_explain;
	private String doc_contents;
	private Date doc_con_period;
	private int emp_no;
	private String doc_formYN;
	private Date doc_deldate;
	private String[] files;
	
	
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public Date getDoc_deldate() {
		return doc_deldate;
	}
	public void setDoc_deldate(Date doc_deldate) {
		this.doc_deldate = doc_deldate;
	}
	public String getDoc_formYN() {
		return doc_formYN;
	}
	public void setDoc_formYN(String doc_formYN) {
		this.doc_formYN = doc_formYN;
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
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getDoc_explain() {
		return doc_explain;
	}
	public void setDoc_explain(String doc_explain) {
		this.doc_explain = doc_explain;
	}
	public String getDoc_contents() {
		return doc_contents;
	}
	public void setDoc_contents(String doc_contents) {
		this.doc_contents = doc_contents;
	}
	public Date getDoc_con_period() {
		return doc_con_period;
	}
	public void setDoc_con_period(Date date) {
		this.doc_con_period = date;
	}
	@Override
	public String toString() {
		return "DocVO [doc_no=" + doc_no + ", doc_title=" + doc_title + ", doc_explain=" + doc_explain
				+ ", doc_contents=" + doc_contents + ", doc_con_period=" + doc_con_period + ", emp_no=" + emp_no
				+ ", doc_formYN=" + doc_formYN + ", doc_deldate=" + doc_deldate + ", files=" + Arrays.toString(files)
				+ "]";
	}
	
}
