package com.koroupware.imageroom.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.imageroom.domain.ImageCaptureVO;

@Repository
public class CanvasDAOImpl implements CanvasDAO{
	private static final String NAMESPACE = "com.koroupware.mappers.CanvasMapper";
	
	@Inject
	private SqlSession session;

	@Override
	public void imageCaptureInsert(ImageCaptureVO imageCapture) {
		System.out.println(imageCapture);
		
		session.insert(NAMESPACE + ".imageCaptureInsert", imageCapture);
	}

	@Override
	public List<ImageCaptureVO> imageCaptureList(Integer image_room_no, Integer emp_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("image_room_no", image_room_no);
		map.put("emp_no", emp_no);
		
		return session.selectList(NAMESPACE + ".imageCaptureList", map);
	}

	@Override
	public Integer nextImageCaptureNoSelect() {
		return session.selectOne(NAMESPACE + ".nextImageCaptureNoSelect");
	}

	@Override
	public void imageCaptureDelete(Integer image_capture_no) {
		session.delete(NAMESPACE + ".imageCaptureDelete", image_capture_no);
	}
	
	
}
