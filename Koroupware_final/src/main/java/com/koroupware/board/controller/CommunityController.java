package com.koroupware.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.board.domain.CommunityVO;
import com.koroupware.board.service.CommunityService;
import com.koroupware.member.dto.EmpDTO;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Inject
	private CommunityService service;

	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void insertGET(HttpSession session, Model model)throws Exception{
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		model.addAttribute("emp_no", emp.getEmp_no());
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String insertPOST(HttpSession session, @RequestParam("community_name") String community_name, 
							RedirectAttributes rttr)throws Exception{
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		CommunityVO community = new CommunityVO();
		
		community.setCommunity_name(community_name);
		community.setEmp_no(emp.getEmp_no());
		
		service.communityRegist(community);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/community/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(HttpSession session, Model model)throws Exception{

		System.out.println("fff");

		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		model.addAttribute("list", service.communityList(emp.getEmp_no()));
	}
	
	
	
	

}
