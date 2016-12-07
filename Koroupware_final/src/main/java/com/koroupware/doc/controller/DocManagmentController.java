package com.koroupware.doc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.service.DocManagementService;

@Controller
@RequestMapping("/doc/*")
public class DocManagmentController {
	@Inject
	private DocManagementService service;
	
	@RequestMapping(value="/doc_managementRemove/{doc_box_no}/{doc_no}/{emp_no}",method=RequestMethod.GET)
	public String doc_managementDelete(@PathVariable("doc_box_no") int doc_box_no,@PathVariable("emp_no") int emp_no,
				DocManagementVO vo,RedirectAttributes rttr) throws Exception{
		service.docRemove(vo);
		rttr.addAttribute("emp_no",emp_no);
		return "redirect:/doc/doc_boxRead/"+doc_box_no+"/"+emp_no;
	}
	
	@RequestMapping(value="/doc_managementRegist/{doc_box_no}/{emp_no}",method=RequestMethod.POST)
	public String doc_managementRegist(@PathVariable("doc_box_no") int doc_box_no,
			@PathVariable("emp_no") int emp_no,@RequestParam("doc_no") int[] doc_no,
			DocManagementVO vo,RedirectAttributes rttr) throws Exception{
		rttr.addAttribute("doc_box_no",doc_box_no);
		rttr.addAttribute("emp_no",emp_no);
		vo.setDoc_box_no(doc_box_no);
		
		for(int i=0;i<doc_no.length;i++){
			vo.setDoc_no(doc_no[i]);
			service.doc_managementRegist(vo);
		}
		return "redirect:/doc/doc_boxRead/"+doc_box_no+"/"+emp_no;
	}
}
