package com.koroupware.imageroom.service;

import java.util.List;

import com.koroupware.dept.domain.EmpVO;
import com.koroupware.imageroom.domain.EmpDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;

public interface ImageRoomService {
	public void imageRoomRegist(ImageRoomVO imageRoom);
	public List<ImageRoomVO> imageRoomList();
	public Integer nextRoomNoRead();
	//public EmpVO empRead(Integer emp_no);
	public EmpDTO empRead(Integer emp_no);
	
	
}
