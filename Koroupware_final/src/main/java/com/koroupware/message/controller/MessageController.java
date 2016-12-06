package com.koroupware.message.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.message.domain.MessageVO;
import com.koroupware.message.service.MessageService;


@Controller
@RequestMapping("/message/*")
public class MessageController {
	@Inject
	private MessageService service;
	
	@RequestMapping(value="messageRegist/{emp_no}",method=RequestMethod.GET)
	public String messageRegistGET(@PathVariable("emp_no") int emp_no,Model model){
		String emp_name = service.receiver_nameGet(emp_no);
		model.addAttribute("emp_no",emp_no);
		model.addAttribute("emp_name",emp_name);
		return "/message/messageRegist";
	}
	@RequestMapping(value="messageRegist/{emp_no}",method=RequestMethod.POST)
	public String messageRegistPOST(@PathVariable("emp_no") int emp_no,MessageVO vo,
			@RequestParam("message_receiver_no") int[] message_receiver_no,Model model){
		List<String> receiver_name_list = new ArrayList<String>();
		for(int i=0;i<message_receiver_no.length;i++){
			receiver_name_list.add(service.receiver_nameGet(message_receiver_no[i]));
			System.out.println(message_receiver_no[i]);
		}
		String sender_name = service.sender_nameGet(emp_no);
		for(int i=0;i<receiver_name_list.size();i++){
			vo.setMessage_receiver_name(receiver_name_list.get(i));
			vo.setMessage_sender_no(emp_no);
			vo.setMessage_sender_name(sender_name);
			vo.setMessage_receiver_no(message_receiver_no[i]);
			service.messageRegist(vo);
		}
		
		
		//model.addAttribute("message_receiver_no",message_receiver_no);
		//model.addAttribute("receiver_name",receiver_name);
		//model.addAttribute("emp_no",emp_no);
		
		
		
		return "/message/messageRegist";
	}
	@RequestMapping(value="messageSearch/{emp_no}",method=RequestMethod.GET)
	public String messageSearchGET(@PathVariable("emp_no") int emp_no,Model model){
		model.addAttribute("emp_no",emp_no);
		return "/message/messageSearch";
	}
	
	@RequestMapping(value="messageSearch",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<EmpVO>> messageSearchPOST(String searchKeyword){
		
		List<EmpVO> list = service.empSearch(searchKeyword);
		
		return new ResponseEntity<List<EmpVO>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="receivedmessageList/{emp_no}",method=RequestMethod.GET)
	public String receivedmessageList(Model model,@PathVariable("emp_no") int message_receiver_no){
		List<MessageVO> list = service.receivedmessageList(message_receiver_no);
		for(int i=0;i<list.size();i++){
			list.get(i).setMessage_sender_name(service.sender_nameGet(list.get(i).getMessage_sender_no()));
		}
		model.addAttribute("list",list);
		model.addAttribute("emp_no",message_receiver_no);
		return "/message/receivedmessageList";
	}
	
	@RequestMapping(value="sendedmessageList/{emp_no}",method=RequestMethod.GET)
	public String sendedmessageList(@PathVariable("emp_no") int message_sender_no,Model model){
		List<MessageVO> list = service.sendedmessageList(message_sender_no);
		for(int i=0;i<list.size();i++) {
			list.get(i).setMessage_receiver_name(service.receiver_nameGet(list.get(i).getMessage_receiver_no()));
		}
		model.addAttribute("list",list);
		model.addAttribute("emp_no",message_sender_no);
		return "/message/sendedmessageList";
	}
	
	@RequestMapping(value="messageRemove/received/{emp_no}",method=RequestMethod.POST)
	public String receivedmessageRemove(@RequestParam("message_no") int[] message_no,
				@PathVariable("emp_no") int emp_no){
		for(int i=0;i<message_no.length;i++){
			service.messageRemove(message_no[i]);
		}
		return "redirect:/message/receivedmessageList/"+emp_no;
	}
	@RequestMapping(value="messageRemove/sended/{emp_no}",method=RequestMethod.POST)
	public String sendedmessageRemove(@RequestParam("message_no") int[] message_no,
			@PathVariable("emp_no") int emp_no){
		for(int i=0;i<message_no.length;i++){
			service.messageRemove(message_no[i]);
		}
		return "redirect:/message/sendedmessageList/"+emp_no;
	}
	
	@RequestMapping(value="receivedmessageRead/{message_no}", method=RequestMethod.GET)
	public String receivedmessageRead(@PathVariable("message_no") int message_no,Model model){
		MessageVO vo = service.messageRead(message_no);
	
		vo.setMessage_sender_name(service.sender_nameGet(vo.getMessage_sender_no()));
		model.addAttribute("messageVO",vo);
	
		return "/message/receivedmessageRead";
	}
	
	@RequestMapping(value="sendedmessageRead/{message_no}", method=RequestMethod.GET)
	public String messageRead(@PathVariable("message_no") int message_no,Model model){
		System.out.println("check");
		MessageVO vo = service.messageRead(message_no);
		
		vo.setMessage_receiver_name(service.receiver_nameGet(vo.getMessage_receiver_no()));
		model.addAttribute("messageVO",vo);
		System.out.println(vo);
		return "/message/sendedmessageRead";
	}
}
