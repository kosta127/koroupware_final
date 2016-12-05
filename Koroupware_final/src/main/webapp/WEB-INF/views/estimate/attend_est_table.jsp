<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	$.ajax({
		url : "/estimate/graph/graph_result",
		dataType : "json",
		type : 'post',
		success : graph
	});

	var quarter = new Array();
	var emps = new Array();
	function graph(data) {
		console.log(data)
		for(var i=0; i<5; i++){
			var innerArray = new Array(data.length+1)
			//innerArray[0] = ((i==0)?"":i)+'분기';
			innerArray[0] = i+1;
			quarter.push(innerArray);
		}
		
		for(var i=0; i<data.length; i++){
			var no = i+1;
			emps.push(data[i].emp_name);
			quarter[0][no] = data[i].quarterfirst;
			quarter[1][no] = data[i].quartersecond;
			quarter[2][no] = data[i].quarterthird;
			quarter[3][no] = data[i].quarterforth;
			quarter[4][no] = data[i].future_quater;
		}
		console.log(quarter);
	}

	google.charts.load('current', {'packages':['line']});
	google.charts.setOnLoadCallback(drawChart);

   function drawChart() {
     var data = new google.visualization.DataTable();
     data.addColumn('number', '분기 (5 : 2017년 1분기 예상결과)');
     for(var i = 0; i<emps.length; i++){
    	 data.addColumn('number', emps[i]);
     }
     data.addRows(quarter);

     var options = {
       chart: {
         title: '출석률',
         subtitle: '사원'
       },
       width: 900,
       height: 500,
       axes: {
         x: {
           0: {side: 'top'}
         }
       }
     };

     var chart = new google.charts.Line(document.getElementById('line_top_x'));
     chart.draw(data, options);
   }
})
</script>
</head>
<body>
<div id="line_top_x"></div>
<h1>결과</h1>
	<table border="1px">
		<tr>
			<td>회원 번호</td>
			<td>회원 이름</td>
			<td>1분기</td>
			<td>2분기</td>
			<td>3분기</td>
			<td>4분기</td>
			<td>올해 최종 평균</td>
			<td>내년 예상 실적</td>
		</tr>
		<c:forEach items="${list}" var="List">
			<tr>
			
				<td>${List.emp_no}</td>
				<td>${List.emp_name }</td>
				<td>${List.quarterfirst}</td>
				<td>${List.quartersecond}</td>			
				<td>${List.quarterthird}</td>
				<td>${List.quarterforth}</td>	
				<td>${List.finalquarter}</td>
				<td>${List.future_quater} </td>		
			</tr>
		</c:forEach>
		
		</table>
</body>
</html>