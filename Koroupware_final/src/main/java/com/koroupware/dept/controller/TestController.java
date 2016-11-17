package com.koroupware.dept.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koroupware.dept.service.TestService;

@Controller
public class TestController {
	
	@Inject
	private TestService service;
	
	@RequestMapping("/test")
	public String testPage(Model model){
		model.addAttribute("test", service.testRead());
		return "home";
	}
}
