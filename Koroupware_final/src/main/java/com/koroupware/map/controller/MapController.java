package com.koroupware.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conferenceMap/*")
public class MapController {
	
	@RequestMapping(value="/conferenceMap")
	public void map(){
		System.out.println("실행");
	}
	
	@RequestMapping(value="/map")
	public void map1(){
		System.out.println("실행");
	}
	
}
