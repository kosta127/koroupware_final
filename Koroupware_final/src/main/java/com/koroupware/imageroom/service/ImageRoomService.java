package com.koroupware.imageroom.service;

import java.util.List;

import com.koroupware.imageroom.domain.EmpImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;

public interface ImageRoomService {
	public void imageRoomRegist(ImageRoomVO imageRoom);
	//public List<ImageRoomVO> imageRoomList();
	public List<ImageRoomDTO> imageRoomList();
	public Integer nextRoomNoRead();
	//public EmpVO empRead(Integer emp_no);
	public EmpImageRoomDTO empRead(Integer emp_no);
	public void imageRoomRemove(Integer image_room_no);
	
}
