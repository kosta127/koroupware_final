package com.koroupware.doc.controller;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.doc.domain.DocVO;
import com.koroupware.doc.service.DocService;

@Controller
@RequestMapping("/doc/*")
public class DocController {
	
	@Inject
	private DocService service;
	
	@RequestMapping(value="/docRead/{doc_no}/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String docRead(@PathVariable("emp_no") int emp_no,@PathVariable("doc_no") int doc_no,
			@PathVariable("doc_box_no") int doc_box_no,Model model){
		DocVO vo = service.docRead(doc_no);
		String emp_name = service.emp_nameGet(emp_no);
		model.addAttribute("doc_no",doc_no);
		model.addAttribute("emp_name",emp_name);
		model.addAttribute("doc",vo);
		return "/doc/docRead";
	}
	
	@RequestMapping("/docList/{doc_box_no}/{emp_no}")
	public String listDoc(Model model,@PathVariable("emp_no") int emp_no,@PathVariable("doc_box_no") int doc_box_no){
		List<DocVO> list = service.docList();
		model.addAttribute("list",list);
		model.addAttribute("emp_no",emp_no);
		model.addAttribute("doc_box_no",doc_box_no);
		return "/doc/docList";
	}
	
	@RequestMapping(value="/docRegist/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String docRegistGET(Model model,@PathVariable("emp_no") int emp_no,@PathVariable("doc_box_no") int doc_box_no){
		
		model.addAttribute("emp_no",emp_no);
		model.addAttribute("doc_box_no",doc_box_no);
		return "/doc/docRegist";
	}
	
	@RequestMapping(value="/docRegist/{doc_box_no}/{emp_no}",method=RequestMethod.POST)
	public String docRegistPOST(DocVO vo,@PathVariable("emp_no") int emp_no,@PathVariable("doc_box_no") int doc_box_no) throws Exception{
		
		service.docRegist(vo);
		return "redirect:/doc/docList/"+emp_no+"/"+doc_box_no;
	}
	
	@RequestMapping("/docRemove/{doc_no}/{doc_box_no}/{emp_no}")
	public String deleteDoc(@PathVariable("emp_no") int emp_no,
			@PathVariable("doc_no") int doc_no,@PathVariable("doc_box_no") int doc_box_no) throws Exception{
		service.docRemove(doc_no);
		return "redirect:/doc/docList/"+doc_box_no+"/"+emp_no;
	}
	
	@RequestMapping(value="/docUpdate/{doc_no}/{doc_box_no}/{emp_no}",method=RequestMethod.GET)
	public String docUpdateGET(@PathVariable("doc_no") int doc_no,@PathVariable("doc_box_no") int doc_box_no,
				@PathVariable("emp_no") int emp_no,Model model){
		model.addAttribute("doc_no",doc_no);
		model.addAttribute("doc_box_no",doc_box_no);
		model.addAttribute("emp_no",emp_no);
		return "/doc/docUpdate";
	}
	
	@RequestMapping(value="/docUpdate/{doc_no}/{doc_box_no}/{emp_no}",method=RequestMethod.POST)
	public String docUpdatePOST(DocVO vo,@PathVariable("emp_no") int emp_no,
			@PathVariable("doc_no") int doc_no,@PathVariable("doc_box_no") int doc_box_no) throws Exception{
		service.docModify(vo);
		return "/doc/doc_hisRegist/"+doc_no+"/"+emp_no+"/"+doc_box_no;
	}
	
	@RequestMapping("/getAttach/{doc_no}")
		@ResponseBody
		public List<String> getAttach(@PathVariable("doc_no") Integer doc_no) throws Exception{
		
		return service.getAttach(doc_no);
	}
	
	
	@SuppressWarnings("resource")
	@ResponseBody
	@RequestMapping(value="/loadFile",produces="application/text; charset=utf8",method=RequestMethod.GET)
	public ResponseEntity<String> loadFile(String fileName) throws Exception{
		
		String url = "C:/upload2"+fileName;
		File file = new File(url);
		BufferedReader in;
		String result = "";
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			if(!formatName.equals("txt")){
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			in = new BufferedReader(new FileReader(file));
			while(true){
				
					String str = in.readLine();
					if(str == null){
						break;
					}
					result += str + "<br/>";
			}
			
			result = URLEncoder.encode(result, "utf-8");
			
			return new ResponseEntity<String>(result,HttpStatus.OK);
}
}
