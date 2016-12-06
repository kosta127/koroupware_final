package com.koroupware.doc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koroupware.doc.domain.DocHisVO;
import com.koroupware.doc.service.DocHisService;

@Controller
@RequestMapping("/doc/*")
public class DocHisController {
	@Inject
	private DocHisService service;
	
	@RequestMapping(value="/doc_hisList/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String doc_hisList(Model model,@PathVariable("emp_no") int emp_no,@PathVariable("doc_box_no") int doc_box_no){
		System.out.println("dfd");
		List<DocHisVO> list = service.doc_hisList();
		model.addAttribute("list",list);
		return "/doc/doc_hisList";
	}
	
	/*@RequestMapping(value="/doc_hisRegist/{doc_no}/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String doc_hisRegistGET(Model model,@PathVariable("emp_no") int emp_no,
			@PathVariable("doc_box_no") int doc_box_no,@PathVariable("doc_no") int doc_no){
		model.addAttribute("doc_no",doc_no);
		model.addAttribute("doc_box_no",doc_box_no);
		model.addAttribute("emp_no",emp_no);
		return "/doc/doc_hisRegist";
	}*/
	
	@RequestMapping(value="/doc_hisRegist/{doc_no}/{doc_box_no}/{emp_no}",method=RequestMethod.POST)
	public String doc_hisRegistPOST(@PathVariable("emp_no") int emp_no,
			@PathVariable("doc_box_no") int doc_box_no,DocHisVO vo){
		service.doc_hisRegist(vo);
		return "redirect:/doc/doc_hisList/"+doc_box_no+"/"+emp_no;
	}
}
