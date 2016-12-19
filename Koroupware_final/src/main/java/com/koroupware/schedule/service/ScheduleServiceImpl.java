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
		dao.scheduleInsert(schedule);
	}

	@Override
	public List<ScheduleVO> scheduleList(ScheduleVO schedule) throws Exception {
		return dao.scheduleList(schedule);
	}

	@Override
	public ScheduleVO scheduleRead(int schedule_no) throws Exception {
		return dao.scheduleSelect(schedule_no);
	}

	@Override
	public void scheduleRemove(int schedule_no) throws Exception {
		dao.scheduleDelete(schedule_no);
		
	}

	@Override
	public void scheduleModify(ScheduleVO schedule) throws Exception {
		dao.scheduleUpdate(schedule);
		
	}

}
