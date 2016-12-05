package com.koroupware.news.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.member.dto.EmpDTO;
import com.koroupware.news.domain.NewsCompanyVO;
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
	
	@RequestMapping(value="/newsCompanyList")
	public @ResponseBody List<NewsCompanyVO> newsCompanyList() throws Exception{
		return service.newsCompanyList();
	}
	
	@RequestMapping(value="/newsList")
	public @ResponseBody List<NewsDTO> newsList(
			NewsCompanyVO newsCompany) throws Exception{
		RSSReader rssr = new RSSReader();
		return rssr.read(newsCompany.getNews_company_rssurl());
	}
	
	@RequestMapping(value="/myNewsList")
	public @ResponseBody List<NewsDTO> myNewsList(HttpSession session) throws Exception{
		EmpDTO dto = (EmpDTO) session.getAttribute("login");
		int empno = dto.getEmp_no();	
		return service.myNewsList(empno);
	}
	
	@RequestMapping(value="/newsRead", produces="application/html; charset=utf8")
	public @ResponseBody String newsRead(
			@RequestParam("newsUrl") String newsUrl, @RequestParam("charset") String charset){
		return NewsReader.newsReader(newsUrl, charset);
	}
	
	@RequestMapping(value="/newsRegist",method=RequestMethod.POST)
	public @ResponseBody String newsRegist(NewsDTO news, HttpSession session) throws Exception{ //뉴스클리핑
		NewsVO vo = new NewsVO(news);
		EmpDTO dto = (EmpDTO) session.getAttribute("login");
		vo.setEmp_no(dto.getEmp_no());
		service.newsRegist(vo);
		return "reg_ok";
	}
	
	@RequestMapping(value="/newsDelete",method=RequestMethod.POST)
	public @ResponseBody String newsDelete(@RequestParam("link") String link,
			HttpSession session) throws Exception{
		NewsVO news = new NewsVO();
		news.setNews_clipping_link(link);
		EmpDTO dto = (EmpDTO) session.getAttribute("login");
		news.setEmp_no(dto.getEmp_no());
		service.newsDelete(news);
		return "del_ok";
	}
	
	@RequestMapping(value="/newsCheck",method=RequestMethod.POST)
	public @ResponseBody String newsCheck(@RequestParam("link") String link,
			HttpSession session) throws Exception{
		NewsVO news = new NewsVO();
		news.setNews_clipping_link(link);
		EmpDTO dto = (EmpDTO) session.getAttribute("login");
		news.setEmp_no(dto.getEmp_no());
		return service.newsCountAsLink(news); // result : exist / none
	}
}
