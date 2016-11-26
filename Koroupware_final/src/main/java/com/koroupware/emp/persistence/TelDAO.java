package com.koroupware.emp.persistence;

import java.util.List;

import com.koroupware.emp.domain.TelDTO;
import com.koroupware.emp.domain.TelVO;

public interface TelDAO {
  public void create(TelVO telVo) throws Exception;
  public List<TelDTO> telList(Integer emp_no) throws Exception;
  public void addTel(TelDTO telDTO) throws Exception;
  public void deleteTel(Integer tel_no) throws Exception;
}
