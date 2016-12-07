package com.koroupware.board.domain;

import java.sql.Timestamp;

public class BoardFileVO {
	private String fullName;
	private int board_no;
	private Timestamp regdate;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardFileVO [fullName=" + fullName + ", board_no=" + board_no + ", regdate=" + regdate + "]";
	}
	
	
}
