package com.koroupware.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.board.domain.CommunityVO;
import com.koroupware.board.service.CommunityService;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Inject
	private CommunityService service;

	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void insertGET(CommunityVO community, Model model)throws Exception{
		System.out.println("get");
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String insertPOST(CommunityVO community, RedirectAttributes rttr)throws Exception{
		System.out.println("post");
		service.communityRegist(community);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/community/main";
	}
	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public void listCommunity(Model model)throws Exception{
		model.addAttribute("communityList", service.communityList());
	}
}
