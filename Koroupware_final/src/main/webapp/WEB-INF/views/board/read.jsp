<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">
	function board_modify() {
		location.href="modify?board_no=${boardVO.board_no}";
	}
	function board_list() {
		location.href="list?page=${cri.page}&perPageNum=${cri.perPageNum}";
	}
	function board_delete() {
		location.href="remove?board_no=${boardVO.board_no}&page=${cri.page}&perPageNum=${cri.perPageNum}";
	}
	function reply_add(){
		var replytextObj=$("#replyContents");
		var reply_contents = $("#replyContents").val();
		var emp_no = 1;
		
		$.ajax({
			type:'post',
			url:'reply',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			dataType:'text',
			data:JSON.stringify({
				board_no:board_no, 
				reply_contents:reply_contents,
				emp_no:emp_no
				}),
			
			success:function(result){
				console.log("result:"+result);
				if(result=='SUCCESS'){
					alert("등록");
					replytextObj.val("");
					location.reload();
				}
			}
		});
		
	}
	
	function show_list(){
		$("div#replyList").toggle();
	}
	
	function reply_delete(param){
		$.ajax({
			type:'delete',
			url:'reply/'+param,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
			},
			dataType:'text',
			success:function(result){
				console.log("result:"+result);
				if(result=='SUCCESS'){
					alert("삭제완료");
				}
			}
		});
	}

		
</script>
<script>
	var board_no = ${boardVO.board_no};
	
	$.getJSON("reply/all/"+board_no, function(data){
		var str="";
		console.log(data.length);
		
		$(data).each(function(){
			//var reply_no = ${reply_no};
			
			str += "<li data-reply_no='"+this.reply_no+"' class='reply_contents'>"
				+ this.reply_no + ":" +this.reply_contents
				+ '<a href="#" id="removeReply" name="replyDelete" onclick="reply_delete('+ this.reply_no +')">삭제</a>'
				+ "</li>";
		});
		
		$("#replies").html(str);      
	});
	
	function getAllList(){
		$.getJSON("reply/all/"+board_no, function(data){
			var str="";
			console.log(data.length);
			
			$(data).each(function(){
				str += "<li data-reply_no='"+this.reply_no+"' class='reply_contents'>"
					+ this.reply_no + ":" +this.reply_contents
			});
			$("#replies").html(str);
		});
	}
	
	$("#repliesDiv").on("click", function(){
		if($(".timeline li").size()>1){
			return;
		}
		
	});
	
	
</script>
<script id="templateAttach" type="text/x-handlebars-template">
    <li data-src='{{fullName}}'>
      <span class="mailbox-attachment-icon has-img">
         <img src="{{imgsrc}}" alt="Attachment">
      </span>
      <div class="mailbox-attachment-info">
         <span>
            <a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
         </span>
      </div>
   </li>            
</script>
<script id="template" type="text/x-handlebars-template">
   {{#each .}}
   <li class="replyLi" data-rno={{reply_no}}>
      <i class="fa fa-comments bg-blue"></i>
      <div class="timeline-item">
         <span class="time"> 
            <i class="fa fa-clock-o"></i>{{prettifyDate reply_regdate}}
         </span>
         <h3 class="timeline-header">
            <strong>{{reply_no}}</strong> 
         </h3>
         <div class="timeline-body">{{reply_contents}}</div>
         <div class="timeline-footer">
            <a class="btn btn-primary btn-xs" data-toggle="modal"
               data-target="#modifyModal">Modify</a>
         </div>
      </div>
   </li>
   {{/each}}
</script>
<script>
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	
	var printData = function(replyArr, target, templateObject) {
	
		var template = Handlebars.compile(templateObject.html());
	
		var html = template(replyArr);
		$(".replyList").remove();
		target.after(html);

}
</script>
<script>
	$(document).ready(function(){
		var board_no = ${boardVO.board_no};
		var template = Handlebars.compile($("#templateAttach").html());
		
		$.getJSON("/board/getAttach/"+board_no, function(list){
			$(list).each(function(){
				var fileInfo = getFileInfo(this);
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			});
			
		});
		
		$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event) {

			var fileLink = $(this).attr("href");
	
			if (checkImageType(fileLink)) {
	
				event.preventDefault();
	
				var imgTag = $("#popup_img");
				imgTag.attr("src", fileLink);
	
				console.log(imgTag.attr("src"));
	
				$(".popup").show('slow');
				imgTag.addClass("show");
			}
		});

		$("#popup_img").on("click", function() {
			$(".popup").hide('slow');

		});
	});
