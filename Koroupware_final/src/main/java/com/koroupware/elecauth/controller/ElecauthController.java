package com.koroupware.elecauth.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;
import com.koroupware.elecauth.dto.ElecauthDTO;
import com.koroupware.elecauth.domain.ElecauthReadApprovalVO;
import com.koroupware.elecauth.domain.ElecauthReadReferrerVO;
import com.koroupware.elecauth.service.ElecauthService;

@Controller
@RequestMapping("/elecauth")
public class ElecauthController {
	
	@Inject
	private ElecauthService service;
	
	@RequestMapping(value="/elecauthList", method=RequestMethod.GET)
	public String elecauthList(Model model)throws Exception{
		List<ElecauthListVO> elecauthList=service.elecauthList();
		model.addAttribute("elecauthList", elecauthList);
		
		return "/elecauth/elecauthList";
	}
	
	
	@RequestMapping(value="/elecauthRead", method=RequestMethod.GET)
	public String elecauthRead(Model model, @RequestParam("elec_auth_no") int elec_auth_no) throws Exception{
		
		ElecauthReadVO elecauthRead=service.elecauthRead(elec_auth_no);
				
		List<ElecauthReadApprovalVO> elecauthReadApproval
		=service.elecauthReadApproval(elec_auth_no);
		
		List<ElecauthReadReferrerVO> elecauthReadReferrer
		=service.elecauthReadReferrer(elec_auth_no);
		
		model.addAttribute("elecauthRead", elecauthRead);
		model.addAttribute("elecauthReadApproval", elecauthReadApproval);
		model.addAttribute("elecauthReadReferrer", elecauthReadReferrer);
		
		return "/elecauth/elecauthRead";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registGET(Model model) throws Exception{
		//added by jirung
		
		//양식으로 쓸 문서 목록
		model.addAttribute("docFormList", service.docListSelect());
		//@@ TEMP @@ 원래는 세션같은곳에서 가져와야 한는 정보 : 사원정보
		model.addAttribute("empDetail", service.empDetailRead(4));
		
		return "/elecauth/elecauthRegist";
	}
	
	@RequestMapping(value="/regist/{flag}", method=RequestMethod.POST)
	public String registPOST(Model model, HttpServletRequest request, 
			ElecauthDTO dto, @PathVariable int flag) 
			throws Exception{
		//added by jirung
		//flag는 0, 1로 구분
		// 0 = 기본, 1 = 임시저장
		ElecauthVO ea = new ElecauthVO(dto);
		if(flag == 1){
			ea.setElec_auth_temporary_saveYN("Y"); //임시저장
		}
		service.elecauthRegist(ea, dto.getApprovalList(), dto.getElecauthReferrer());
		
		return "redirect:/elecauth/elecauthList";
	}
	
	@RequestMapping("/empListAsJson")
	public @ResponseBody List<EmpDetailVO> empDetailListAsJson() throws Exception{
		return service.empListSelect();
	}
	
	//삭제처리하기 by moonyong
	@RequestMapping(value="/elecauthDelete/{elec_auth_no}")
	public String elecauthDelete(@PathVariable("elec_auth_no") int elec_auth_no)throws Exception{
		service.elecauthDelete(elec_auth_no);
		
		return "redirect:/elecauth/elecauthList";
	}
	
	//승인처리하기 by moonyong
	@RequestMapping(value="/elecauthOkReport")
	public String elecauthOkReport(@PathVariable("elec_auth_no") int elec_auth_no)throws Exception{

		
		return "redirect:/elecauth/elecauthList";
	}
	
	//거부처리하기 by moonyong
	public String elecauthNoReport(@PathVariable("elec_auth_no") int elec_auth_no)throws Exception{
		
		return "redirect:/elecauth/elecauthList";
	}
	
	
}
