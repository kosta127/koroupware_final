package com.koroupware.elecauth.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koroupware.elecauth.domain.ElecauthReadVO;
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
	
	
	@RequestMapping(value="/elecauthRead")
	public String read(Model model, @RequestParam("elec_auth_no") int elec_auth_no) throws Exception{
		ElecauthReadVO elecauthRead=service.elecauthRead(elec_auth_no);
		model.addAttribute("elecauthRead", elecauthRead);
		
		return "/elecauth/elecauthRead";
	}
}
