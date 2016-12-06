package com.koroupware.board.persistence;

import java.util.List;

import com.koroupware.board.domain.CategoryVO;

public interface CategoryDAO {
	public int categoryInsert(CategoryVO category)throws Exception;
	public List<CategoryVO> categoryList(int community_no)throws Exception;
	public int getCategoryNo()throws Exception;
}
