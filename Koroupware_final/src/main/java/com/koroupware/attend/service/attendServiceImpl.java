package com.koroupware.attend.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.attend.dto.AttendDTO;
import com.koroupware.attend.persistence.AttendDAO;


@Service
public class attendServiceImpl implements attendService {

	@Inject
	private AttendDAO attendDAO;
	// 인터페이스는 new가 되지 않으므로 꼭 임프라이해야 가지고 올 수 있음.

	@Override
	public void addAttend(AttendVO attendVO) {

		attendDAO.attendInsert(attendVO);
	}

	@Override
	public AttendVO attendCheck(AttendVO attendVO) {
		return attendDAO.attendCheck(attendVO);
	}

	@Override
	public List<AttendDTO> attendList(int emp_no) {
		List<AttendDTO> list = attendDAO.attendList(emp_no);
		return list;
	}
	


}
