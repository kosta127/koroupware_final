package com.koroupware.message.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.message.domain.MessageVO;
import com.koroupware.message.persistence.MessageDAO;

@Service
public class MessageServiceImpl implements MessageService {
	@Inject
	private MessageDAO messageDAO;
	@Override
	public void messageRegist(MessageVO vo) {
		messageDAO.insertMessage(vo);
	}

	@Override
	public List<MessageVO> listreceivedMessage(int message_receiver_no) {
		return messageDAO.listreceivedMessage(message_receiver_no);
	}

	@Override
	public String sender_nameGet(int emp_no) {
		return messageDAO.getSender(emp_no);
	}

	@Override
	public String receiver_nameGet(int emp_no) {
		return messageDAO.getReceiver(emp_no);
	}

	@Override
	public List<EmpVO> searchEmp(String searchKeyword) {
		return messageDAO.searchEmp(searchKeyword);
	}

	@Override
	public List<MessageVO> listsendedMessage(int message_sender_no) {
		return messageDAO.listsendedMessage(message_sender_no);
	}

}
