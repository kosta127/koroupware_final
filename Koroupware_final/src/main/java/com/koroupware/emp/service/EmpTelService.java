package com.koroupware.emp.service;

import java.util.List;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.emp.domain.TelVO;

public interface EmpTelService {
  public void signUp(EmpVO empVo, TelVO telVo)throws Exception; 
  public List<String> empIdList() throws Exception;
  public void empDataUpdate(EmpVO empVo) throws Exception; 
  public List<TelVO> telList(int emp_no) throws Exception;
  public void addTel(TelVO telVo) throws Exception;
  public void updateTel(TelVO telVo) throws Exception;
  public void deleteTel(int tel_no) throws Exception;
  public EmpVO empList(int emp_no) throws Exception;
}
