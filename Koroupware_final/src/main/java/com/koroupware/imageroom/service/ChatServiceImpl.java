package com.koroupware.imageroom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.imageroom.domain.ChatingDTO;
import com.koroupware.imageroom.domain.ImageRoomHisVO;
import com.koroupware.imageroom.persistence.ChatDAO;

@Service
public class ChatServiceImpl implements ChatService{
	@Inject
	private ChatDAO dao;
	
	@Override
	public void imageRoomHisRegist(ImageRoomHisVO vo) {
		dao.imageRoomHisInsert(vo);
	}

	@Override
	public List<ImageRoomHisVO> imageRoomHisList(Integer image_room_no) {
		return dao.imageRoomHisList(image_room_no);
	}

	@Override
	public Integer nextImageRoomHisNoRead() {
		return dao.nextImageRoomHisNoSelect();
	}

	@Override
	public List<ChatingDTO> chaingList(Integer image_room_no) {
		return dao.chaingList(image_room_no);
	}

}
