package com.koroupware.board.domain;

import java.sql.Timestamp;

public class ReplyVO {
	private int reply_no;
	private String reply_contents;
	private Timestamp reply_regdate;
	private Timestamp reply_deldate;
	private int emp_no;
	private int board_no;
	
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_contents() {
		return reply_contents;
	}
	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}
	public Timestamp getReply_regdate() {
		return reply_regdate;
	}
	public void setReply_regdate(Timestamp reply_regdate) {
		this.reply_regdate = reply_regdate;
	}
	public Timestamp getReply_deldate() {
		return reply_deldate;
	}
	public void setReply_deldate(Timestamp reply_deldate) {
		this.reply_deldate = reply_deldate;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	
	public ReplyVO(){}
	public ReplyVO(int reply_no, String reply_contents, Timestamp reply_regdate, Timestamp reply_deldate, int emp_no,
			int board_no) {
		this.reply_no = reply_no;
		this.reply_contents = reply_contents;
		this.reply_regdate = reply_regdate;
		this.reply_deldate = reply_deldate;
		this.emp_no = emp_no;
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", reply_contents=" + reply_contents + ", reply_regdate="
				+ reply_regdate + ", reply_deldate=" + reply_deldate + ", emp_no=" + emp_no + ", board_no=" + board_no
				+ "]";
	}
	
	
}
