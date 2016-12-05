package com.koroupware.board.domain;

import java.sql.Timestamp;

public class CommunityVO {

	private int community_no;
	private int emp_no;
	private String community_name;
	private Timestamp community_regdate;
	private Timestamp community_deldate;
	private String community_aprovalYN;
	
	public int getCommunity_no() {
		return community_no;
	}
	public void setCommunity_no(int community_no) {
		this.community_no = community_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getCommunity_name() {
		return community_name;
	}
	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}
	public Timestamp getCommunity_regdate() {
		return community_regdate;
	}
	public void setCommunity_regdate(Timestamp community_regdate) {
		this.community_regdate = community_regdate;
	}
	public Timestamp getCommunity_deldate() {
		return community_deldate;
	}
	public void setCommunity_deldate(Timestamp community_deldate) {
		this.community_deldate = community_deldate;
	}
	public String getCommunity_aprovalYN() {
		return community_aprovalYN;
	}
	public void setCommunity_aprovalYN(String community_aprovalYN) {
		this.community_aprovalYN = community_aprovalYN;
	}
}
