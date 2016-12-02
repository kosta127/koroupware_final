package com.koroupware.imageroom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.imageroom.domain.EmpImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;
import com.koroupware.imageroom.persistence.ImageRoomDAO;

@Service
public class ImageRoomServiceImpl implements ImageRoomService{
	@Inject
	private ImageRoomDAO dao;

	@Override
	public void imageRoomRegist(ImageRoomVO imageRoom) {
		int image_room_no = dao.nextRoomNoSelect();
		
		imageRoom.setImage_room_no(image_room_no);
		
		dao.imageRoomInsert(imageRoom);
	}

	@Override
	public List<ImageRoomVO> imageRoomList() {
		return dao.imageRoomList();
	}

	@Override
	public Integer nextRoomNoRead() {
		return dao.nextRoomNoSelect();
	}
	/*
	@Override
	public EmpVO empRead(Integer emp_no) {
		return dao.empSelect(emp_no);
	}
	*/
	@Override
	public EmpImageRoomDTO empRead(Integer emp_no) {
		return dao.empSelect(emp_no);
	}
	
}
