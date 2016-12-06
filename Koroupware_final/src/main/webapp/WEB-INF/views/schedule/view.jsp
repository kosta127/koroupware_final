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
<!-- �޷»�ܺκ� -->
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
			<a onclick="monthDown()">��</a>
				<label id="setYear">${year }</label>��
				<label id="setMonth">${month}</label>�� 
			<a onclick="monthUp()">��</a>
		</td>
	</tr>
</table> 

<!-- �޷� �κ� -->


<br>

<table border="1">
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
										<a href="#" id="schedule">����:${scheduleVO.schedule_title }</a>
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
									<a href="#" id="schedule">����:${scheduleVO.schedule_title }</a>		
							</c:forEach> 
						</td>
					</c:when>
					<c:otherwise>
						<td align="right" id="day">
							<a href='<c:url value="regist/${year}/${month}/${day}"></c:url>'>${day }</a><br>
							<c:forEach items="${list }" var="scheduleVO">
								<input type="hidden" name="schedule_start" value="${scheduleVO.schedule_start }">
									<a href="#" id="schedule">����:${scheduleVO.schedule_title }</a>
								
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