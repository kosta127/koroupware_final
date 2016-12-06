package com.koroupware.board.domain;

import java.sql.Timestamp;
import java.util.Arrays;

public class BoardVO {
	
	private int board_no; 
	private String board_title;
	private String board_contents;
	private int board_hit;
	private Timestamp board_regdate;
	private Timestamp board_deldate;
	private int emp_no; 
	private int category_no;
	
	private String[] files;
	
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_title=" + board_title + ", board_contents=" + board_contents
				+ ", board_hit=" + board_hit + ", board_regdate=" + board_regdate + ", board_deldate=" + board_deldate
				+ ", emp_no=" + emp_no + ", category_no=" + category_no + ", files=" + Arrays.toString(files) + "]";
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
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

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

	public int getBoard_hit() {
		return board_hit;
	}

	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}

	public Timestamp getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(Timestamp board_regdate) {
		this.board_regdate = board_regdate;
	}

	public Timestamp getBoard_deldate() {
		return board_deldate;
	}

	public void setBoard_deldate(Timestamp board_deldate) {
		this.board_deldate = board_deldate;
	}

}
