package com.koroupware.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

public class ETC {
	public static boolean isNotNull(Object object){
		//null값이 아닌지 확인
		if(object == null){
			return false;
		}
		
		return true;
	}
	
	public static String toTelephoneFormat(String telephone){
		//전화번호 양식으로 포맷
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		
		if(Pattern.matches(regEx, telephone)){
			if(telephone.length() == 10 && telephone.startsWith("02")){
				telephone = telephone.replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-$2-$3");
			}else{
				telephone = telephone.replaceAll(regEx, "$1-$2-$3");
			}
		}
		
		return telephone;
	}
}
