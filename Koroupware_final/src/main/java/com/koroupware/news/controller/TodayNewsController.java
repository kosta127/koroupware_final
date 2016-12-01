package com.koroupware.news.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.news.domain.NewsVO;
import com.koroupware.news.dto.NewsDTO;
import com.koroupware.news.service.TodayNewsService;
import com.koroupware.news.util.NewsReader;
import com.koroupware.news.util.RSSReader;

@Controller
@RequestMapping("/todaynews")
public class TodayNewsController {
	@Inject
	private TodayNewsService service;
	
	@RequestMapping(value="/")
	public String newView(){
		return "/todaynews/todaynews";
	}
	
	@RequestMapping(value="/newsList")
	public @ResponseBody List<NewsDTO> newsList(
			@RequestParam("rssUrl") String url){
		RSSReader rssr = new RSSReader();
		return rssr.read(url);
	}
	
	@RequestMapping(value="/myNewsList")
	public @ResponseBody List<NewsVO> myNewsList() throws Exception{
		//@@@ 사원정보 세션에서갖구와야함 @@@@
		int empno = 4;
		return service.myNewsList(empno);
	}
	
	@RequestMapping(value="/newsRead", produces="application/html; charset=utf8")
	public @ResponseBody String newsRead(
			@RequestParam("newsUrl") String newsUrl){
		return NewsReader.newsReader(newsUrl);
	}
	
	@RequestMapping(value="/newsRegist",method=RequestMethod.POST)
	public @ResponseBody String newsRegist(NewsDTO news) throws Exception{ //뉴스클리핑
		System.out.println("hello : "+ news);
		
		NewsVO vo = new NewsVO(news);
		System.out.println("hoho : " + vo);
		//@@@ 사원정보 세션에서갖구와야함 @@@@
		vo.setEmp_no(4);
		service.newsRegist(vo);
		return "reg_ok";
	}
	
	@RequestMapping(value="/newsDelete",method=RequestMethod.POST)
	public @ResponseBody String newsDelete(@RequestParam("link") String link) throws Exception{
		NewsVO news = new NewsVO();
		news.setNews_clipping_link(link);
		//@@@ 사원정보 세션에서갖구와야함 @@@@
		news.setEmp_no(4);
		service.newsDelete(news);
		return "del_ok";
	}
	
	@RequestMapping(value="/newsCheck",method=RequestMethod.POST)
	public @ResponseBody String newsCheck(@RequestParam("link") String link) throws Exception{
		NewsVO news = new NewsVO();
		news.setNews_clipping_link(link);
		//@@@ 사원정보 세션에서갖구와야함 @@@@
		news.setEmp_no(4);
		return service.newsCountAsLink(news); // result : exist / none
	}
}
