package com.koroupware.news.dto;


public class NewsDTO {
	private int newsno;
	private int empno;
	private int company; //뉴스사
	private String title; //제목
	private String link; //항목의 URL
	private String description; //항목의 내용 
	private String author; //저작자의 전자우편
	private String category; //항목이 속해있는 카테고리
 	private String comments; //항목과 관련된 설명 페이지 URL
	private String guid; //고유하게 항목을 식별할 수 있는 문자열
	private String pubDate; //항목발행시간
	private String regDate; //등록일
	
	
	
	public int getNewsno() {
		return newsno;
	}
	public void setNewsno(int newsno) {
		this.newsno = newsno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "NewsVO [title=" + title + ", link=" + link + ", description=" + description + ", author=" + author
				+ ", category=" + category + ", comments=" + comments + ", guid=" + guid + ", pubDate=" + pubDate + "]";
	}
	
	
}
