package com.koroupware.message.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.emp.domain.EmpVO;
import com.koroupware.message.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	@Inject
	private SqlSession sqlSession;
	private static String namespace = "com.koroupware.mappers.MessageMapper";
	@Override
	public void insertMessage(MessageVO vo) {
		sqlSession.insert(namespace+".insertMessage",vo);
	}

	@Override
	public String getReceiver(int emp_no) {
		return sqlSession.selectOne(namespace+".getReceiver",emp_no);
	}

	@Override
	public String getSender(int emp_no) {
		return sqlSession.selectOne(namespace+".getSender",emp_no);
	}

	@Override
	public List<MessageVO> listreceivedMessage(int message_receiver_no) {
		return sqlSession.selectList(namespace+".listreceivedMessage",message_receiver_no);
	}

	@Override
	public List<EmpVO> searchEmp(String searchKeyword) {
		return sqlSession.selectList(namespace+".searchEmp",searchKeyword);
	}

	@Override
	public List<MessageVO> listsendedMessage(int message_sender_no) {
		return sqlSession.selectList(namespace+".listsendedMessage",message_sender_no);
	}

	@Override
	public void deleteMessage(int message_no) {
		sqlSession.update(namespace+".deleteMessage",message_no);
	}

	@Override
	public MessageVO selectMessage(int message_no) {
		
		return sqlSession.selectOne(namespace+".selectMessage",message_no);
	}

}
