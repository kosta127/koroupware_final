package com.koroupware.message.service;

import java.util.List;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.message.domain.MessageVO;

public interface MessageService {
	public void messageRegist(MessageVO vo);
	public List<MessageVO> receivedmessageList(int message_receiver_no);
	public List<MessageVO> sendedmessageList(int message_sender_no);
	public String sender_nameGet(int emp_no);
	public String receiver_nameGet(int emp_no);
	public List<EmpVO> empSearch(String searchKeyword);
	public void messageRemove(int message_no);
	public MessageVO messageRead(int message_no);
	
}
