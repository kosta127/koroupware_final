package com.koroupware.board.service;

import java.util.List;

import com.koroupware.board.domain.CategoryVO;


public interface CategoryService {
	public void categoryRegist(CategoryVO category)throws Exception;
	public List<CategoryVO> categoryList(int community_no)throws Exception;

}