</script>

<script>
	$(document).ready(function(){
		var board_no = ${boardVO.board_no};
		
		$("#like").click(function(){
			var count = $("#like").index(this);
			var num = $(".countUp:eq("+count+")").val();
			num = $(".countUp:eq("+count+")").val(count+1);	
			
			var countDown = $("#unlike").index(this);
			var num1 = $(".countDown:eq("+countDown+")").val();
			num1 = $(".countDown:eq("+countDown+")").val(count)-1;
		});
		
		$("#unlike").click(function(){
			var count = $("#unlike").index(this);
			var num = $(".countDown:eq("+count+")").val();
			num = $(".countDown:eq("+count+")").val(count+1);
			
			var countDown = $("#like").index(this);
			var num1 = $(".countUp:eq("+countDown+")").val();
			num1 = $(".countUp:eq("+countDown+")").val(count)-1;
		});
		
		
	});
</script>

<style type="text/css">
.popup {
	position: absolute;
}

.back {
	background-color: gray;
	opacity: 0.5;
	width: 100%;
	height: 300%;
	overflow: hidden;
	z-index: 1101;
}

.front {
	z-index: 1110;
	opacity: 1;
	boarder: 1px;
	margin: auto;
}

.show {
	position: relative;
	max-width: 1200px;
	max-height: 800px;
	overflow: auto;
}
</style>
</head>
<body>
	<div class='popup back' style="display: none;"></div>
	<div id="popup_front" class='popup front' style="display: none;">
		<img id="popup_img">
	</div>

	<form method="post" action="modify">
		<input type="hidden" name="board_no" value="${boardVO.board_no }">
		<input type="hidden" name="page" value="${cri.page}">
		<input	type="hidden" name="perPageNum" value="${cri.perPageNum}"> 
		<input	type="hidden" name="searchType" value="${cri.searchType}"> 
		<input	type="hidden" name="keyword" value="${cri.keyword}">
	</form>

	<table border="1">
		<tr height="30">
			<td width="100" align="center">NO</td>
			<td width="300">${boardVO.board_no }</td>
		</tr>
		<tr height="30">
			<td width="100" align="center">제목</td>
			<td width="300">${boardVO.board_title}</td>
		</tr>

		<tr height="30">
			<td width="100" align="center">작성날짜</td>
			<td width="300"><fmt:formatDate
					value="${boardVO.board_regdate }" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr height="30">
			<td width="300" colspan="2">${boardVO.board_contents }</td>
		</tr>

	</table>

	<ul class="mailbox-attachments clearfix uploadedList"></ul>

	<input type="button" class="btn btn-default" value="수정"
		onclick="board_modify()">
	<input type="button" class="btn btn-default" value="목록"
		onclick="board_list()">
	<input type="button" class="btn btn-default" value="삭제"
		onclick="board_delete()">
	<input type="button" class="btn btn-default" value="댓글"
		onclick="show_list()">&nbsp;&nbsp;

	
	<!-- <span>
		<input type="button" value="좋아요" onclick="update_rec($(boardVO.board_no))">
		<input value="0" class="countUp">
		<input type="button" value="싫어요" onclick="update_rec($(boardVO.board_no))">
		<input value="0" class="countDown">
	</span> -->
	<form action="read" method="post">
	<input type="hidden" name="board_no" value="${boardVO.board_no }">
		<span id="like">좋아요
			<input name="distinction" type="text" value="0" class="countUp">
		</span>&nbsp;
		<span id="unlike">싫어요
			<input name="distinction" type="text" value="0" class="countDown">
		</span>
	</form>
	
	<h2>댓글</h2>

	<div>
		<div id="replyList">
			<label>NO</label> <label>contents</label>
			<ul id="replies">
				<c:forEach var="replyVO" items="${replyVO }">
					<input type="hidden" name="reply_no" value="${replyVO.reply_no }">
	
					<div class="reply_contents">
						<div>${replyVO.reply_contents }</div>
						<div>${replyVO.reply_regdate }</div>
						<div>
							<a name="replyDelete" onclick="reply_delete(${replyVO.reply_no})">삭제</a>
						</div>
					</div>

				</c:forEach>
			</ul>

			

			내용 <input type="text" name="reply_contents" id="replyContents" value="${replyVO.reply_contents }">

		</div>

		<button id="replyAdd" onclick="reply_add()">추가</button>
	</div>
</body>
</html>
