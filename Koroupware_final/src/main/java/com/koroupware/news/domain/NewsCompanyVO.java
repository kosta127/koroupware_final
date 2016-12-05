package com.koroupware.news.domain;

public class NewsCompanyVO {
	private int news_company_no; //뉴스사 번호
	private String news_company_name; //뉴스사 이름
	private String news_company_rssurl; //뉴스사 rss url
	private String news_company_charset; //뉴스사 홈 인코딩
	private String news_company_filter_pattern; //뉴스사 홈 패턴
	
	public int getNews_company_no() {
		return news_company_no;
	}
	public void setNews_company_no(int news_company_no) {
		this.news_company_no = news_company_no;
	}
	public String getNews_company_name() {
		return news_company_name;
	}
	public void setNews_company_name(String news_company_name) {
		this.news_company_name = news_company_name;
	}
	public String getNews_company_rssurl() {
		return news_company_rssurl;
	}
	public void setNews_company_rssurl(String news_company_rssurl) {
		this.news_company_rssurl = news_company_rssurl;
	}
	public String getNews_company_charset() {
		return news_company_charset;
	}
	public void setNews_company_charset(String news_company_charset) {
		this.news_company_charset = news_company_charset;
	}
	public String getNews_company_filter_pattern() {
		return news_company_filter_pattern;
	}
	public void setNews_company_filter_pattern(String news_company_filter_pattern) {
		this.news_company_filter_pattern = news_company_filter_pattern;
	}
	
}
