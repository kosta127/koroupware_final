package com.koroupware.emp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koroupware.common.util.MediaUtils;
import com.koroupware.common.util.UploadFileUtils;
import com.koroupware.emp.domain.EmpVO;
import com.koroupware.emp.domain.TelVO;
import com.koroupware.emp.service.EmpTelService;

@Controller
public class EmpDataUpdateController {
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Inject
	private EmpTelService empTelService;
	
	@RequestMapping(value="/empDataUpdate", method=RequestMethod.GET)
	public String empDataUpdatePage() throws Exception{ //회원정보수정 페이지
		return "empDataUpdate/empDataForm";
	}
	
	@RequestMapping(value="/empDataUpdate", method=RequestMethod.POST)
	public String empDataUpdate(EmpVO empVo) throws Exception{ //회원정보수정 확인
		empTelService.empDataUpdate(empVo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/empDataUpdate/uploadAjax", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
					HttpStatus.CREATED);
		return entity;
	}
	
		@RequestMapping(value="/empDataUpdate/displayFile")
		@ResponseBody
		public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
			InputStream in = null;
			ResponseEntity<byte[]> entity = null;
			// logger.info("FILE NAME: " + fileName);
			try {

				String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
				MediaType mType = MediaUtils.getMediaType(formatName);

				HttpHeaders headers = new HttpHeaders();

				in = new FileInputStream(uploadPath + fileName);

				if (mType != null) {
					headers.setContentType(mType);
				} else {

					fileName = fileName.substring(fileName.indexOf("_") + 1);
					headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
					headers.add("Content-Disposition",
							"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
				}

				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			} finally {
				in.close();
			}
			return entity;
		}
		
		@ResponseBody
		@RequestMapping(value="/empDataUpdate/deleteFile", method=RequestMethod.POST)
		public ResponseEntity<String> deleteFile(String fileName) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);

			if (mType != null) {
				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
}
