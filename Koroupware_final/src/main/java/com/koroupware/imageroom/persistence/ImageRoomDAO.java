package com.koroupware.imageroom.persistence;

import java.util.List;

import com.koroupware.dept.domain.EmpVO;
import com.koroupware.imageroom.domain.EmpDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;

public interface ImageRoomDAO {
	public void imageRoomInsert(ImageRoomVO imageRoom);
	public List<ImageRoomVO> imageRoomList();
	public Integer nextRoomNoSelect();
	//public EmpVO empSelect(Integer emp_no);
	public EmpDTO empSelect(Integer emp_no);
}
