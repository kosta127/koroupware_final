package com.koroupware.news.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.news.domain.NewsCompanyVO;
import com.koroupware.news.domain.NewsVO;
import com.koroupware.news.dto.NewsDTO;

@Repository
public class TodayNewsDAOImpl implements TodayNewsDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.koroupware.mappers.TodayNewsMapper";

	@Override
	public void newsInsert(NewsVO news) throws Exception {
		sqlSession.insert(namespace + ".newsInsert", news);
	}

	@Override
	public int newsCountAsLink(NewsVO news) throws Exception {
		return sqlSession.selectOne(namespace + ".newsCountAsLink", news);
	}

	@Override
	public void newsDelete(NewsVO news) throws Exception {
		sqlSession.update(namespace + ".newsDelete", news);
	}

	@Override
	public List<NewsDTO> myNewsList(int empno) throws Exception {
		return sqlSession.selectList(namespace + ".myNewsList", empno);
	}

	@Override
	public List<NewsCompanyVO> newsCompanylist() throws Exception {
		return sqlSession.selectList(namespace + ".newsCompanyList");
	}

}
