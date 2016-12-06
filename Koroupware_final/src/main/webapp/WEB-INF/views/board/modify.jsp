<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
	
<!-- 사용자 js -->
  
<script type="text/javascript">
	$(function(){
		CKEDITOR.replace("board_contents");
	});
</script>

<script type="text/javascript">
	function modify_success(){
		location.href = "list?page=${cri.page}&perPageNum=&{cri.perPageNum}"+"&searchType=${cri.searchType}&keyword=${cri.keyword}"
									+"category_no=${cri.category_no}";
	}
	function modify_cancel(){
		location.href = "list";
	}
</script>
</head>
<body>
<form method="post" >
	<input type="hidden" name="board_no" value="${board_no}">
	<input type="hidden" name="page" value="${cri.page}">
	<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
	<input type="hidden" name="searchType" value="${cri.searchType}">
	<input type="hidden" name="keyword" value="${cri.keyword}">
	<table class="table table-bordered table-hover">
		<tr>
			<td>제목</td>
			<td><input type="text" name="board_title" class="form-control"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="5" name="board_contents" placeholder="내용 입력"></textarea> </td>
		</tr>
	</table>
	<button type="submit" value="수정" onclick="modify_success()" class="btn btn-default">수정</button>
	<button type="submit" value="취소" onclick="modify_cancel" class="btn btn-default">취소</button>
</form>
</body>
</html>