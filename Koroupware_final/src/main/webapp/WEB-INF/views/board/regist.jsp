<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
	
<!-- 사용자 js -->  
<script type="text/javascript">
	$(function(){
		CKEDITOR.replace("board_contents");
	});
</script>

<script type="text/javascript">
	function cancel(){
		location.href="list";
	}
</script>
<script id="template" type="text/x-handlebars-template">
<li>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	<a href="{{fullName}}" 
     class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove">X</i></a>
	</span>
  </div>
</li>                
</script>
<script>

$(document).ready(function(){
	
	var template = Handlebars.compile($("#template").html());
	
	$(".fileDrop").on("dragenter dragover", function(event){
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		var file = files[0];
		
		//console.log(file);
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url:'uploadAjax',
			data:formData,
			dataType:'text',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data){
				var fileInfo = getFileInfo(data);
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			}
		});
	});
	$("#registerForm").submit(
			function(event) {
				event.preventDefault();

				var that = $(this);

				var str = "";
				$(".uploadedList .delbtn").each(
						function(index) {
							str += "<input type='hidden' name='files[" + index
									+ "]' value='" + $(this).attr("href")
									+ "'> ";
						});

				that.append(str);

				that.get(0).submit();
			}); 
	$(".uploadedList").on("click", ".delbtn", function(event){
		
		event.preventDefault();
		
		var that = $(this);
		 
		$.ajax({
		   url:"deleteFile",
		   type:"post",
		   data: {fileName:$(this).attr("href")},
		   dataType:"text",
		   success:function(result){
			   if(result == 'deleted'){
				   that.closest("li").remove();
			   }
		   }
	   });
	});
});
 	
	
</script>
<style type="text/css">
.fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: lightslategrey;
	margin: auto;
}
</style>
</head>
<body>

<form action="regist" method="post">
	<input type="hidden" value="${category_no }" name="category_no" id="category_no"/>
	<table>
		<tr>
			<td width="70" align="center">작성자</td>
			<td>
				<input type="hidden" value="${emp_no}" name="emp_no">
				${emp_name}
			</td>
		</tr>
		<tr>
			<td width="70" align="center">제목</td>
			<td><input type="text" name="board_title" id="board_title"></td>
		</tr>
		<tr>
			<td></td>
			<td><textarea rows="10" cols="5" name="board_contents" id="board_contents"></textarea> </td>
		</tr>
	</table>
	
	
	<div class="form-group">
		<label for="exampleInputEmail">File Drop Here</label>
		<div class="fileDrop"></div>
	</div>

	<div class="box-footer">
		<div>
			<hr>
		</div>
		
		<ul id="file" class="mailbox-attachments clearfix uploadedList"></ul>
		
		<button id="create" type="submit" class="btn btn-primary">등록</button>
		<button type="submit" class="btn btn-primary" onclick="cancel()">취소</button>
	</div>
</form>


</body>
</html>