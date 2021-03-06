package com.koroupware.attend.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koroupware.attend.domain.AttendVO;
import com.koroupware.attend.dto.AttendDTO;
import com.koroupware.attend.service.attendService;



@Controller
@RequestMapping("/attend/*")
public class AttendController {

	@Inject
	private attendService service;

	@RequestMapping(value = "/attendList/{emp_no}", method = RequestMethod.GET)
	public String attendList(@PathVariable("emp_no") int emp_no, AttendVO attendVO, Model model) throws Exception {
		List<AttendDTO> list = service.attendList(emp_no);

		model.addAttribute("attendList", list);
		return "attend/attendCheck";
	}
	
	
	@RequestMapping(value = "/attendStart/{emp_no}", method = RequestMethod.GET)
	// "/attendStart{emp}"
	public @ResponseBody String attendToday(@PathVariable("emp_no") int emp_no, AttendVO attendVO) throws Exception {
		String result = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter01 = new SimpleDateFormat("dd");
		SimpleDateFormat formatter02 = new SimpleDateFormat("MM");
		SimpleDateFormat formatter03 = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatter04 = new SimpleDateFormat("yy/MM/dd");

		SimpleDateFormat formatter05 = new SimpleDateFormat("HH"); // 현재 시간
		SimpleDateFormat formatter06 = new SimpleDateFormat("mm"); // 현재 분

		String todate01 = formatter01.format(new Date());
		String todate02 = formatter02.format(new Date());
		String todate03 = formatter03.format(new Date());
		String todate04 = formatter04.format(new Date());

		String todayHour = formatter05.format(new Date());
		String todayMinute = formatter06.format(new Date());
		cal.set(Calendar.YEAR, Integer.parseInt(todate03));
		switch (Integer.parseInt(todate02)) {
		case 1:
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			break;
		case 2:
			cal.set(Calendar.MONTH, Calendar.FEBRUARY);
			break;
		case 3:
			cal.set(Calendar.MONTH, Calendar.MARCH);
			break;
		case 4:
			cal.set(Calendar.MONTH, Calendar.APRIL);
			break;
		case 5:
			cal.set(Calendar.MONTH, Calendar.MAY);
			break;
		case 6:
			cal.set(Calendar.MONTH, Calendar.JUNE);
			break;
		case 7:
			cal.set(Calendar.MONTH, Calendar.JULY);
			break;
		case 8:
			cal.set(Calendar.MONTH, Calendar.AUGUST);
			break;
		case 9:
			cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
			break;
		case 10:
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
			break;
		case 11:
			cal.set(Calendar.MONTH, Calendar.NOVEMBER);
			break;
		case 12:
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
			break;

		}
		cal.set(Calendar.DATE, Integer.parseInt(todate01));

		attendVO.setEmp_no(emp_no);
		attendVO.setAttend_date(todate04);

		AttendVO vo = service.attendCheck(attendVO);
		if (vo == null) {
			if (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7) {
			} else {
				if (Integer.parseInt(todayHour) >= 9 && Integer.parseInt(todayMinute) > 0) {
					attendVO.setLate(1);
					service.addAttend(attendVO);
					result = "late";
				} else {
					attendVO.setLate(0);
					service.addAttend(attendVO);
					result = "attend";
				}
				return result;

			}
		} else {
			result = "already";
		}

		return result;

	}
	
}
