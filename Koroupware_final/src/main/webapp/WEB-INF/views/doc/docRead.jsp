<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/resources/js/upload.js"></script>

<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
	<span class="mailbox-attachmen-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
	<div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a></span>
	</div>
</li>                
</script>
<script type="text/javascript">
	var doc_no = ${doc_no}
	var template = Handlebars.compile($("#templateAttach").html());
	
	$.getJSON("/doc/getAttach/"+doc_no,function(list){
		$(list).each(function(){
			var fileInfo = getFileInfo(this);
			
			var html = template(fileInfo);
			
			$(".uploadedList").append(html);
		});
	});
</script>

<script type="text/javascript">

	$(document).ready(function(){
		
		$(".uploadedList").on("click","li",function(event){
			
			var fileName = $(this).attr("data-src");
		
			$.ajax({
				url: "/doc/loadFile",
				dataType: "text",
				data: {fileName:fileName},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function(data){
					var decode = decodeURIComponent(data);
					var div = $("<div style='overflow:scroll;' class='test'></div>");
					div.html(decode).appendTo(".uploadedList");
				}
				
			})

			
	});
		
		$(".uploadedList").on("click",".test", function(){
			$(this).remove();
		});
	});
</script>
<script type="text/javascript">
function fn_back(){
	history.back(-1);
}
</script>
<title>Insert title here</title>

</head>
<body>
	
		
			<table border="1"  class="table table-hover">
		<tr height="30">
			<th>문서제목</th>
			<td>${doc.doc_title }</td>
		</tr>
		<tr height="30">
			<th>작성자</th>
			<td>${emp_name }</td>
		</tr>
		
		<tr height="30">
			<th>문서설명</th>
			<td>${doc.doc_explain }</td>
		</tr>
		<tr height="30">
			<th>문서내용</th>
			<td>${doc.doc_contents }</td>
		</tr>
	</table>
	<label>첨부 파일</label>
	<ul class="uploadedList"></ul>
	<form action="/doc/docUpdate/${doc_no}/${doc_box_no}/${emp_no}" method="get">
		<input type="submit" value="수정하기" class="btn btn-default">
		<input type="button" value="돌아가기" class="btn btn-default" onclick="fn_back()">
	</form>
	
	
</body>
</html>