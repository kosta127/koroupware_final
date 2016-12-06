package com.koroupware.schedule.service;

import java.sql.Timestamp;
import java.util.List;

import com.koroupware.schedule.domain.ScheduleVO;

public interface ScheduleService {
	public void scheduleRegist(ScheduleVO schedule)throws Exception;
	public List<ScheduleVO> scheduleList(ScheduleVO schedule)throws Exception;

}
