package com.koroupware.attend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/attend/*")
public class AttendController {
	
	@RequestMapping(value="/attend_today", method = RequestMethod.GET)
	public void attendToday(){
		System.out.println("오늘 출석 체크를 했습니다.");
	}
	
}
