package com.koroupware.board.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.board.domain.BoardDTO;
import com.koroupware.board.domain.BoardVO;
import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.PageMaker;
import com.koroupware.board.domain.RecommendVO;
import com.koroupware.board.domain.SearchCriteria;
import com.koroupware.board.service.BoardService;
import com.koroupware.member.dto.EmpDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void insertGET(HttpSession session, @RequestParam("category_no") int category_no, Model model)throws Exception{
		
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		model.addAttribute("category_no", category_no);
		model.addAttribute("emp_no", emp.getEmp_no());
		model.addAttribute("emp_name", emp.getEmp_name());
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String insertPOST(HttpSession session, @RequestParam("category_no") int category_no, BoardVO board, RedirectAttributes rttr)throws Exception{
		
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		service.boardRegist(board);
		
		board.setCategory_no(category_no);
		board.setEmp_no(emp.getEmp_no());
		
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory_no(category_no);
		
		rttr.addAttribute("category_no", category_no);
		rttr.addAttribute("emp_no", emp.getEmp_no());
		rttr.addAttribute("emp_name", emp.getEmp_name());
	
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void  list(HttpSession session, @RequestParam("category_no") int category_no, @ModelAttribute("cri") SearchCriteria cri,  Model model)throws Exception{
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		
		cri.setCategory_no(category_no);
		
		BoardVO board = new BoardVO();
		board.setCategory_no(category_no);
		
		model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("category_no", category_no);
		model.addAttribute("emp_no", emp.getEmp_no());
		model.addAttribute("emp_name", emp.getEmp_name());
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void detail(HttpSession session, @RequestParam("board_no") int board_no, 
						@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		
		EmpDTO emp = new EmpDTO();
		
		RecommendVO recommend = new RecommendVO();
		recommend.setEmp_no(emp.getEmp_no());
		
		cri.setCategory_no(cri.getCategory_no());
		
		model.addAttribute("boardVO", service.boardRead(board_no));
		
	}
	
	/*@RequestMapping(value="/read/{board_no}", method=RequestMethod.POST)
	public String detailPOST(@RequestParam("board_no") int board_no, Model model)throws Exception{
		service.recModifyCnt(board_no);
	
		
		return "redirect:/board/list";
	}*/
	
	@RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam("board_no") int board_no, 
						@ModelAttribute("cri") SearchCriteria cri, 
						RedirectAttributes rttr)throws Exception{
		System.out.println("remove");
		service.boardRemove(board_no);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("pageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("category_no", cri.getCategory_no());
		 
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(int board_no, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute(service.boardRead(board_no));

		cri.setCategory_no(cri.getCategory_no());
		System.out.println("mod"+cri.getCategory_no());
		
		return "/board/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		service.boardModify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("category_no", cri.getCategory_no()); 
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/getAttach/{board_no}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("board_no")int board_no)throws Exception{
		System.out.println("controller"+board_no);
		return service.getAttach(board_no);
	}
	
}
