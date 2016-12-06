package com.koroupware.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.board.domain.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.board.mappers.CategoryMapper";
	
	@Override
	public int categoryInsert(CategoryVO category) throws Exception {
		System.out.println("dao");
		return sqlSession.insert(namespace+".categoryInsert", category);
	}

	@Override
	public List<CategoryVO> categoryList(int community_no) throws Exception {
		System.out.println("dao"+community_no);
		return sqlSession.selectList(namespace+".categoryList", community_no);
	}

	@Override
	public int getCategoryNo() throws Exception {
		return sqlSession.selectOne(namespace+".maxNumber");
	}

}
