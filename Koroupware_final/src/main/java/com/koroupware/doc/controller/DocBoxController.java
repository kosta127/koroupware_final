package com.koroupware.doc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocVO;
import com.koroupware.doc.service.DocBoxService;

@Controller
@RequestMapping("/doc/*")
public class DocBoxController {
	@Inject
	private DocBoxService service;
	
	@RequestMapping("/login")
	public void login(){}
	
	
	@RequestMapping(value="/doc_boxList/{emp_no}", method=RequestMethod.GET)
	public String doc_boxList(@PathVariable("emp_no") int emp_no,Model model) throws Exception{
		model.addAttribute("list",service.doc_boxList(emp_no));
		model.addAttribute("emp_no",emp_no);
		return "/doc/doc_boxList";
	}
	
	
	@RequestMapping(value="/doc_boxRegist", method=RequestMethod.GET)
	public void doc_boxRegistGET(@RequestParam("emp_no") int emp_no,Model model){
		model.addAttribute("emp_no",emp_no);
	}
	
	@RequestMapping(value="/doc_boxRegist", method=RequestMethod.POST)
	public String doc_boxRegistPOST(DocBoxVO vo){
		service.doc_boxRegist(vo);
		return "redirect:/doc/doc_boxList/"+vo.getEmp_no();
	}
	
	@RequestMapping(value="/doc_boxRead/{doc_box_no}/{emp_no}", method=RequestMethod.GET)
	public String doc_boxRead(@PathVariable("doc_box_no") int doc_box_no,
				@PathVariable("emp_no") int emp_no,Model model){
		List<DocVO> list = service.doc_boxRead(doc_box_no);
		DocBoxVO vo = service.doc_boxGet(doc_box_no);
		model.addAttribute("doc_box",vo);
		model.addAttribute("list",list);
		return "/doc/doc_boxRead";
	}
	
	@RequestMapping(value="/doc_boxUpdate/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String doc_boxUpdateGET(@PathVariable("doc_box_no") int doc_box_no,@PathVariable("emp_no") int emp_no,
					Model model){
		model.addAttribute("doc_box_no",doc_box_no);
		model.addAttribute("emp_no",emp_no);
		return "/doc/doc_boxUpdate";
	}
	
	@RequestMapping(value="/doc_boxUpdate/{doc_box_no}/{emp_no}",method=RequestMethod.POST)
	public String doc_boxUpdatePOST(DocBoxVO vo,@PathVariable("doc_box_no") int doc_box_no,
				@PathVariable("emp_no") int emp_no){
		service.doc_boxModify(vo);
		return "redirect:/doc/doc_boxRead/"+doc_box_no+"/"+emp_no;
	}
	
	
	@RequestMapping(value="doc_boxRemove/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String doc_boxRemove(@PathVariable("doc_box_no") int doc_box_no,@PathVariable("emp_no") int emp_no){
		service.doc_boxRemove(doc_box_no);
		return "redirect:/doc/doc_boxList/"+emp_no;
	}
	

}
