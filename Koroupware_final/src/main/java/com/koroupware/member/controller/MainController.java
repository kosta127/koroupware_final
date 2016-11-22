package com.koroupware.member.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.member.dto.EmpDTO;
import com.koroupware.member.service.MemberService;


@Controller
public class MainController {

	@Inject
	private MemberService service;
	
	/* 처음 시작시 "/" 로 uri 접근 --> login.jsp로 접근 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(/*Locale locale, Model model*/) {
		System.out.println("처음");
		return "login";
	}
	
	@RequestMapping(value="/logInter", method = RequestMethod.GET)
	public String logInter(EmpVO vo, Model model, HttpSession session)throws Exception{
		System.out.println("asdfasdfasdf");
		return "/loginPost";
	}
	
	//로그인 jsp에서  정보 입력시 ---> loginPost로 옴  :: 데이터와 일치시 메인으로 이동
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String loginPost(EmpVO vo, Model model, HttpSession session)throws Exception{
		EmpDTO dto = service.login(vo);
		if(dto == null){
			System.out.println("로그인 실패");
			return "login";
		}
		model.addAttribute("loginDTO", dto);
		System.out.println("로그인 성공");
		
		return "home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		
		Object obj = session.getAttribute("login");//로그인한 세션 가지고 오기 (인터셉터를 통해...)
		
		if(obj != null){
			System.out.println("세션에 넣은 obj에  login이 있을 경우.. 제거...");
			EmpDTO dto = (EmpDTO) obj;
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null){
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
			}
		}
		System.out.println("?????????????????");
		return "login";
	}
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String loginGET()throws Exception{
		return "home";
	}
	
	@RequestMapping(value = "/idPassSearch", method = RequestMethod.GET)
	public String idPassSearch() {
		return "idPassSearch";
	}
	
	
	
	
	
}