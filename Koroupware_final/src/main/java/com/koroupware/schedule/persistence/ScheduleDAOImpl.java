package com.koroupware.schedule.persistence;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.schedule.domain.ScheduleVO;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "com.koroupware.board.mappers.ScheduleMapper";
	
	@Override
	public void scheduleInsert(ScheduleVO schedule) throws Exception {
		Integer value = sqlsession.selectOne(namespace+".maxNumber");
		
		if(value==null){
			schedule.setSchedule_no(1);
		}else{
			schedule.setSchedule_no(value+1);
		}
		
		sqlsession.insert(namespace+".insertSchedule", schedule);
		
	}

	@Override
	public List<ScheduleVO> scheduleList(ScheduleVO schedule) throws Exception {
		return sqlsession.selectList(namespace+".listSchedule", schedule);
	}

}
