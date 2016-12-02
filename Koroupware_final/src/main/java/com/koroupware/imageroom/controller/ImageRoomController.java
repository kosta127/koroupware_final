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

import com.koroupware.dept.domain.EmpVO;
import com.koroupware.imageroom.domain.EmpDTO;
import com.koroupware.imageroom.domain.ImageRoomVO;
import com.koroupware.imageroom.service.ImageRoomService;


@Controller
@RequestMapping(value="/imageRoom/*")
public class ImageRoomController {
	@Inject
	private ImageRoomService service;

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
	public ResponseEntity<EmpDTO> getEmp(@RequestParam("emp_no") Integer emp_no){
		ResponseEntity<EmpDTO> entity = null;
		
		try {
			EmpDTO emp = service.empRead(emp_no);
			
			entity = new ResponseEntity<EmpDTO>(emp, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<EmpDTO>(HttpStatus.BAD_REQUEST);
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
}
