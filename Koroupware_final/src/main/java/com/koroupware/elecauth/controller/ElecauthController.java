package com.koroupware.elecauth.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.elecauth.domain.ElecauthReadVO;
import com.koroupware.elecauth.domain.ApprovalPrimaryVO;
import com.koroupware.elecauth.domain.ElecauthDeleteVO;
import com.koroupware.elecauth.domain.ElecauthListVO;
import com.koroupware.elecauth.domain.ElecauthVO;
import com.koroupware.elecauth.domain.EmpDetailVO;
import com.koroupware.elecauth.dto.ElecauthDTO;
import com.koroupware.elecauth.domain.ElecauthReadApprovalVO;
import com.koroupware.elecauth.domain.ElecauthReadReferrerVO;
import com.koroupware.elecauth.service.ElecauthService;
import com.koroupware.member.dto.EmpDTO;

@Controller
@RequestMapping("/elecauth")
public class ElecauthController {
	
	@Inject
	private ElecauthService service;
	
	@RequestMapping(value="/elecauthList")
	public String elecauthList(Model model, HttpSession session, HttpServletRequest request,
			 @RequestParam(value="kind", required=false) String kindFlag, 
			 @RequestParam(value="receive", required=false) String receiveFlag)throws Exception{
		
		System.out.println("kind -> "+kindFlag );
		System.out.println("receive -> "+receiveFlag);
		
		//default
		if(kindFlag==null){
			kindFlag = "wait";
		}
		if(receiveFlag==null){
			receiveFlag = "ok";
		}
		
		EmpDTO dto = (EmpDTO) session.getAttribute("login");
		int emp_no = dto.getEmp_no();		
		
		List<ElecauthListVO> elecauthList = 
				service.elecauthList(emp_no, receiveFlag.equals("ok"), kindFlag);

		model.addAttribute("kind", kindFlag);
		model.addAttribute("receive", receiveFlag);
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
	public String registGET(Model model, HttpSession session) throws Exception{
		//added by jirung
		//양식으로 쓸 문서 목록
		model.addAttribute("docFormList", service.docListSelect());
		
		EmpDTO dto = (EmpDTO) session.getAttribute("login");
		int emp_no = dto.getEmp_no();	
		
		model.addAttribute("empDetail", service.empDetailRead(emp_no));
		
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
	@RequestMapping(value="/elecauthDelete")
	public String elecauthDelete(@RequestParam("elec_auth_no") int elec_auth_no,
			@RequestParam("emp_no") int emp_no)throws Exception{
		ElecauthDeleteVO elecauthDelete=new ElecauthDeleteVO(elec_auth_no, emp_no);
		service.elecauthDelete(elecauthDelete);
		
		return "/elecauth/elecauthList";
	}
	
	//승인처리하기 by moonyong
	@RequestMapping(value="/elecauthOkReport")
	public String elecauthOkReport(@RequestParam("elec_auth_no") int elec_auth_no,
			@RequestParam("emp_no") int emp_no)throws Exception{
		ApprovalPrimaryVO elecauthOkReport=new ApprovalPrimaryVO(elec_auth_no, emp_no);
		service.elecauthOkReport(elecauthOkReport);
		
		return "/elecauth/elecauthList";
	}
	
	//거부처리하기 by moonyong
	@RequestMapping(value="/elecauthNoReport")
	public String elecauthNoReport(@RequestParam("elec_auth_no") int elec_auth_no,
			@RequestParam("emp_no") int emp_no)throws Exception{
		ApprovalPrimaryVO elecauthNoReport=new ApprovalPrimaryVO(elec_auth_no, emp_no);
		service.elecauthNoReport(elecauthNoReport);
		
		return "/elecauth/elecauthList";
	}
	
	
}
