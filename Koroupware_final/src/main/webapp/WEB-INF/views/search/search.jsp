<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 검색</h1>
	<div class='box'>
		<div class="box-header with-border">
			<h3 class="box-title">Board List</h3>
		</div>
		<div class='box-body'>
			<select name="searchType">
				<option value="emp"
					<c:out value="${cri.searchType eq 'emp'?'selected' : ''}"/>>사원</option>
				<option value="doc"
					<c:out value="${cri.searchType eq 'doc'?'selected' : ''}"/>>문서</option>
			</select> <input type="text" name='keyword' id="keywordInput"
				value='${cri.keyword }'>
			<button id='searchBtn'>Search</button>
			<button id='newBtn'>New Board</button>
		</div>
	</div>
</body>
</html>