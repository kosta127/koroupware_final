package com.koroupware.imageroom.persistence;

import java.util.List;

import com.koroupware.imageroom.domain.ChatingDTO;
import com.koroupware.imageroom.domain.ImageRoomHisVO;

public interface ChatDAO {
	public void imageRoomHisInsert(ImageRoomHisVO vo);
	public List<ImageRoomHisVO> imageRoomHisList(Integer image_room_no);
	public Integer nextImageRoomHisNoSelect();
	public List<ChatingDTO> chaingList(Integer image_room_no);
}
