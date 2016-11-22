package com.koroupware.search.service;

import java.util.List;

import com.koroupware.member.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;
import com.koroupware.search.domain.Criteria;
import com.koroupware.search.domain.SearchVO;

public interface SearchService {
	
	public int listCountCriteria(SearchVO cri)throws Exception;



	public List<EmpDTO> listSearchPerson(SearchVO cri)throws Exception;



	public List<EmpDTO> listSearchDoc(SearchVO cri)throws Exception;
}
