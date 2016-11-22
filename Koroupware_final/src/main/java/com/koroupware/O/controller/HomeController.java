package com.koroupware.O.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	//예시 화면
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat() {
		return "chatView/chatMain"; // 뷰폴더 / jsp 파일명 쓰면 그 경로로 갑니다.
	}

	
	
	
}
