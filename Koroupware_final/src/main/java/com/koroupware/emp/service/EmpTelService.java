package com.koroupware.emp.service;

import java.util.List;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.emp.domain.TelDTO;
import com.koroupware.emp.domain.TelVO;

public interface EmpTelService {
  public void signUp(EmpVO empVo, TelVO telVo)throws Exception; 
  public List<String> empIdList() throws Exception;
  public void empDataUpdate(EmpVO empVo) throws Exception; 
  public List<TelDTO> telList(Integer emp_no) throws Exception;
  public void addTel(TelDTO telDTO) throws Exception;
  public void deleteTel(Integer tel_no) throws Exception;
  public EmpVO empList(Integer emp_no) throws Exception;
}
