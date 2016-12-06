<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
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
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script id="template" type="text/x-handlebars-template">
<li>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	<a href="{{fullName}}" 
     class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
	</span>
  </div>
</li>                
</script>    
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>


<script type="text/javascript">
	$(document).ready(function(){
	
		var template = Handlebars.compile($("#template").html());

		$(".fileDrop").on("dragenter dragover", function(event){
			event.preventDefault();
		});


		$(".fileDrop").on("drop", function(event){
			event.preventDefault();
			
			var files = event.originalEvent.dataTransfer.files;
			
			var file = files[0];

			var formData = new FormData();
			
			formData.append("file", file);	
			
			
			$.ajax({
				  url: '/uploadAjax',
				  data: formData,
				  dataType:'text',
				  processData: false,
				  contentType: false,
				  type: 'POST',
				  success: function(data){
					  console.log(data);
					  var fileInfo = getFileInfo(data);
					  
					  var html = template(fileInfo);
					  
					  $(".uploadedList").append(html);
				  }
				});	
		});


		$("#registerForm").submit(function(event){
			event.preventDefault();
			
			var that = $(this);
			
			var str ="";
			$(".uploadedList .delbtn").each(function(index){
				 str += "<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href") +"'> ";
			});
			
			that.append(str);

			that.get(0).submit();
		});
		
		$(".uploadedList").on("click",".delbtn", function(event){
			event.preventDefault();
			var that = $(this);
			var fileName = $(this).attr("href");
	
			$.ajax({
				url:"/deleteFile",
				type:"post",
				data:{fileName:fileName},
				dataType:"text",
				success: function(result){
					if(result=='deleted'){
						that.parent("div").parent("li").remove();
						
						
					}
				}
			});
			
			
		});
		
		
	});
	
	function fn_back(){
		history.back(-1);
	}
</script>
<style>
	.fileDrop{
		width: 80%;
		height: 100px;
		border: 1px dotted gray;
		background-color: lightslategrey;
		margin: auto;
	}
	.text {
		margin-left: 150px;
	}
	form{
		margin-top:  50px;
	}
	.button{
		margin-left: 100px;
	}
</style>
</head>
<body>
		
		<form id="registerForm" action="/doc/docRegist/${doc_box_no}/${emp_no}" method="post"
			enctype="multipart/form-data">
		 <div class="row">
		  <div class="col-sm-3 text">	 
		문서명 : <input type="text" name="doc_title" class="form-control"><br>
		문서설명: <input type="text" name="doc_explain" class="form-control"><br>
		문서내용 : <input type="text" name="doc_contents" class="form-control"><br>
		보존년한 : <input type="text" name="doc_con_period" class="form-control"><br>
		문서양식 : <input type="text" name="doc_formYN" class="form-control"><br>
		</div>
		</div>
		 
		
		
		
		<div class="fileDrop"></div>
		
		<ul class="uploadedList">
		</ul>
		<div class="button">
		<input type="submit" value="등록" class="btn btn-default">
		<input type="button" value="돌아가기" onclick="fn_back()" class="btn btn-default">
		</div>
		
		
		
		</form>
		
		
		
	
</body>  

</html>