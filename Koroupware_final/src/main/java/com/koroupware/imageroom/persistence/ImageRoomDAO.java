package com.koroupware.imageroom.persistence;

import java.util.List;

import com.koroupware.imageroom.domain.EmpImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;

public interface ImageRoomDAO {
	public void imageRoomInsert(ImageRoomVO imageRoom);
	public List<ImageRoomVO> imageRoomList();
	public Integer nextRoomNoSelect();
	//public EmpVO empSelect(Integer emp_no);
	public EmpImageRoomDTO empSelect(Integer emp_no);
}
