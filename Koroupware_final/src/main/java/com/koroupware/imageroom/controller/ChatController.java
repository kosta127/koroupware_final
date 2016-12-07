package com.koroupware.imageroom.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.imageroom.domain.ChatingDTO;
import com.koroupware.imageroom.domain.ImageRoomHisVO;
import com.koroupware.imageroom.service.ChatService;

@Controller
@RequestMapping(value="/chat/*")
public class ChatController {
	@Inject
	private ChatService service;
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> chatPOST(ImageRoomHisVO vo){
		ResponseEntity<String> entity = null;
		
		System.out.println(vo);
		
		try {
			service.imageRoomHisRegist(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	

	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<ChatingDTO>> chatGET(@RequestParam("image_room_no") Integer image_room_no){
		ResponseEntity<List<ChatingDTO>> entity = null;
		
		try {
			List<ChatingDTO> list = service.chaingList(image_room_no);

			entity = new ResponseEntity<List<ChatingDTO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			entity = new ResponseEntity<List<ChatingDTO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	/*
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<ImageRoomHisVO>> chatGET(@RequestParam("image_room_no") Integer image_room_no){
		ResponseEntity<List<ImageRoomHisVO>> entity = null;
		
		try {
			List<ImageRoomHisVO> list = service.imageRoomHisList(image_room_no);

			entity = new ResponseEntity<List<ImageRoomHisVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			entity = new ResponseEntity<List<ImageRoomHisVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	*/
	@ResponseBody
	@RequestMapping(value="/getImageRoomHisNo", method=RequestMethod.GET)
	public ResponseEntity<Integer> getImageRoomHisNo(){
		ResponseEntity<Integer> entity = null;
		
		try {
			Integer imageRoomHisNo = service.nextImageRoomHisNoRead();

			entity = new ResponseEntity<Integer>(imageRoomHisNo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
