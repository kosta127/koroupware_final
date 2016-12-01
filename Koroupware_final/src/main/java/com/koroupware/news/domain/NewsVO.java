package com.koroupware.news.domain;

import java.sql.Date;

import com.koroupware.news.dto.NewsDTO;

public class NewsVO {
	private int news_clipping_no;
	private int emp_no;
	private String news_clipping_title;
	private String news_clipping_contents;
	private String news_clipping_link;
	private String news_clipping_date;
	private String news_clipping_author;
	private String news_clipping_category;
	private Date news_clipping_regdate;
	private Date news_clipping_deldate;
	
	public NewsVO(){ }
	
	public NewsVO(NewsDTO dto){
		this.news_clipping_title = (dto.getTitle()==null)?"":dto.getTitle();
		this.news_clipping_contents = (dto.getDescription()==null)?"":dto.getDescription();
		this.news_clipping_link = (dto.getLink()==null)?"":dto.getLink();
		this.news_clipping_date = (dto.getPubDate()==null)?"":dto.getPubDate();
		this.news_clipping_author = (dto.getAuthor()==null)?"":dto.getAuthor();
		this.news_clipping_category = (dto.getCategory()==null)?"":dto.getCategory();
	}
	
	public int getNews_clipping_no() {
		return news_clipping_no;
	}
	public void setNews_clipping_no(int news_clipping_no) {
		this.news_clipping_no = news_clipping_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getNews_clipping_title() {
		return news_clipping_title;
	}
	public void setNews_clipping_title(String news_clipping_title) {
		this.news_clipping_title = news_clipping_title;
	}
	public String getNews_clipping_contents() {
		return news_clipping_contents;
	}
	public void setNews_clipping_contents(String news_clipping_contents) {
		this.news_clipping_contents = news_clipping_contents;
	}
	public String getNews_clipping_link() {
		return news_clipping_link;
	}
	public void setNews_clipping_link(String news_clipping_link) {
		this.news_clipping_link = news_clipping_link;
	}
	public String getNews_clipping_date() {
		return news_clipping_date;
	}
	public void setNews_clipping_date(String news_clipping_date) {
		this.news_clipping_date = news_clipping_date;
	}
	public String getNews_clipping_author() {
		return news_clipping_author;
	}
	public void setNews_clipping_author(String news_clipping_author) {
		this.news_clipping_author = news_clipping_author;
	}
	public String getNews_clipping_category() {
		return news_clipping_category;
	}
	public void setNews_clipping_category(String news_clipping_category) {
		this.news_clipping_category = news_clipping_category;
	}
	public Date getNews_clipping_regdate() {
		return news_clipping_regdate;
	}
	public void setNews_clipping_regdate(Date news_clipping_regdate) {
		this.news_clipping_regdate = news_clipping_regdate;
	}
	public Date getNews_clipping_deldate() {
		return news_clipping_deldate;
	}
	public void setNews_clipping_deldate(Date news_clipping_deldate) {
		this.news_clipping_deldate = news_clipping_deldate;
	}
	@Override
	public String toString() {
		return "NewsVO [news_clipping_no=" + news_clipping_no + ", emp_no=" + emp_no + ", news_clipping_title="
				+ news_clipping_title + ", news_clipping_contents=" + news_clipping_contents + ", news_clipping_link="
				+ news_clipping_link + ", news_clipping_date=" + news_clipping_date + ", news_clipping_author="
				+ news_clipping_author + ", news_clipping_category=" + news_clipping_category
				+ ", news_clipping_regdate=" + news_clipping_regdate + ", news_clipping_deldate="
				+ news_clipping_deldate + "]";
	}
	
}
