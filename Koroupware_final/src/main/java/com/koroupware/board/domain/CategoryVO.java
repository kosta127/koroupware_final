package com.koroupware.board.domain;

import java.sql.Timestamp;

public class CategoryVO {
	private int category_no;
	private int community_no;
	private String category_name;
	private Timestamp category_regdate;
	private Timestamp category_deldate;
	
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getCommunity_no() {
		return community_no;
	}
	public void setCommunity_no(int community_no) {
		this.community_no = community_no;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Timestamp getCategory_regdate() {
		return category_regdate;
	}
	public void setCategory_regdate(Timestamp category_regdate) {
		this.category_regdate = category_regdate;
	}
	public Timestamp getCategory_deldate() {
		return category_deldate;
	}
	public void setCategory_deldate(Timestamp category_deldate) {
		this.category_deldate = category_deldate;
	}
}
