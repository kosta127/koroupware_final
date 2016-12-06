package com.koroupware.elecauth.domain;

public class ElecauthListCond {
	private int emp_no;
	private boolean isReceive;
	private int condition;
	
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
		setCondition(condition);
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
	
	public int getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
	      switch (condition) {
	      case "ing": //결재진행
	         this.condition = AUTH_ING;
	         break;
	      case "done": //결재완료
	         this.condition = AUTH_DONE;
	         break;
	      case "ret": //반려/부결
	         this.condition = AUTH_RETURN;
	         break;
	      case "wait": //결재대기
	         this.condition = AUTH_WAIT;
	         break;
	      case "temp": //임시저장
	         this.condition = AUTH_TEMPSAVE;
	         break;
	      default:
	         this.condition = 0;
	         break;
	      }
	   }
	   
	   public void setCondition(int condition){
	      this.condition = condition;
	   }
	   
	@Override
	public String toString() {
		return "ElecauthListCond [emp_no=" + emp_no + ", isReceive=" + isReceive + ", condition=" + condition + "]";
	}
}
