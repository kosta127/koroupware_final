package com.koroupware.news.persistence;

import java.util.List;

import com.koroupware.news.domain.NewsCompanyVO;
import com.koroupware.news.domain.NewsVO;
import com.koroupware.news.dto.NewsDTO;

public interface TodayNewsDAO {
	public void newsInsert(NewsVO news) throws Exception;
	public int newsCountAsLink(NewsVO news) throws Exception;
	public void newsDelete(NewsVO news) throws Exception;
	public List<NewsDTO> myNewsList(int empno) throws Exception;
	public List<NewsCompanyVO> newsCompanylist() throws Exception;
}
