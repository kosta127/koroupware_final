package com.koroupware.board.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

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

import com.koroupware.board.domain.BoardVO;
import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.PageMaker;
import com.koroupware.board.domain.RecommendVO;
import com.koroupware.board.domain.SearchCriteria;
import com.koroupware.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void insertGET(BoardVO board, Model model)throws Exception{
		
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String insertPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		service.boardRegist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void  list(@ModelAttribute("cri") SearchCriteria cri,  Model model)throws Exception{
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void detail(@RequestParam("board_no") int board_no, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("boardVO",service.boardRead(board_no));
	}
	
	@RequestMapping(value="/read/{board_no}", method=RequestMethod.POST)
	public String detailPOST(@RequestParam("board_no") int board_no, @RequestParam("distinction") String distinction, Model model)throws Exception{
		service.recModifyCnt(board_no);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam("board_no") int board_no, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		service.boardRemove(board_no);
		
		 rttr.addAttribute("page", cri.getPage());
		 rttr.addAttribute("pageNum", cri.getPerPageNum());
		 rttr.addAttribute("searchType", cri.getSearchType());
		 rttr.addAttribute("keyword", cri.getKeyword());
		 
		 rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(int board_no, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute(service.boardRead(board_no));
		
		return "/board/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		service.boardModify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		 
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
