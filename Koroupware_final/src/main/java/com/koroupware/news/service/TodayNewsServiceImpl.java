package com.koroupware.news.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.news.domain.NewsCompanyVO;
import com.koroupware.news.domain.NewsVO;
import com.koroupware.news.dto.NewsDTO;
import com.koroupware.news.persistence.TodayNewsDAO;

@Service
public class TodayNewsServiceImpl implements TodayNewsService {
	@Inject
	private TodayNewsDAO dao;

	@Override
	public void newsRegist(NewsVO news) throws Exception {
		dao.newsInsert(news);
	}

	@Override
	public String newsCountAsLink(NewsVO news) throws Exception {
		return (dao.newsCountAsLink(news) > 0)? "exist" : "none";
	}

	@Override
	public void newsDelete(NewsVO news) throws Exception {
		dao.newsDelete(news);
	}

	@Override
	public List<NewsDTO> myNewsList(int empno) throws Exception {
		return dao.myNewsList(empno);
	}

	@Override
	public List<NewsCompanyVO> newsCompanyList() throws Exception {
		return dao.newsCompanylist();
	}

}
