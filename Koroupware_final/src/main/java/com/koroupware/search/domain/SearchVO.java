package com.koroupware.search.domain;

import com.koroupware.board.domain.Criteria;

public class SearchVO extends Criteria{
	private String keyField;
	private String search_content;
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	public String getSearch_content() {
		return search_content;
	}
	public void setSearch_content(String search_content) {
		this.search_content = search_content;
	}
	
	

}
