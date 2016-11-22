package com.koroupware.search.persistence;

import java.util.List;

import com.koroupware.member.dto.EmpDTO;
import com.koroupware.search.domain.Criteria;
import com.koroupware.search.domain.SearchVO;

public interface SearchDao {


	public List<EmpDTO> listCriteriaPerson(SearchVO cri)throws Exception;
	public List<EmpDTO> listCriteriaDoc(SearchVO cri);
	public int countPaging(SearchVO cri)throws Exception;



	
	

}
