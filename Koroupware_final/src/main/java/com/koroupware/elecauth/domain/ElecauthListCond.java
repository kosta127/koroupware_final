package com.koroupware.elecauth.domain;

public class ElecauthListCond {
	private int emp_no;
	private boolean isReceive;
	private String condition;
	
	public final static int AUTH_ING = 1; //결재진행
	public final static int AUTH_DONE = 2; //결재완료
	public final static int AUTH_RETURN = 3; //결재반려/부결
	public final static int AUTH_WAIT = 4; //결재대기
	public final static int AUTH_TEMPSAVE = 5; //임시저장
	
	public ElecauthListCond(){}
	public ElecauthListCond(int emp_no, boolean isReceive, String condition) {
		super();
		this.emp_no = emp_no;
		this.isReceive = isReceive;
		this.condition = condition;
	}
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public boolean isReceive() {
		return isReceive;
	}
	public void setReceive(boolean isReceive) {
		this.isReceive = isReceive;
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public static int getAuthIng() {
		return AUTH_ING;
	}
	public static int getAuthDone() {
		return AUTH_DONE;
	}
	public static int getAuthReturn() {
		return AUTH_RETURN;
	}
	public static int getAuthWait() {
		return AUTH_WAIT;
	}
	public static int getAuthTempsave() {
		return AUTH_TEMPSAVE;
	}
	
	
}
