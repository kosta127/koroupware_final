package com.koroupware.estimate.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.common.util.AttendAccountUtils;
import com.koroupware.estimate.domain.EstimateVO;
import com.koroupware.estimate.domain.ResultVO;
import com.koroupware.estimate.dto.ResultDTO;
import com.koroupware.estimate.service.EstimateService;
import com.koroupware.member.dto.EmpDTO;

@Controller
@RequestMapping("/estimate/*")
public class EstimateController {

	@Inject
	private EstimateService service;

	@RequestMapping(value = "/est_do", method = RequestMethod.GET)
	public String est_start() {
		return "/estimate/est_start";

	}

	@RequestMapping(value = "/lateCount", method = RequestMethod.POST)
	public String lateCount(AttendVO attendVO, Model model, EstimateVO estimateVO, ResultVO resultVO) throws Exception {
		int dept_no =0;//부서
		if(estimateVO.getKeyField().equals("dept_1")){
				dept_no=1;
			}else if(estimateVO.getKeyField().equals("dept_2")){
				dept_no=2;
			}else if(estimateVO.getKeyField().equals("dept_3")){
				dept_no=3;
			}else if(estimateVO.getKeyField().equals("dept_4")){
				dept_no=4;
			}else{
				dept_no=5;
			}
		
		AttendAccountUtils totalResult = new AttendAccountUtils();
		
		List<EmpDTO> attendDept_EmpList = service.attendDept_EmpList(dept_no);
		List<ResultVO> AttendQuaterList = service.AttendQuaterList();
		System.out.println(AttendQuaterList);


		int emp_count = service.empCount(dept_no); // 해당 부서에 인원 수 파악	
		
		int year = 2016;
		int resultTotal =0;
		double account =0; // 총일수, 출석 수 계산
		double first_quater =0; // account를 3으로 나누어 분기 설정
		double secont_quater =0;
		double third_quater=0;
		double forth_quater=0;
		double final_quater=0;
		double future_quater=0;
		
		
		for(int x=0; x<AttendQuaterList.size(); x++){
			if((AttendQuaterList.get(x).getEmp_no()!=attendDept_EmpList.get(x).getEmp_no()&&AttendQuaterList.get(x).getResult_year()!=year)
					|| (AttendQuaterList.size()==0)){
				
				for(int k= 0; k<emp_count; k++){
					attendVO.setEmp_no(attendDept_EmpList.get(k).getEmp_no());
					System.out.println("사원 번호 : "+ attendDept_EmpList.get(k).getEmp_no());
					
					//1분기
					for(int i=1; i<=3; i++){
					System.out.println(attendDept_EmpList.get(k).getEmp_no());
					attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

					int count = service.attendCount(attendVO);
					
					resultTotal = totalResult.dateTotal(year, i);
					System.out.println((double)count);
					System.out.println((double)resultTotal);
					double a = (double)count/ (double)resultTotal;
					
					// 1분기 계산
					account = totalResult.round(a,3)*100;
					System.out.println(i+"월  확률 :" + account);
					
					first_quater= first_quater + account;	
					System.out.println("현재 가지고 있는 분기 점수 : "+ first_quater);
				}
				

				//2분기
				for(int i=4; i<=6; i++){
					attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

					int count = service.attendCount(attendVO);
					
					resultTotal = totalResult.dateTotal(year, i);
					double a = (double)count/ (double)resultTotal;
					
					// 1분기 계산
					account = totalResult.round(a,3)*100;
					secont_quater= secont_quater + account;
					System.out.println(i+"월  확률 :" + account);
				}

				
				//3분기
				for(int i=7; i<=9; i++){
					attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

					int count = service.attendCount(attendVO);
					
					resultTotal = totalResult.dateTotal(year, i);
					double a = (double)count/ (double)resultTotal;
					
					// 1분기 계산
					account = totalResult.round(a,3)*100;
					third_quater= third_quater + account;
					System.out.println(i+"월  확률 :" + account);
				}

				//4분기
				for(int i=10; i<=12; i++){
					attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

					int count = service.attendCount(attendVO);
					
					resultTotal = totalResult.dateTotal(year, i);
					double a = (double)count/ (double)resultTotal;
					
					// 1분기 계산
					account = totalResult.round(a,3)*100;
					forth_quater= forth_quater + account;
				}
				
				future_quater = (((first_quater/3)-(secont_quater/3))+((secont_quater/3)-(third_quater/3))+((third_quater/3)-(forth_quater/3)))/3;
				final_quater = ((first_quater/3)+(secont_quater/3)+(third_quater/3)+(forth_quater/3))/4;
				future_quater = final_quater+ future_quater;

				resultVO.setQuarterfirst(first_quater/3);
				resultVO.setQuartersecond(secont_quater/3);
				resultVO.setQuarterthird(third_quater/3);

				resultVO.setQuarterforth(forth_quater/3);
				resultVO.setFinalquarter(final_quater);
				resultVO.setFuture_quater(future_quater);
				resultVO.setEmp_no(attendDept_EmpList.get(x).getEmp_no());
				resultVO.setResult_year(year);
				service.insertAttendQuater(resultVO);
				
				
				first_quater=0;
				secont_quater=0;
				third_quater=0;
				forth_quater=0;
				final_quater=0;
				future_quater=0;
				}
				
		
			}else{
				return "redirect:/estimate/estimate_output";
			}
	}
		
		for(int k= 0; k<emp_count; k++){
			attendVO.setEmp_no(attendDept_EmpList.get(k).getEmp_no());
			
			//1분기
			for(int i=1; i<=3; i++){
			attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

			int count = service.attendCount(attendVO);
			
			resultTotal = totalResult.dateTotal(year, i);
			System.out.println((double)count);
			System.out.println((double)resultTotal);
			double a = (double)count/ (double)resultTotal;
			
			// 1분기 계산
			account = totalResult.round(a,3)*100;
			
			first_quater= first_quater + account;	
		}
		

		//2분기
		for(int i=4; i<=6; i++){
			attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

			int count = service.attendCount(attendVO);
			
			resultTotal = totalResult.dateTotal(year, i);
			double a = (double)count/ (double)resultTotal;
			
			// 1분기 계산
			account = totalResult.round(a,3)*100;
			secont_quater= secont_quater + account;
		}

		
		//3분기
		for(int i=7; i<=9; i++){
			attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

			int count = service.attendCount(attendVO);
			
			resultTotal = totalResult.dateTotal(year, i);
			double a = (double)count/ (double)resultTotal;
			
			// 1분기 계산
			account = totalResult.round(a,3)*100;
			third_quater= third_quater + account;
		}

		//4분기
		for(int i=10; i<=12; i++){
			attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

			int count = service.attendCount(attendVO);
			
			resultTotal = totalResult.dateTotal(year, i);
			double a = (double)count/ (double)resultTotal;
			
			// 1분기 계산
			account = totalResult.round(a,3)*100;
			forth_quater= forth_quater + account;
		}

		future_quater = (((first_quater/3)-(secont_quater/3))+((secont_quater/3)-(third_quater/3))+((third_quater/3)-(forth_quater/3)))/3;
		final_quater = ((first_quater/3)+(secont_quater/3)+(third_quater/3)+(forth_quater/3))/4;
		future_quater = final_quater+ future_quater;
		
		first_quater=0;
		secont_quater=0;
		third_quater=0;
		forth_quater=0;
		final_quater=0;
		future_quater=0;
		}

		return "redirect:/estimate/estimate_output";
	}

