package com.koroupware.schedule.service;

import java.sql.Timestamp;
import java.util.List;

import com.koroupware.schedule.domain.ScheduleVO;

public interface ScheduleService {
	public void scheduleRegist(ScheduleVO schedule)throws Exception;
	public List<ScheduleVO> scheduleList(ScheduleVO schedule)throws Exception;
	public ScheduleVO scheduleRead(int schedule_no)throws Exception;
	public void scheduleRemove(int schedule_no)throws Exception;
	public void scheduleModify(ScheduleVO schedule)throws Exception;
}
