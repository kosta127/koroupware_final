package com.koroupware.schedule.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.schedule.domain.ScheduleVO;
import com.koroupware.schedule.persistence.ScheduleDAO;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Inject
	private ScheduleDAO dao;
	
	@Override
	public void scheduleRegist(ScheduleVO schedule) throws Exception {
		System.out.println("service");
		dao.scheduleInsert(schedule);
		
	}

	@Override
	public List<ScheduleVO> scheduleList(ScheduleVO schedule) throws Exception {
		return dao.scheduleList(schedule);
	}

}
