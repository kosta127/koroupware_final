package com.koroupware.emp.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.emp.domain.TelVO;
import com.koroupware.emp.service.EmpTelService;

@Controller
public class SignUpController {

	@Inject
	private EmpTelService empTelService;
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpGET() throws Exception { //회원가입 페이지
		return "signUp";
	}
	
	@RequestMapping(value = "/signUp/check", method = RequestMethod.GET)
	@ResponseBody
	public List<String> idCheck() throws Exception { //회원가입 중에 중복아이디 체크 에이작스
		return empTelService.empIdList();
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpPOST(EmpVO empVo, TelVO telVo) throws Exception { //회원가입 확인후
		empTelService.signUp(empVo, telVo);
		return "redirect:/";
	}
}
