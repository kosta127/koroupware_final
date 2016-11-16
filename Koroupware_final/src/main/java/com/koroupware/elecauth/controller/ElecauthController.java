package com.koroupware.elecauth.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.service.ElecauthService;

@Controller
@RequestMapping("/elecauth")
public class ElecauthController {
	
	@Inject
	private ElecauthService service;
	
	@RequestMapping(value="/elecauthList", method=RequestMethod.GET)
	public String elecauthList(Model model)throws Exception{
		List<ElecauthListVO> elecauthList=service.elecauthList();
		model.addAttribute("elecauthList", elecauthList);
		
		return "/elecauth/elecauthList";
	}
	
}