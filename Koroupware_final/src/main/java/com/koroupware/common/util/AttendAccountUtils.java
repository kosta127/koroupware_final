package com.koroupware.common.util;

import java.util.Calendar;
import java.util.Date;

public class AttendAccountUtils {
	
	public double round(double a, int i) {
		// TODO Auto-generated method stub
		 return Math.round(a * Math.pow(10, i)) / Math.pow(10, i);
	}
	
	
	
	public int dateTotal(int year, int month){
		int total = 0;
		
		int lastDay = (new Date(year, month, 0)).getDate(); // 날짜와 월만 가지고 오면 됨
		
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		switch (month) {
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

		for (int i = 1; i <= lastDay; i++) {
			cal.set(Calendar.DATE, i);
			if (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7) {
				total = total + 0;
			} else {
				total = total + 1;
			}

		}
	
		return total;
		
	}
	

}
