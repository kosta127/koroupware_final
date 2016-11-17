package com.koroupware.elecauth.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.koroupware.elecauth.domain.ApprovalListVO;
import com.koroupware.elecauth.domain.ElecauthReferrerVO;

public class ElecauthDTO {
	private String emp_name;
	private int emp_no;
	private String elec_auth_management_dept_name;
	private int elec_auth_management_dept_no;
	private int doc_no;
	private String elec_auth_enddate;
	private int elec_auth_con_period;
	private String elec_auth_title;
	private String elec_auth_contents;
	private int[] approval_emp_no;
	private int[] referrer_emp_no;
	
	public ElecauthDTO(){}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getElec_auth_management_dept_name() {
		return elec_auth_management_dept_name;
	}

	public void setElec_auth_management_dept_name(String elec_auth_management_dept_name) {
		this.elec_auth_management_dept_name = elec_auth_management_dept_name;
	}

	public int getElec_auth_management_dept_no() {
		return elec_auth_management_dept_no;
	}

	public void setElec_auth_management_dept_no(int elec_auth_management_dept_no) {
		this.elec_auth_management_dept_no = elec_auth_management_dept_no;
	}

	public int getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(int doc_no) {
		this.doc_no = doc_no;
	}

	public String getElec_auth_enddate() {
		return elec_auth_enddate;
	}

	public void setElec_auth_enddate(String elec_auth_enddate) {
		this.elec_auth_enddate = elec_auth_enddate;
	}

	public int getElec_auth_con_period() {
		return elec_auth_con_period;
	}

	public void setElec_auth_con_period(int elec_auth_con_period) {
		this.elec_auth_con_period = elec_auth_con_period;
	}

	public String getElec_auth_title() {
		return elec_auth_title;
	}

	public void setElec_auth_title(String elec_auth_title) {
		this.elec_auth_title = elec_auth_title;
	}

	public String getElec_auth_contents() {
		return elec_auth_contents;
	}

	public void setElec_auth_contents(String elec_auth_contents) {
		this.elec_auth_contents = elec_auth_contents;
	}

	public int[] getApproval_emp_no() {
		return approval_emp_no;
	}

	public void setApproval_emp_no(int[] approval_emp_no) {
		this.approval_emp_no = approval_emp_no;
	}

	public int[] getReferrer_emp_no() {
		return referrer_emp_no;
	}

	public void setReferrer_emp_no(int[] referrer_emp_no) {
		this.referrer_emp_no = referrer_emp_no;
	}
	
	public List<ApprovalListVO> getApprovalList(){
		List<ApprovalListVO> list = new ArrayList<ApprovalListVO>();
		if(approval_emp_no != null){
			int step = 0;
			for(int empno : approval_emp_no){
				ApprovalListVO al = new ApprovalListVO();
				al.setEmp_no(empno);
				al.setApproval_list_step(++step);
				list.add(al);
			}
		}
		return list;
	}
	
	public List<ElecauthReferrerVO> getElecauthReferrer(){
		List<ElecauthReferrerVO> list = new ArrayList<ElecauthReferrerVO>();
		if(referrer_emp_no != null){
			for(int empno : referrer_emp_no){
				ElecauthReferrerVO ref = new ElecauthReferrerVO();
				ref.setEmp_no(empno);
				list.add(ref);
			}
		}
		return list;
	}

	@Override
	public String toString() {
		return "ElecauthDTO [emp_name=" + emp_name + ", emp_no=" + emp_no + ", elec_auth_management_dept_name="
				+ elec_auth_management_dept_name + ", elec_auth_management_dept_no=" + elec_auth_management_dept_no
				+ ", doc_no=" + doc_no + ", elec_auth_enddate=" + elec_auth_enddate + ", elec_auth_con_period="
				+ elec_auth_con_period + ", elec_auth_title=" + elec_auth_title + ", elec_auth_contents="
				+ elec_auth_contents + ", approval_emp_no=" + Arrays.toString(approval_emp_no) + ", referrer_emp_no="
				+ Arrays.toString(referrer_emp_no) + "]";
	}
	
}
