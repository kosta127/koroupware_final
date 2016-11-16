package com.koroupware.emp.persistence;

import com.koroupware.emp.domain.EmpVO;

public interface EmpDAO {
	public void create(EmpVO empVo)throws Exception;
}
