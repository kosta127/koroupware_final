package com.koroupware.imageroom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.imageroom.domain.ImageCaptureVO;
import com.koroupware.imageroom.persistence.CanvasDAO;

@Service
public class CanvasServiceImpl implements CanvasService{
	@Inject
	private CanvasDAO dao;
	
	@Override
	public void imageCaptureRegist(ImageCaptureVO imageCapture) {
		dao.imageCaptureInsert(imageCapture);
	}

	@Override
	public List<ImageCaptureVO> imageCaptureList(Integer image_room_no, Integer emp_no) {
		return dao.imageCaptureList(image_room_no, emp_no);
	}

	@Override
	public Integer nextImageCaptureNoRead() {
		return dao.nextImageCaptureNoSelect();
	}

	@Override
	public void imageCaptureRemove(Integer image_capture_no) {
		dao.imageCaptureDelete(image_capture_no);
	}

}
