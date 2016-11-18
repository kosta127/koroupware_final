package com.koroupware.dept.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koroupware.common.util.ETC;
import com.koroupware.dept.domain.OrgChartDTO;
import com.koroupware.dept.domain.OrgChartEmpVO;
import com.koroupware.dept.service.DeptService;

@Controller
@RequestMapping(value="dept/*")
public class DeptController {
	@Inject
	private DeptService service;
	
	@RequestMapping(value="/Test")
	public void test() throws Exception{
		//test
		
	}
	
	@ResponseBody
	@RequestMapping(value="/ReadTree", method={RequestMethod.GET})
	public ResponseEntity<List<OrgChartEmpVO>> orgChartEmpTreeRead() throws Exception{
		//개인 정보 검색 ajax
		ResponseEntity<List<OrgChartEmpVO>> entity = null;
		
		try {
			List<OrgChartEmpVO> orgChartTreeList = service.orgChartTreeList();

			entity = new ResponseEntity<List<OrgChartEmpVO>>(orgChartTreeList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<OrgChartEmpVO>>(HttpStatus.BAD_REQUEST);
		}
	
		return entity;
	}
	
	@RequestMapping(value="/List")
	public void list(Model model) throws Exception{
		//조직도 페이지 이동
		List<OrgChartDTO> orgChartList = service.orgChartList();
		
		model.addAttribute("orgChartList", orgChartList);
	}
	
	@ResponseBody
	@RequestMapping(value="/Read/{emp_no}", method={RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<List<OrgChartEmpVO>> orgChartEmpRead(@PathVariable("emp_no") Integer emp_no) 
			throws Exception{
		//개인 정보 검색 ajax
		ResponseEntity<List<OrgChartEmpVO>> entity = null;
		
		try {
			List<OrgChartEmpVO> orgChartEmpDetailModelList = new ArrayList<OrgChartEmpVO>();
			
			OrgChartEmpVO myEmp = service.orgChartEmpRead(emp_no);
			
			myEmp.setClassification("myEmp");
			orgChartEmpDetailModelList.add(myEmp);
			
			if(myEmp.getEmp_superior() != 0){
				OrgChartEmpVO superiorEmp = service.orgChartEmpRead(myEmp.getEmp_superior());
				
				if(ETC.isNotNull(superiorEmp)){
					superiorEmp.setClassification("superiorEmp");
					orgChartEmpDetailModelList.add(superiorEmp);
				}
			}
			
			if(myEmp.getEmp_reporter() != 0){
				OrgChartEmpVO reporterEmp
						= service.orgChartEmpRead(myEmp.getEmp_reporter());
						
				if(ETC.isNotNull(reporterEmp)){
					reporterEmp.setClassification("reporterEmp");
					orgChartEmpDetailModelList.add(reporterEmp);
				}	
			}
			
			entity = new ResponseEntity<List<OrgChartEmpVO>>(orgChartEmpDetailModelList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<OrgChartEmpVO>>(HttpStatus.BAD_REQUEST);
		}
	
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/empImg")
	public ResponseEntity<byte[]> displayFile(@RequestParam("fileName") String fileName, 
												HttpServletRequest request) throws Exception{
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		String uploadPath = request.getRealPath("upload");
		
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + "\\" + fileName);

			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
		      in.close();
	    }
		
		return entity;
	}
}




  