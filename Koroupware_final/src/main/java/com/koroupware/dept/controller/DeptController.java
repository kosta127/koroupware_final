package com.koroupware.dept.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koroupware.common.util.ETC;
import com.koroupware.dept.domain.OrgChartDTO;
import com.koroupware.dept.domain.OrgChartEmpVO;
import com.koroupware.dept.service.DeptService;

@Controller
@RequestMapping(value="/dept/*")
public class DeptController {
	@Inject
	private DeptService service;
	
	@RequestMapping(value="/List")
	public void list(Model model) throws Exception{
		//조직도 페이지 이동
		List<OrgChartDTO> orgCharList = service.orgChartList();
		
		model.addAttribute("orgCharList", orgCharList);
	}
	
	@ResponseBody
	@RequestMapping(value="/Read/{emp_no}", method={RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<List<OrgChartEmpVO>> 
			orgChartEmpModelDetailAjax(@PathVariable("emp_no") Integer emp_no) throws Exception{
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
}




  