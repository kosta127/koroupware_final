package com.koroupware.imageroom.service;

import java.util.List;

import com.koroupware.imageroom.domain.ImageCaptureVO;
import com.koroupware.imageroom.domain.ImageRoomVO;

public interface CanvasService {
	public void imageCaptureRegist(ImageCaptureVO imageCapture);
	public List<ImageCaptureVO> imageCaptureList(Integer image_room_no, Integer emp_no);
	public Integer nextImageCaptureNoRead();
	public void imageCaptureRemove(Integer image_capture_no);
}
