package com.koroupware.imageroom.domain;

import java.sql.Date;

import com.koroupware.emp.domain.EmpVO;

public class EmpImageRoomDTO extends EmpVO{
	private String office_name;
	private String position_name;	
	
	public EmpImageRoomDTO(){}
	public EmpImageRoomDTO(String office_name, String position_name) {
		super();
		this.office_name = office_name;
		this.position_name = position_name;
	}
	public EmpImageRoomDTO(int emp_no, int dept_no, int office_no, int position_no, int emp_superior, int emp_reporter,
			String emp_name, String emp_email, String emp_id, String emp_password, String emp_address,
			String emp_approvalyn, String emp_residentNum_left, String emp_residentNum_right, Date emp_hiredate,
			Date emp_resigndate, String emp_email_sign, String emp_elec_auth_signkey, String emp_img,
			String emp_elec_auth_img, Date emp_login, String emp_residentnumber, int emp_point, String dept_name){
		super(emp_no, dept_no, office_no, position_no, emp_superior, emp_reporter, emp_name, emp_email, emp_id,
				emp_password, emp_address, emp_approvalyn, emp_residentNum_left, emp_residentNum_right, emp_hiredate,
				emp_resigndate, emp_email_sign, emp_elec_auth_signkey, emp_img, emp_elec_auth_img, emp_login,
				emp_residentnumber, emp_point, dept_name);
	}
	public EmpImageRoomDTO(int emp_no, int dept_no, int office_no, int position_no, int emp_superior, int emp_reporter,
			String emp_name, String emp_email, String emp_id, String emp_password, String emp_address,
			String emp_approvalyn, String emp_residentNum_left, String emp_residentNum_right, Date emp_hiredate,
			Date emp_resigndate, String emp_email_sign, String emp_elec_auth_signkey, String emp_img,
			String emp_elec_auth_img, Date emp_login, String emp_residentnumber, int emp_point, String dept_name,
			String office_name, String position_name) {
		super(emp_no, dept_no, office_no, position_no, emp_superior, emp_reporter, emp_name, emp_email, emp_id,
				emp_password, emp_address, emp_approvalyn, emp_residentNum_left, emp_residentNum_right, emp_hiredate,
				emp_resigndate, emp_email_sign, emp_elec_auth_signkey, emp_img, emp_elec_auth_img, emp_login,
				emp_residentnumber, emp_point, dept_name);
		this.office_name = office_name;
		this.position_name = position_name;
	}
	
	@Override
	public String toString() {
		return "EmpImageRoomDTO [office_name=" + office_name + ", position_name=" + position_name + "]";
	}
}
