package com.koroupware.member.controller;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.member.service.MemberService;


@Controller
public class MemberController {

	@Inject
	private MemberService service;
 
	@Inject
	private JavaMailSender mailSender;
	private String from = "sdc337dc@naver.com";
	private String subject = "tnwla7845!@#";
	//smtp 용 아이디와 비밀번호

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	/* 아이디 & 비밀번호 찾기 컨트롤 */	
	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	public String findUserGET() throws Exception {
		// 아이디/비밀번호 찾기 --> findUser.jsp로 이동
		return "idPassSearch";
	} 

	/* 아이디 & 비밀번호 찾기 --> 아이디찾기 컨트롤*/
	@RequestMapping(value = "/FindId", method = RequestMethod.POST)
	public String findUserIdPOST(EmpVO emp, Model model) throws Exception {
		
		String emp_id = service.findId(emp);
		model.addAttribute("emp_id", emp_id);

		return "member/findIdResult";
	}

	
	/* 아이디 & 비밀번호 찾기 --> 비밀번호 찾기 컨트롤*/
	@RequestMapping(value = "/FindPwd", method = RequestMethod.POST)
	public String findUserPwdPost(EmpVO empVO, Model model) throws Exception {
		int emp_no = service.findNo(empVO);
		model.addAttribute("empVO_no", emp_no);

		return "redirect:/member/email";
	}

	/* 비밀번호 찾기 후 --> smtp메일 전송을 위한 사용자 이메일 찾기 컨트롤 */
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String sendMail(@RequestParam int empVO_no, Model model) {
		EmpVO vo = service.findEmail(empVO_no);
		String email = vo.getEmp_email();
		model.addAttribute("email", email);
		return "redirect:/member/randPwd";
	}
	
	
	/* 찾은 이메일로 smtp+임시비밀번호 전송 컨트롤 */
	@RequestMapping(value="/randPwd",  method = RequestMethod.GET)
	public String randPwd(@RequestParam String email, Model model){
		EmpVO vo = new EmpVO();
		vo.setEmp_email(email);
		
		String randomChar = null;
		String Array[];
		
		// 임시비밀번호 만들기
		Array = new String[8];
		for (int i = 0; i < 8; i++) {
			int randomValue = (int) (Math.random() * 35) + 0;
			for (int j = 0; j < 8; j++) {
				if (randomValue == 0) {
					randomChar = "0";
					Array[i] = randomChar;
				} else if (randomValue == 1) {
					randomChar = "1";
					Array[i] = randomChar;
				} else if (randomValue == 2) {
					randomChar = "2";
					Array[i] = randomChar;
				} else if (randomValue == 3) {
					randomChar = "3";
					Array[i] = randomChar;
				} else if (randomValue == 4) {
					randomChar = "4";
					Array[i] = randomChar;
				} else if (randomValue == 5) {
					randomChar = "5";
					Array[i] = randomChar;
				} else if (randomValue == 6) {
					randomChar = "6";
					Array[i] = randomChar;
				} else if (randomValue == 7) {
					randomChar = "7";
					Array[i] = randomChar;
				} else if (randomValue == 8) {
					randomChar = "8";
					Array[i] = randomChar;
				} else if (randomValue == 9) {
					randomChar = "9";
					Array[i] = randomChar;
				} else if (randomValue == 10) {
					randomChar = "A";
					Array[i] = randomChar;
				} else if (randomValue == 11) {
					randomChar = "B";
					Array[i] = randomChar;
				} else if (randomValue == 12) {
					randomChar = "C";
					Array[i] = randomChar;
				} else if (randomValue == 13) {
					randomChar = "E";
					Array[i] = randomChar;
				} else if (randomValue == 14) {
					randomChar = "F";
					Array[i] = randomChar;
				} else if (randomValue == 15) {
					randomChar = "G";
					Array[i] = randomChar;
				} else if (randomValue == 16) {
					randomChar = "H";
					Array[i] = randomChar;
				} else if (randomValue == 17) {
					randomChar = "I";
					Array[i] = randomChar;
				} else if (randomValue == 18) {
					randomChar = "J";
					Array[i] = randomChar;
				} else if (randomValue == 19) {
					randomChar = "K";
					Array[i] = randomChar;
				} else if (randomValue == 20) {
					randomChar = "L";
					Array[i] = randomChar;
				} else if (randomValue == 21) {
					randomChar = "M";
					Array[i] = randomChar;
				} else if (randomValue == 22) {
					randomChar = "N";
					Array[i] = randomChar;
				} else if (randomValue == 23) {
					randomChar = "O";
					Array[i] = randomChar;
				} else if (randomValue == 24) {
					randomChar = "P";
					Array[i] = randomChar;
				} else if (randomValue == 25) {
					randomChar = "Q";
					Array[i] = randomChar;
				} else if (randomValue == 26) {
					randomChar = "R";
					Array[i] = randomChar;
				} else if (randomValue == 27) {
					randomChar = "S";
					Array[i] = randomChar;
				} else if (randomValue == 28) {
					randomChar = "T";
					Array[i] = randomChar;
				} else if (randomValue == 29) {
					randomChar = "U";
					Array[i] = randomChar;
				} else if (randomValue == 30) {
					randomChar = "V";
					Array[i] = randomChar;
				} else if (randomValue == 31) {
					randomChar = "W";
					Array[i] = randomChar;
				} else if (randomValue == 32) {
					randomChar = "X";
					Array[i] = randomChar;
				} else if (randomValue == 33) {
					randomChar = "Y";
					Array[i] = randomChar;
				} else if (randomValue == 34) {
					randomChar = "Z";
					Array[i] = randomChar;
				} else if (randomValue == 35) {
					randomChar = "Z";
					Array[i] = randomChar;
				} else {
					randomChar = "Z";
					Array[i] = randomChar;
				}
			}
		}
		String value = Array[0] + Array[1] + Array[2] + Array[3] + Array[4] + Array[5] + Array[6] + Array[7];
		
		vo.setEmp_password(value);
		service.updatePwd(vo);
	
		
		// smtp메일 전송하기
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo(email);
			messageHelper.setText(value);
			messageHelper.setFrom(from);
			messageHelper.setSubject(subject);	
			
			mailSender.send(message);
		} catch(Exception e){
			System.out.println(e);
		}
		
		model.addAttribute("email", email);
		return "/member/findPwdResult";
		
	}
}
