package com.koroupware.news.service;


import java.util.List;

import com.koroupware.news.domain.NewsVO;
import com.koroupware.news.dto.NewsDTO;

public interface TodayNewsService {
	public void newsRegist(NewsVO news) throws Exception; //뉴스스크랩
	public String newsCountAsLink(NewsVO news) throws Exception; //뉴스스크랩여부확인
	public void newsDelete(NewsVO news) throws Exception; //스크랩취소
	public List<NewsVO> myNewsList(int empno) throws Exception; //스크랩한뉴스목록
}
