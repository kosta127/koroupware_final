<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- printTool -->
<script src="/resources/printTool/jQuery.print.js"></script>
<script type="text/javascript">

function monthDown(){
	var setYear = $("#setYear").text();//2016
	var setMonth = $("#setMonth").text();//12
	
	//���ڷ� ��ȯ
	var numYear = parseInt(setYear, 10);
	var numMonth = parseInt(setMonth, 10);
	
	numMonth--;
	
	if(numMonth<1){
		numYear-=1;
		numMonth=12;
	}
	
	$("#setYear").text(numYear);
	$("#setMonth").text(numMonth);
	
	var startDay = ${startDay};//12���� ���ۿ���
	var endDay = ${endDay};//12���� ����
	
	var numStart = parseInt(startDay, 10);
	

	
	var day = $("#day").text();
	var numDay = parseInt(day, 10);
	
	for(var i=1;i<endDay;i++){
		if((startDay-2+i)%7==0){
			i++;
			$("#day").text(i);
		}else if((startDay-1+i)%7==0){
			i++;
			$("#day").text(i);
		}else{
			i++;
			$("#day").text(i);
		}
	}
	 
}
function monthUp(){
	var setYear = $("#setYear").text();//2016
	var setMonth = $("#setMonth").text();//12
	
	var numYear = parseInt(setYear, 10);
	var numMonth = parseInt(setMonth, 10);
	
	numMonth++;
	
	if(numMonth>12){
		numYear+=1;
		numMonth=1;
	}
	$("#setYear").text(numYear);
	$("#setMonth").text(numMonth);
}

</script>
<style type="text/css">
.day{
	font-size: 22px;
}
.cal-table{
  box-shadow: 2px 2px 2px 2px lightgray; 
}
td{
	vertical-align: top;
}
#setYear, #setMonth{
	font-size: 30px;
}
</style>
</head>
<body>
<!-- �޷»�ܺκ� -->


<form action="view" method="get">
<input type="hidden" name="year">
<input type="hidden" name="month">
<table class="table">
	<tr>
		<td align="center">
			<a onclick="monthDown()">��</a>
				<label id="setYear">${year }</label>��
				<label id="setMonth">${month}</label>��
			<a onclick="monthUp()">��</a>
			
			
		</td>
	</tr>
</table> 

<!-- �޷� �κ� -->


<br>
 
<table class="table table-bordered cal-table ">
		<tr>
			<td width="100" align="center"><font color="red">��</font></td>
			<td width="100" align="center">��</td>
			<td width="100" align="center">ȭ</td>
			<td width="100" align="center">��</td>
			<td width="100" align="center">��</td>
			<td width="100" align="center">��</td>
			<td width="100" align="center"><font color="blue">��</font></td>
			
		</tr>
		
		<!-- �ش� ���� ù° ���� ���� ǥ�� -->
		<tr>
		
		<c:forEach var="day" begin="1" end="${startDay-1 }">
			<td></td>
		</c:forEach>
		
		<!-- 1~�ش���� ��������¥ -->
		<c:forEach var="day" begin="1" end="${endDay }">			
				<c:choose>
					<c:when test="${(startDay-2+day)%7==0}"><!-- �Ͽ��� -->
						<td align="right">
							<a href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>
								<font color="red" class="day">${day }</font>
							</a>	<br>
							<c:set var="time" value="${year}/${month}/${day}"></c:set>
							
							<c:forEach items="${list }" var="scheduleVO">								
								<c:set var="temp_day" value="${fn:substring(scheduleVO.schedule_start_String, 6, 8)}"></c:set>
								<c:choose>
									<c:when test="${fn:startsWith(temp_day, '0') }">
										<c:set var="zero_removed_day" value="${fn:substring(temp_day, 1, 2)}"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="zero_removed_day" value="${temp_day}"></c:set>
									</c:otherwise>
								</c:choose>
								<c:set var="for_compare_time" value="${year}/${month}/${zero_removed_day}"></c:set>
								<c:if test="${for_compare_time == time}">
									<a href="detail/${year}/${month}/${day}/${scheduleVO.schedule_no}" id="schedule">����:${scheduleVO.schedule_title }</a><br>
								</c:if>
							</c:forEach>
						</td>
					</c:when>
					<c:when test="${(startDay-1+day)%7==0}">
						<td align="right">
							<a href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>
								<font color="blue" class="day">${day }</font>
							</a><br>
							<c:set var="time" value="${year}/${month}/${day}"></c:set>
							<c:forEach items="${list }" var="scheduleVO">
								<c:set var="temp_day" value="${fn:substring(scheduleVO.schedule_start_String, 6, 8)}"></c:set>
								<c:choose>
									<c:when test="${fn:startsWith(temp_day, '0') }">
										<c:set var="zero_removed_day" value="${fn:substring(temp_day, 1, 2)}"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="zero_removed_day" value="${temp_day}"></c:set>
									</c:otherwise>
								</c:choose>
								<c:set var="for_compare_time" value="${year}/${month}/${zero_removed_day}"></c:set>
								<c:if test="${for_compare_time == time}">
									<a href="detail/${year}/${month}/${day}/${scheduleVO.schedule_no}" id="schedule">����:${scheduleVO.schedule_title }</a><br>
								</c:if>
							</c:forEach>
						</td>
					</c:when>
					<c:otherwise>
						<td align="right" >
							<a class="day" href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>${day }</a><br>
							<c:set var="time" value="${year}/${month}/${day}"></c:set>
							${scheduleVO.schedule_start }
							<c:forEach items="${list }" var="scheduleVO">
								<c:set var="temp_day" value="${fn:substring(scheduleVO.schedule_start_String, 6, 8)}"></c:set>
								<c:choose>
									<c:when test="${fn:startsWith(temp_day, '0') }">
										<c:set var="zero_removed_day" value="${fn:substring(temp_day, 1, 2)}"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="zero_removed_day" value="${temp_day}"></c:set>
									</c:otherwise>
								</c:choose>
								<c:set var="for_compare_time" value="${year}/${month}/${zero_removed_day}"></c:set>
								<c:if test="${for_compare_time == time}">
									<a href="detail/${year}/${month}/${day}/${scheduleVO.schedule_no}" id="schedule">����:${scheduleVO.schedule_title }</a><br>
								</c:if>
							</c:forEach>
						</td>	
					</c:otherwise>
				</c:choose>	
				<c:if test="${(startDay-1+day)%7==0}">
					</tr><tr>
				</c:if>			
		</c:forEach>
		
		</tr>
		
</table> 
</form>
</body>
