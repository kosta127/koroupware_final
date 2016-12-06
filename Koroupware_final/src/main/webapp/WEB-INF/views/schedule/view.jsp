<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<!-- <script type="text/javascript">

function monthDown(){
	var setYear = $("#setYear").text();//2016
	var setMonth = $("#setMonth").text();//12
	
	//숫자로 변환
	var numYear = parseInt(setYear, 10);
	var numMonth = parseInt(setMonth, 10);
	
	numMonth--;
	
	if(numMonth<1){
		numYear-=1;
		numMonth=12;
	}
	
	$("#setYear").text(numYear);
	$("#setMonth").text(numMonth);
	
	var startDay = ${startDay};//12월의 시작요일
	var endDay = ${endDay};//12월의 끝날
	
	var numStart = parseInt(startDay, 10);
	numStart = 
	

	alert(numStart);
	
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

</script> -->

</head>
<body>
<!-- 달력상단부분 -->
<h1>${emp_no}</h1>
<h1>${startDay }</h1>
<h1>${endDay }</h1>
<h1>${year }</h1>
<h1>${month }</h1>
<h1>${schedule_start }</h1>


<form action="view" method="get">
<input type="hidden" name="year">
<input type="hidden" name="month">
<table>
	<tr>
		<td align="center">
			<a onclick="monthDown()">◀</a>
				<label id="setYear">${year }</label>년
				<label id="setMonth">${month}</label>월 
			<a onclick="monthUp()">▶</a>
		</td>
	</tr>
</table> 

<!-- 달력 부분 -->


<br>

<table border="1">
		<tr>
			<td width="100" align="center"><font color="red">일</font></td>
			<td width="100" align="center">월</td>
			<td width="100" align="center">화</td>
			<td width="100" align="center">수</td>
			<td width="100" align="center">목</td>
			<td width="100" align="center">금</td>
			<td width="100" align="center"><font color="blue">토</font></td>
		</tr>
		<!-- 해당 월의 첫째 줄의 공백 표시 -->
		<tr>
		
		<c:forEach var="day" begin="1" end="${startDay-1 }">
			<td></td>
		</c:forEach>
		
		<c:forEach var="day" begin="1" end="${endDay }">			
				<c:choose>
					<c:when test="${(startDay-2+day)%7==0}">
						<td align="right">
							<a href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>
								<font color="red" id="day">${day }</font>
							</a>	<br>
							<c:forEach items="${list }" var="scheduleVO">
								<input type="hidden" name="schedule_start" value="${schedule_start }">
									<c:if test="${schedule_start ==day}">
										<a href="#" id="schedule">제목:${scheduleVO.schedule_title }</a>
									</c:if>
							</c:forEach>
						</td>
					</c:when>
					<c:when test="${(startDay-1+day)%7==0}">
						<td align="right">
							<a href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>
								<font color="blue" id="day">${day }</font>
							</a><br>
							<c:forEach items="${list }" var="scheduleVO">
								<input type="hidden" name="schedule_start" value="${scheduleVO.schedule_start }">
									<a href="#" id="schedule">제목:${scheduleVO.schedule_title }</a>		
							</c:forEach> 
						</td>
					</c:when>
					<c:otherwise>
						<td align="right" id="day">
							<a href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>${day }</a><br>
							<c:forEach items="${list }" var="scheduleVO">
								<input type="hidden" name="schedule_start" value="${scheduleVO.schedule_start }">
									<a href="#" id="schedule">제목:${scheduleVO.schedule_title }</a>
								
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
</html>