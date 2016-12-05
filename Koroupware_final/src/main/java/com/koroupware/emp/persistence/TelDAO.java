package com.koroupware.emp.persistence;

import java.util.List;

import com.koroupware.emp.domain.TelVO;

public interface TelDAO {
  public void create(TelVO telVo) throws Exception;
  public List<TelVO> telList(int emp_no) throws Exception;
  public void addTel(TelVO telVo) throws Exception;
  public void updateTel(TelVO telVo) throws Exception;
  public void deleteTel(int tel_no) throws Exception;
}
