<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- validation -->
<script src="/resources/validation/jquery.validate.min.js"></script>
<script src="/resources/validation/additional-methods.min.js"></script>
<script src="/resources/validation/messages_ko.min.js"></script>
<!-- ckeditor -->
<script src="/resources/ckeditor/ckeditor.js"></script>
<!-- others -->
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
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
<!-- Font Awesome Icons -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
     folder instead of downloading all of them to reduce the load. -->
<link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/resources/js/docRegist.js"></script>
<style>
.fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: lightslategrey;
	margin: auto;
}
.doc-margin-top{
	margin-top: 30px;
}
.margin-bottom{
	margin-bottom: 20px; 
}
.nomargin{
	margin:0px;
}
.uploadedList{
	list-style-type: none;
}

#uploadedList li{
	padding: 10px;
	float: left;
}
.clear{
	clear: both;
}
</style>
</head>
<body>
	<div class="col-md-11 doc-margin-top margin-bottom">
		<form id="registerForm" action="/doc/docRegist/${doc_box_no}/${emp_no}"
			method="post" enctype="multipart/form-data" class="form-horizontal">
			<!-- 문서명 -->
			<div id="title_div" class="form-group">
				<label for="doc_title" class="col-xs-2 col-lg-2 control-label">문서명</label> 
				<div class="col-xs-10 col-lg-10">
					<input type="text" id="doc_title" name="doc_title" class="form-control">
				</div>
			</div>
			
			<!-- 문서 설명 -->
			<div id="explain_div" class="form-group">
				<label for="doc_explain" class="col-xs-2 col-lg-2 control-label">문서 설명</label> 
				<div class="col-xs-10 col-lg-10">
					<input type="text" id="doc_explain" name="doc_explain" class="form-control">
				</div>
			</div>
			
			<!-- 보존년한 -->
			<div id="conperiod_div" class="form-group">
				<label for="doc_con_period" class="col-xs-2 col-lg-2 control-label">보존년한</label>
				<div class="col-xs-10 col-lg-10">
					<select name="doc_con_period" id="doc_con_period" class="form-control">
						<c:forEach var="i" begin="1" end="10">
							<option value="${i }">${i }년</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<!-- 문서 양식 여부 -->
			<div id="form_yn_div" class="form-group">
				<label for="doc_formYN" class="col-xs-2 col-lg-2 control-label">문서 양식 여부</label>
				<div class="col-xs-10 col-lg-10">
					<select name="doc_formYN" id="doc_formYN" class="form-control">
						<option value="N">N</option>
						<option value="Y">Y</option>
					</select>
				</div>
			</div>
			
			<!-- 내용 -->
			<div id="contents_div" class="form-group">
				<textarea id="doc_contents" name="doc_contents" class="form-control"></textarea>
			</div>
	
			<div class="fileDrop">
			</div>
			<ul id="uploadedList" class="uploadedList">
			</ul>
			<div class="button pull-right clear">
				<input type="submit" value="등록" class="btn btn-default"> 
				<input
					type="button" value="돌아가기" onclick="fn_back()"
					class="btn btn-default">
			</div>
		</form>
	</div>
	
</body>
</html>