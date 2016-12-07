package com.koroupware.board.domain;

public class SearchCriteria extends Criteria{

	private String searchType;
	private String keyword;
	private int category_no;
	
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return super.toString() + " SearchCriteria "
				+ "[searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}
}


