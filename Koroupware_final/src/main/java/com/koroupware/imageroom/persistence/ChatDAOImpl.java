package com.koroupware.imageroom.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.imageroom.domain.ChatingDTO;
import com.koroupware.imageroom.domain.ImageRoomHisVO;

@Repository
public class ChatDAOImpl implements ChatDAO{
	private static final String NAMESPACE = "com.koroupware.mappers.ChatMapper";
	
	@Inject
	private SqlSession session;

	@Override
	public void imageRoomHisInsert(ImageRoomHisVO vo) {
		session.insert(NAMESPACE + ".imageRoomHisInsert", vo);
	}

	@Override
	public List<ImageRoomHisVO> imageRoomHisList(Integer image_room_no) {
		return session.selectList(NAMESPACE + ".imageRoomHisList", image_room_no);
	}

	@Override
	public Integer nextImageRoomHisNoSelect() {
		return session.selectOne(NAMESPACE + ".nextImageRoomHisNoSelect");
	}

	@Override
	public List<ChatingDTO> chaingList(Integer image_room_no) {
		return session.selectList(NAMESPACE + ".chaingList", image_room_no);
	}
}
