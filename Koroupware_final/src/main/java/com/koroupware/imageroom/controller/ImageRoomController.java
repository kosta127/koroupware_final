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

import com.koroupware.imageroom.domain.EmpImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;
import com.koroupware.imageroom.service.ImageRoomService;


@Controller
@RequestMapping(value="/imageRoom/*")
public class ImageRoomController {
	@Inject
	private ImageRoomService service;

	@ResponseBody
	@RequestMapping(value="/imageRoomLobby", method=RequestMethod.GET)
	public ResponseEntity<List<ImageRoomDTO>> imageRoomListGET(){
		ResponseEntity<List<ImageRoomDTO>> entity = null;
		
		try {
			List<ImageRoomDTO> list = service.imageRoomList();
			
			entity = new ResponseEntity<List<ImageRoomDTO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<ImageRoomDTO>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/*
	@ResponseBody
	@RequestMapping(value="/imageRoomLobby", method=RequestMethod.GET)
	public ResponseEntity<List<ImageRoomVO>> imageRoomListGET(){
		ResponseEntity<List<ImageRoomVO>> entity = null;
		
		try {
			List<ImageRoomVO> list = service.imageRoomList();
			
			entity = new ResponseEntity<List<ImageRoomVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<ImageRoomVO>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	*/
	@ResponseBody
	@RequestMapping(value="/imageRoomLobby", method=RequestMethod.POST)
	public ResponseEntity<String> createRoom(ImageRoomVO imageRoom){
		ResponseEntity<String> entity = null;
		
		try {
			service.imageRoomRegist(imageRoom);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/getRoomNo")
	public ResponseEntity<Integer> getRoomNo(){
		ResponseEntity<Integer> entity = null;
		
		try {
			Integer image_room_no = service.nextRoomNoRead();
			
			entity = new ResponseEntity<Integer>(image_room_no, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	@ResponseBody
	@RequestMapping(value="/getEmp")
	public ResponseEntity<EmpImageRoomDTO> getEmp(@RequestParam("emp_no") Integer emp_no){
		ResponseEntity<EmpImageRoomDTO> entity = null;
		
		try {
			EmpImageRoomDTO emp = service.empRead(emp_no);
			System.out.println(emp);
			entity = new ResponseEntity<EmpImageRoomDTO>(emp, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<EmpImageRoomDTO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	/*
	@ResponseBody
	@RequestMapping(value="/getEmp")
	public ResponseEntity<EmpVO> getEmp(@RequestParam("emp_no") Integer emp_no){
		ResponseEntity<EmpVO> entity = null;
		
		try {
			EmpVO emp = service.empRead(emp_no);
			
			entity = new ResponseEntity<EmpVO>(emp, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<EmpVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	*/
	
	
	@ResponseBody
	@RequestMapping(value="/imageRoomDelete", method=RequestMethod.POST)
	public ResponseEntity<String> imageCaptureDelete(@RequestParam("image_room_no") Integer image_room_no){
		ResponseEntity<String> entity = null;
		
		try {
			service.imageRoomRemove(image_room_no);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
