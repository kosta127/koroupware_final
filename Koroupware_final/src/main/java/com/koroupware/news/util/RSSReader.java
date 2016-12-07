package com.koroupware.news.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import com.koroupware.news.dto.NewsDTO;

public class RSSReader {
	private Map<String, String> rssInfo; 
	private String url; //읽을 xml파일 있는 곳
	private List<NewsDTO> newses; //뉴스들
	
	/* info 정보
	 * title; //채널 제목
	 * link; //채널 링크
	 * description; //채널 설명
	 * language; //채널이 작성되는 언어
	 * copyright; //채널의 저작권 통지
	 * managingEditor; //채널 편집 담당자 우편
	 * webMaster; //채널 웹마스터 전자우편
	 * //채널 컨텐츠 발행 시간
	 * //채널이 마지막으로 변경된 시간
	 * pubDate; 
	 * lastBuildDate; 
	 * category; //채널이 속해있는 카테고리
	 * generator; //채널을 생성하는데 사용된 프로그램
	 * 
	 * */
	
	public RSSReader(){}
	
	public RSSReader(String url){
		this.url = url;
	}
	
	public List<NewsDTO> read(String url){
		this.url = url;
		return read();
	}
	
	public List<NewsDTO> read(){
		if(newses==null) newses = new ArrayList<NewsDTO>();
		if(rssInfo==null) rssInfo = new HashMap<String, String>();
		
		URL url = null;
		try{
			url = new URL(this.url);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xsr = null;
		try {
			xsr = xif.createXMLStreamReader(url.openStream());
			NewsDTO news = null;
			String name = null;
			while(xsr.hasNext()){
				switch (xsr.getEventType()) {
				case XMLStreamReader.START_ELEMENT:
					name = xsr.getName().toString();
					if(name.equals("item")){
						news = new NewsDTO();
					}
					break;
				case XMLStreamReader.END_ELEMENT:
					name = xsr.getName().toString();
					if(name.equals("item")){
						newses.add(news);						
						news = null;
					}
					break;
				//case XMLStreamReader.SPACE:
				case XMLStreamReader.CHARACTERS:
					String text = xsr.getText();
					if(text.trim().equals("")) break;
					if(news != null){
						switch (name) {
						case "title": news.setTitle(text);				
							break;
						case "link": news.setLink(text);						
							break;
						case "description": news.setDescription(text);			
							break;
						case "author": news.setAuthor(text);
							break;
						case "category": news.setCategory(text);		
							break;
						case "comments": news.setComments(text);	
							break;
						case "guid": news.setGuid(text);
							break;
						case "pubDate": 
							news.setPubDate(text);
							break;
						}
						//System.out.println("/t "+name +" text -> "+ text);
					}else{
						rssInfo.put(name, text);
					}
					break;
				case XMLStreamReader.PROCESSING_INSTRUCTION: // <? ?>
					break;
				case XMLStreamReader.CDATA:
					break;
				case XMLStreamReader.COMMENT: // <!-- --> 
					break;
				case XMLStreamReader.ENTITY_REFERENCE:
					break;
				case XMLStreamReader.START_DOCUMENT: // <?xml ?>
					break;
				}
				xsr.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newses;
	}
}
