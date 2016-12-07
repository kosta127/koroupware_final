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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koroupware.common.util.MediaUtils;
import com.koroupware.common.util.UploadFileUtils;
import com.koroupware.emp.domain.EmpVO;
import com.koroupware.emp.domain.TelDTO;
import com.koroupware.emp.service.EmpTelService;

@Controller
public class EmpDataUpdateController {
	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private EmpTelService empTelService;

	@RequestMapping(value = "/empDataUpdate", method = RequestMethod.GET)
	public String empDataUpdatePage(@RequestParam("emp_no") int emp_no, Model model) throws Exception { // 회원정보수정
		model.addAttribute("emp", empTelService.empList(emp_no));
		return "empDataUpdate/empDataForm";
	}

	@RequestMapping(value = "/empDataUpdate/update", method = RequestMethod.POST)
	public String empDataUpdate(EmpVO empVo) throws Exception { // 회원정보수정 확인
		empTelService.empDataUpdate(empVo);
		return "redirect:/";
	}

	@RequestMapping(value = "/empDataUpdate/uploadAjax", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
		return entity;
	}

	@RequestMapping(value = "/empDataUpdate/displayFile")
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		// logger.info("FILE NAME: " + fileName);
		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + "\\" + fileName);

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
	@RequestMapping(value = "/empDataUpdate/deleteFile", method = RequestMethod.POST)
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

	@RequestMapping(value = "/empDataUpdate/addTel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addTel(@RequestBody TelDTO telDTO) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			empTelService.addTel(telDTO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/empDataUpdate/{emp_no}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TelDTO>> telList(@PathVariable("emp_no") Integer emp_no) throws Exception {
		ResponseEntity<List<TelDTO>> entity = null;
		System.out.println("ajax" + emp_no);
		try {
			entity = new ResponseEntity<>(empTelService.telList(emp_no), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/empDataUpdate/{tel_no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeTel(@PathVariable("tel_no") Integer tel_no) {
		ResponseEntity<String> entity = null;
		try {
			empTelService.deleteTel(tel_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}