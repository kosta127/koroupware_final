package com.koroupware.message.persistence;

import java.util.List;

import com.koroupware.doc.domain.DocBoxVO;
import com.koroupware.doc.domain.DocFileVO;
import com.koroupware.doc.domain.DocHisVO;
import com.koroupware.doc.domain.DocManagementVO;
import com.koroupware.doc.domain.DocVO;
import com.koroupware.emp.domain.EmpVO;
import com.koroupware.message.domain.MessageVO;

public interface MessageDAO {
	public void insertMessage(MessageVO vo);
	public String getReceiver(int emp_no);
	public String getSender(int emp_no);
	public List<MessageVO> listreceivedMessage(int message_receiver_no);
	public List<MessageVO> listsendedMessage(int message_sender_no);
	public List<EmpVO> searchEmp(String searchKeyword); 
	public void deleteMessage(int message_no);
	public MessageVO selectMessage(int message_no);
}
