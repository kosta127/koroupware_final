package com.koroupware.schedule.persistence;

import java.sql.Timestamp;
import java.util.List;

import com.koroupware.schedule.domain.ScheduleVO;

public interface ScheduleDAO {
	public void scheduleInsert(ScheduleVO schedule)throws Exception;
	public List<ScheduleVO> scheduleList(ScheduleVO schedule)throws Exception;
	public ScheduleVO scheduleSelect(int schedule_no)throws Exception;
	public void scheduleDelete(int schedule_no)throws Exception;
	public void scheduleUpdate(ScheduleVO schedule)throws Exception;

}