	@RequestMapping(value = "/attendCount", method = RequestMethod.POST)
	public String attendCount(AttendVO attendVO, Model model, EstimateVO estimateVO) throws Exception {
		int dept_no = 0;// 부서
		if (estimateVO.getKeyField().equals("dept_1")) {
			dept_no = 1;
		} else if (estimateVO.getKeyField().equals("dept_2")) {
			dept_no = 2;
		} else if (estimateVO.getKeyField().equals("dept_3")) {
			dept_no = 3;
		} else if (estimateVO.getKeyField().equals("dept_4")) {
			dept_no = 4;
		} else {
			dept_no = 5;
		}

		AttendAccountUtils totalResult = new AttendAccountUtils();
		ResultVO resultVO = new ResultVO();
		List<EmpDTO> attendDept_EmpList = service.attendDept_EmpList(dept_no);
		List<ResultVO> AttendQuaterList = service.AttendQuaterList();
		System.out.println(AttendQuaterList);

		int emp_count = service.empCount(dept_no); // 해당 부서에 인원 수 파악

		int year = 2016;
		int resultTotal = 0;
		double account = 0; // 총일수, 출석 수 계산
		double first_quater = 0; // account를 3으로 나누어 분기 설정
		double secont_quater = 0;
		double third_quater = 0;
		double forth_quater = 0;
		double final_quater = 0;
		double future_quater = 0;

		for (int k = 0; k < emp_count; k++) {
			attendVO.setEmp_no(attendDept_EmpList.get(k).getEmp_no());

			// 1분기
			for (int i = 1; i <= 3; i++) {
				attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

				int count = service.attendCount(attendVO);

				resultTotal = totalResult.dateTotal(year, i);
				double a = (double) count / (double) resultTotal;

				// 1분기 계산
				account = totalResult.round(a, 3) * 100;

				first_quater = first_quater + account;
			}

			// 2분기
			for (int i = 4; i <= 6; i++) {
				attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

				int count = service.attendCount(attendVO);

				resultTotal = totalResult.dateTotal(year, i);
				double a = (double) count / (double) resultTotal;

				// 1분기 계산
				account = totalResult.round(a, 3) * 100;
				secont_quater = secont_quater + account;
			}

			// 3분기
			for (int i = 7; i <= 9; i++) {
				attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

				int count = service.attendCount(attendVO);

				resultTotal = totalResult.dateTotal(year, i);
				double a = (double) count / (double) resultTotal;

				// 1분기 계산
				account = totalResult.round(a, 3) * 100;
				third_quater = third_quater + account;
			}

			// 4분기
			for (int i = 10; i <= 12; i++) {
				attendVO.count(attendDept_EmpList.get(k).getEmp_no(), year, i);

				int count = service.attendCount(attendVO);

				resultTotal = totalResult.dateTotal(year, i);
				double a = (double) count / (double) resultTotal;

				// 1분기 계산
				account = totalResult.round(a, 3) * 100;
				forth_quater = forth_quater + account;
			}
			
			future_quater = (((first_quater / 3) - (secont_quater / 3)) + ((secont_quater / 3) - (third_quater / 3))
					+ ((third_quater / 3) - (forth_quater / 3))) / 3;
			final_quater = ((first_quater / 3) + (secont_quater / 3) + (third_quater / 3) + (forth_quater / 3)) / 4;
			future_quater = final_quater + future_quater;

			if (AttendQuaterList.size() == 0) {
				resultVO.setQuarterfirst(first_quater / 3);
				resultVO.setQuartersecond(secont_quater / 3);
				resultVO.setQuarterthird(third_quater / 3);
				
				resultVO.setQuarterforth(forth_quater / 3);
				resultVO.setFinalquarter(final_quater);
				resultVO.setFuture_quater(future_quater);
				resultVO.setEmp_no(attendDept_EmpList.get(k).getEmp_no());
				resultVO.setResult_year(year);
				service.insertAttendQuater(resultVO);
			} else {
				for (int x = 0; x < AttendQuaterList.size(); x++) {
					if ((AttendQuaterList.get(x).getEmp_no() != attendDept_EmpList.get(k).getEmp_no()
							&& AttendQuaterList.get(x).getResult_year() != year)) {
						resultVO.setQuarterfirst(first_quater / 3);
						resultVO.setQuartersecond(secont_quater / 3);
						resultVO.setQuarterthird(third_quater / 3);

						resultVO.setQuarterforth(forth_quater / 3);
						resultVO.setFinalquarter(final_quater);
						resultVO.setFuture_quater(future_quater);
						resultVO.setEmp_no(attendDept_EmpList.get(k).getEmp_no());
						resultVO.setResult_year(year);
						service.insertAttendQuater(resultVO);
					} else {
						//System.out.println("이미 넣었음");
					}
				}

			}
			first_quater = 0;
			secont_quater = 0;
			third_quater = 0;
			forth_quater = 0;
			final_quater = 0;
			future_quater = 0;
		}
		return "redirect:/estimate/estimate_output";
	}

	@RequestMapping(value = "/estimate_output", method = RequestMethod.GET)
	public String output_estimate(Model model) throws Exception {
		List<ResultDTO> AttendQuaterList = service.AttendQuaterDTOList();
		/*
		for (int i = 0; i < AttendQuaterList.size(); i++) {
			System.out.println("예측값 출력 : " + AttendQuaterList.get(i).getFuture_quater());
		}
		*/
		model.addAttribute("list", AttendQuaterList);
		return "/estimate/attend_est_table";
	}

	@RequestMapping(value = "/graph/graph_result")
	public @ResponseBody List<ResultDTO> resultGraph(Model model) throws Exception {
		List<ResultDTO> AttendQuaterList = service.AttendQuaterDTOList();
		return AttendQuaterList;
	}
}
