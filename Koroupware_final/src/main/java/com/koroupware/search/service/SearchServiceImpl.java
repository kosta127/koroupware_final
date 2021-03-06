package com.koroupware.search.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;
import com.koroupware.search.domain.SearchVO;
import com.koroupware.search.persistence.SearchDao;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Inject
	SearchDao dao;
	
	@Override
	public List<EmpDTO> listSearchPerson(SearchVO cri) throws Exception {
		System.out.println(cri);
		
		List<EmpDTO> list = dao.listCriteriaPerson(cri);

		return list;
	}


	@Override
	public int listCountCriteria(SearchVO cri) throws Exception {
		return dao.countPaging(cri);
	}


	@Override
	public List<EmpDTO> listSearchDoc(SearchVO cri) throws Exception {
		
		return dao.listCriteriaDoc(cri);
	}

}
