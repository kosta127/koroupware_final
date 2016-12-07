package com.koroupware.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.board.domain.CategoryVO;
import com.koroupware.board.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDAO dao;
	
	@Override
	public void categoryRegist(CategoryVO category) throws Exception {
		dao.categoryInsert(category);
	}

	@Override
	public List<CategoryVO> categoryList(int community_no) throws Exception {
		return dao.categoryList(community_no);
	}

}
