package com.koroupware.emp.persistence;

import java.util.List;

import com.koroupware.emp.domain.EmpVO;

public interface EmpDAO {
	public void create(EmpVO empVo)throws Exception;
	public List<String> EmpAll() throws Exception;
	public void update(EmpVO empVo) throws Exception;
}
