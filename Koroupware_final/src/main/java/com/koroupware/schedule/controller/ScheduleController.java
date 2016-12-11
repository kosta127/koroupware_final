package com.koroupware.schedule.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koroupware.member.dto.EmpDTO;
import com.koroupware.schedule.domain.ScheduleDTO;
import com.koroupware.schedule.domain.ScheduleVO;
import com.koroupware.schedule.service.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Inject
	private ScheduleService service;	
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewGet1(HttpSession session, ScheduleDTO schedule, Model model)throws Exception{
		//, ScheduleVO vo 지웟음 am 07:08
		System.out.println("viewGet1");
		
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		Calendar cal = Calendar.getInstance(); //현재 날짜 가져오기
		
		
		//현재날짜를 기억
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;//month는 0부터 시작이기 때문에 +1
		int currentDay = cal.get(Calendar.DATE);
		
		String year = null;
		String month = null;
		
		String stryear = year;
		String strmonth = month;
	
		if(stryear == null && strmonth == null){
			schedule.setYear(currentYear);
			schedule.setMonth(currentMonth);
		}else{//나타내고자 하는 날짜를 숫자로 변환
			currentYear = Integer.parseInt(stryear);
			currentMonth = Integer.parseInt(strmonth);
			
			if(currentMonth>12){
				currentYear += 1;
				currentMonth = 1;
			}
			if(currentMonth<1){
				currentYear-=1;
				currentMonth=12;
			}
			
			cal.set(currentYear, currentMonth-1, currentDay);
		}
		
		//currentYear년 currentMonth-1월 1일의 어느요일
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1;
		
		cal.set(currentYear, currentMonth-1, 1);//결국 1일이 어느 요일에 시작되는지를 담고있다.
		
		schedule.setStartDay(cal.get(Calendar.DAY_OF_WEEK));//월의 시작요일,현재요일(1:일요일, 7:토요일)
		schedule.setEndDay(cal.getActualMaximum(Calendar.DATE));//월의 마지막 날짜
		
		
		int emp_no = emp.getEmp_no();	
		
		model.addAttribute("emp_no", emp.getEmp_no());
		model.addAttribute("year", (schedule.getYear() + "").substring(2));//현재년도
		model.addAttribute("month", schedule.getMonth());//현재월
		model.addAttribute("startDay", schedule.getStartDay());
		model.addAttribute("endDay", schedule.getEndDay());
		model.addAttribute("currentDay", currentDay);
		//model.addAttribute("schedule_start", vo.getSchedule_start());
		
		ScheduleVO ScheduleVO = new ScheduleVO();
		
		ScheduleVO.setEmp_no(emp_no);
		
		model.addAttribute("list", service.scheduleList(ScheduleVO));
		
		
		/*****/
		System.out.println("+++++++++++++++++++++++++++++++++");
		for(ScheduleVO s : service.scheduleList(ScheduleVO)){
			System.out.println(s);
		}
		System.out.println("+++++++++++++++++++++++++++++++++");

		return "/schedule/view";
	}

	
	@RequestMapping(value="/view", method=RequestMethod.POST)
	public String viewGet(HttpSession session, ScheduleDTO schedule, RedirectAttributes rttr, @PathVariable("schedule_start")Timestamp schedule_start)throws Exception{
		System.out.println("viewGet");
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		Calendar cal = Calendar.getInstance(); //현재 날짜 가져오기
		
		
		//현재날짜를 기억
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;//month는 0부터 시작이기 때문에 +1
		int currentDay = cal.get(Calendar.DATE);
		
		String year = null;
		String month = null;
		
		String stryear = year;
		String strmonth = month;
	
		if(stryear == null && strmonth == null){
			schedule.setYear(currentYear);
			schedule.setMonth(currentMonth);
		}else{//나타내고자 하는 날짜를 숫자로 변환
			currentYear = Integer.parseInt(stryear);
			currentMonth = Integer.parseInt(strmonth);
			
			if(currentMonth>12){
				currentYear += 1;
				currentMonth = 1;
			}
			if(currentMonth<1){
				currentYear-=1;
				currentMonth=12;
			}
			
			cal.set(currentYear, currentMonth-1, currentDay);
		}
		
		//currentYear년 currentMonth-1월 1일의 어느요일
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1;
		
		cal.set(currentYear, currentMonth-1, 1);//결국 1일이 어느 요일에 시작되는지를 담고있다.
		
		schedule.setStartDay(cal.get(Calendar.DAY_OF_WEEK));//월의 시작요일,현재요일(1:일요일, 7:토요일)
		schedule.setEndDay(cal.getActualMaximum(Calendar.DATE));//월의 마지막 날짜
		
		
		int emp_no = emp.getEmp_no();	
		
		ScheduleVO scheduleVO = new ScheduleVO();
		
		scheduleVO.setSchedule_start(schedule_start);
		
		//schedule_start = scheduleVO.getSchedule_start();
		
			
		System.out.println(schedule_start);
		
		rttr.addAttribute("emp_no", emp.getEmp_no());
		rttr.addAttribute("year", (schedule.getYear() + "").substring(2));//현재년도
		rttr.addAttribute("month", schedule.getMonth());//현재월
		rttr.addAttribute("startDay", schedule.getStartDay());
		rttr.addAttribute("endDay", schedule.getEndDay());
		rttr.addAttribute("currentDay", schedule.getDay());
		
		rttr.addAttribute("list", service.scheduleList(scheduleVO));
		
		return "redirect:/schedule/view";
	}
	
	/*@RequestMapping(value="/view", method=RequestMethod.POST)
	public String viewPOST(HttpSession session, @ModelAttribute("schduleDTO") ScheduleDTO schedule, Model model)throws Exception{
		System.out.println(schedule.toString());
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		Calendar cal = Calendar.getInstance(); //현재 날짜 가져오기
		
		
		//현재날짜를 기억
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;//month는 0부터 시작이기 때문에 +1
		int currentDay = cal.get(Calendar.DATE);
		
		String year = null;
		String month = null;
		
		String stryear = year;
		String strmonth = month;
	
		if(stryear == null && strmonth == null){
			schedule.setYear(currentYear);
			schedule.setMonth(currentMonth);
		}else{//나타내고자 하는 날짜를 숫자로 변환
			currentYear = Integer.parseInt(stryear);
			currentMonth = Integer.parseInt(strmonth);
			
			if(currentMonth>12){
				currentYear += 1;
				currentMonth = 1;
			}
			if(currentMonth<1){
				currentYear-=1;
				currentMonth=12;
			}
			
			cal.set(currentYear, currentMonth-1, currentDay);
		}
		
		//currentYear년 currentMonth-1월 1일의 어느요일
		currentYear=cal.get(Calendar.YEAR);
		currentMonth=cal.get(Calendar.MONTH)+1;
		
		cal.set(currentYear, currentMonth-1, 1);//결국 1일이 어느 요일에 시작되는지를 담고있다.
		
		schedule.setStartDay(cal.get(Calendar.DAY_OF_WEEK));//월의 시작요일,현재요일(1:일요일, 7:토요일)
		schedule.setEndDay(cal.getActualMaximum(Calendar.DATE));//월의 마지막 날짜
		
		ScheduleVO schedulevo = new ScheduleVO();
		
		Timestamp schedule_start = schedulevo.getSchedule_start();
		System.out.println(schedule_start);
		
		schedule.setYear(schedule.getYear());
		schedule.setMonth(schedule.getMonth());
		schedule.setDay(schedule.getDay());
		schedule.setStartDay(schedule.getStartDay());
		schedule.setEndDay(schedule.getEndDay());
		
		model.addAttribute("emp_no", emp.getEmp_no());
		model.addAttribute("year", schedule.getYear());//현재년도
		model.addAttribute("month", schedule.getMonth());//현재월
		model.addAttribute("startDay", schedule.getStartDay());
		model.addAttribute("endDay", schedule.getEndDay());
		model.addAttribute("day", schedule.getDay());
		model.addAttribute("list", service.scheduleList(schedule_start));
		
		return "view";
	}*/
	
	@RequestMapping(value="/regist/{year}/{month}/{day}", method=RequestMethod.GET)
	public String registGET(HttpSession session, @PathVariable int year, @PathVariable int month, 
							@PathVariable int day, Model model)throws Exception{
		System.out.println("registGET");
		EmpDTO emp = (EmpDTO)session.getAttribute("login");
		
		ScheduleVO scheduleVO = new ScheduleVO();
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("emp_no", emp.getEmp_no());
		
		return "/schedule/regist";
	}
	
	@RequestMapping(value="/regist/{year}/{month}/{day}",  method = RequestMethod.POST)
	public String registPOST(HttpSession session, ScheduleVO schedule, Model model,
			@PathVariable int year, @PathVariable int month, @PathVariable int day, RedirectAttributes rttr)throws Exception{
		System.out.println("postregist");
		System.out.println("schedule tostring"+schedule.toString());
		EmpDTO emp = (EmpDTO)session.getAttribute("login");

	
		schedule.setSchedule_start(new Timestamp(year, month - 1, day,0,0,0,0));
		
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		String date = format.format(schedule.getSchedule_start());
		
		System.out.println(4444);
		System.out.println(date);
		schedule.setEmp_no(emp.getEmp_no());
		
		
		
		service.scheduleRegist(schedule);
		
		rttr.addAttribute("year", year);
		rttr.addAttribute("month", month);
		rttr.addAttribute("day", day);
		rttr.addAttribute("schedule_start", date);
		
		return "redirect:/schedule/view";
	}

}
