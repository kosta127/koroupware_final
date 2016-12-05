package com.koroupware.search.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.member.dto.EmpDTO;
import com.koroupware.search.domain.S_PageMaker;
import com.koroupware.search.domain.SearchVO;
import com.koroupware.search.service.SearchService;

@Controller
@RequestMapping("/search/*")
public class SearchController {
	@Inject
	SearchService service;
	private String searchContent = null;
	


	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String SearchProcess(SearchVO searchVO, Model model){
		String uri = null;
		if(searchVO.getKeyField().equals("emp_name")){
			searchContent = searchVO.getSearch_content();
			uri = "redirect:/search/searchPerson";
		}else{
			searchContent = searchVO.getSearch_content();
			uri = "redirect:/search/searchDoc";
		}
		return uri;
	}
	
	@RequestMapping(value="/searchPerson", method=RequestMethod.GET)
	public void SearchContent(@ModelAttribute("cri") SearchVO cri, Model model) throws Exception{
		System.out.println(searchContent);
		cri.setSearch_content(searchContent);
		List<EmpDTO> list = service.listSearchPerson(cri);
		
		S_PageMaker pageMaker = new S_PageMaker();
		pageMaker.setCri(cri);
		/*pageMaker.setTotalCount(20);*/
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("searchResult", list);
		
	}
	
	@RequestMapping(value="/searchDoc", method=RequestMethod.GET)
	public void SearchDoc(@ModelAttribute("cri") SearchVO cri, Model model) throws Exception{
		System.out.println(searchContent);
		cri.setSearch_content(searchContent);
		List<EmpDTO> list = service.listSearchDoc(cri);
		
		S_PageMaker pageMaker = new S_PageMaker();
		pageMaker.setCri(cri);
		/*pageMaker.setTotalCount(20);*/
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("searchResult", list);
	}
	
	
	
	
}
