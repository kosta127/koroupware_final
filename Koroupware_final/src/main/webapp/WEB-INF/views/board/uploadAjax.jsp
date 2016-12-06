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

<style>
.fileDrop{
	width: 100%;
	height: 200px;
	border: 1px dotted blue;
}

small{
	margin-left: 3px;
	font-weight: bold;
	color: gray;
}
</style>
<script>
$(document).ready(function(){
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
				alert(data);
				var str ="";
				  
				if(checkImageType(data)){
					str ="<div><a href=displayFile?fileName="+getImageLink(data)+">"
						 	+"<img src='displayFile?fileName="+data+"'/>"
							+"</a><small data-src="+data+">X</small></div>";
				}else{
			  		str = "<div><a href='displayFile?fileName="+data+"'>" 
							+ getOriginalName(data)+"</a>"
							+"<small data-src="+data+">X</small></div></div>";
				}
				  
				$(".uploadedList").append(str);				
				 
			}
		});
	});
	
	$('.uploadedList').on('click', 'small', function(){
		var that = $(this);//small태그
		
		$.ajax({
			url:'deleteFile',
			type:'post',
			data:{fileName:$(this).attr('data-src')},
			dataType:'text',
			success:function(result){
				if(result=='deleted'){
					that.parent('div').remove();
				}
			}
		});
		
	});
	
	
	function checkImageType(fileName){
			
			var pattern = /jpg|gif|png|jpeg/i;
			
			return fileName.match(pattern);
			
	}
	
	function getOriginalName(fileName){	

		if(checkImageType(fileName)){
			return;
		}
		
		var idx = fileName.indexOf("_") + 1 ;
		return fileName.substr(idx);
		
	}


	function getImageLink(fileName){
		
		if(!checkImageType(fileName)){
			return;
		}
		var front = fileName.substr(0,12);
		var end = fileName.substr(14);
		
		return front + end;
		
	}
});
 	
	
</script>

</head>
<body>
<h3>File upload</h3>
<div class="fileDrop" ></div>

<div class="uploadedList"></div>

</body>
</html>