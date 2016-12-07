package com.koroupware.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.board.domain.CategoryVO;
import com.koroupware.board.domain.CommunityVO;
import com.koroupware.board.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Inject
	private CategoryService service;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void registCategory(@RequestParam("community_no") int community_no, Model model){
		model.addAttribute("community_no", community_no);
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String categoryPOST(@RequestParam("community_no") int community_no,
			   					@RequestParam("category_name") String category_name,
			   					RedirectAttributes rttr)throws Exception{
		CategoryVO category = new CategoryVO();
		
		category.setCommunity_no(community_no);
		category.setCategory_name(category_name);
		
		service.categoryRegist(category);
		
		rttr.addAttribute("community_no", community_no);
		/*rttr.addFlashAttribute("community_no", community_no);*/
		return "redirect:/category/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void categoryList(@RequestParam("community_no") int community_no, Model model)throws Exception{
	
		CategoryVO category = new CategoryVO();
		category.setCommunity_no(community_no);
		
		model.addAttribute("list", service.categoryList(community_no));
		model.addAttribute("community_no", community_no);
	}

}
