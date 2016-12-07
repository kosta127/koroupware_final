package com.koroupware.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koroupware.board.domain.ReplyDTO;
import com.koroupware.board.domain.ReplyVO;
import com.koroupware.board.service.ReplyService;

@RestController
@RequestMapping("board/reply")
public class ReplyController {
	
	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
		
		ResponseEntity<String> entity = null;
		try {
			service.replyRegist(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*
	@RequestMapping(value="/all/{board_no}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("board_no") int board_no){
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.replyList(board_no), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	*/
	
	@RequestMapping(value="/all/{board_no}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyDTO>> list(@PathVariable("board_no") int board_no){
		ResponseEntity<List<ReplyDTO>> entity = null;
		
		try {
			List<ReplyDTO> list = service.replyList(board_no);
			
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{reply_no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("reply_no") Integer reply_no){
		ResponseEntity<String> entity = null;

		try {
			service.replyRemove(reply_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
