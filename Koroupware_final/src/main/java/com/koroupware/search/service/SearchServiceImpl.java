package com.koroupware.search.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.member.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;
import com.koroupware.search.domain.Criteria;
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
		System.out.println("리스트서치 서비스 :"+ list);
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
