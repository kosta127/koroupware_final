package com.koroupware.imageroom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koroupware.imageroom.domain.EmpImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;
import com.koroupware.imageroom.persistence.ImageRoomDAO;

@Service
public class ImageRoomServiceImpl implements ImageRoomService{
	@Inject
	private ImageRoomDAO dao;

	@Transactional
	@Override
	public void imageRoomRegist(ImageRoomVO imageRoom) {
		Integer image_room_no = nextRoomNoRead();
		imageRoom.setImage_room_no(image_room_no);
		
		dao.imageRoomInsert(imageRoom);
	}

	@Override
	public List<ImageRoomDTO> imageRoomList() {
		return dao.imageRoomList();
	}
	
	/*
	@Override
	public List<ImageRoomVO> imageRoomList() {
		return dao.imageRoomList();
	}
	 */
	
	@Override
	public Integer nextRoomNoRead() {
		Integer image_room_no = dao.nextRoomNoSelect();
		
		if(image_room_no == null){
			image_room_no = 1;
		}
		
		return image_room_no;
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

	@Override
	public void imageRoomRemove(Integer image_room_no) {
		dao.imageRoomDelete(image_room_no);
	}
	
}
