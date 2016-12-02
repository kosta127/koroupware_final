package com.koroupware.imageroom.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.imageroom.domain.EmpImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;

@Repository
public class ImageRoomDAOImpl implements ImageRoomDAO{
	private static final String NAMESPACE = "com.koroupware.mappers.ImageRoomMapper";
	
	@Inject
	private SqlSession session;

	@Override
	public void imageRoomInsert(ImageRoomVO imageRoom) {
		session.insert(NAMESPACE + ".imageRoomInsert", imageRoom);
	}

	@Override
	public List<ImageRoomVO> imageRoomList() {
		return session.selectList(NAMESPACE + ".imageRoomList");
	}

	@Override
	public Integer nextRoomNoSelect() {
		return session.selectOne(NAMESPACE + ".nextRoomNoSelect");
	}
	/*
	@Override
	public EmpVO empSelect(Integer emp_no) {
		return session.selectOne(NAMESPACE + ".empSelect", emp_no);
	}
	*/
	@Override
	public EmpImageRoomDTO empSelect(Integer emp_no) {
		return session.selectOne(NAMESPACE + ".empSelect", emp_no);
	}
}
