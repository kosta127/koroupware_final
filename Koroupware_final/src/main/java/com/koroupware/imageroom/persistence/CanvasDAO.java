package com.koroupware.imageroom.persistence;

import java.util.List;

import com.koroupware.imageroom.domain.ImageCaptureVO;

public interface CanvasDAO {
	public void imageCaptureInsert(ImageCaptureVO imageCapture);
	public void imageCaptureDelete(Integer image_capture_no);
	public List<ImageCaptureVO> imageCaptureList(Integer image_room_no, Integer emp_no);
	public Integer nextImageCaptureNoSelect();
}
