package com.koroupware.imageroom.service;

import java.util.List;

import com.koroupware.imageroom.domain.ChatingDTO;
import com.koroupware.imageroom.domain.ImageRoomHisVO;

public interface ChatService {
	public void imageRoomHisRegist(ImageRoomHisVO vo);
	public List<ImageRoomHisVO> imageRoomHisList(Integer image_room_no);
	public Integer nextImageRoomHisNoRead();
	public List<ChatingDTO> chaingList(Integer image_room_no);
}
