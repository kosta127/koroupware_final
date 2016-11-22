<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 
 .chat-area{
    border: 1px solid black;
 	overflow: scroll;
 	height: 450px;
 }
 .canvas-canvas{
  height: 450px;
  border: 1px solid black;
 }
 .chat-people{
 	height: 50px;
 	border: 1px solid black;
 }
 .canvas-menu{
  height: 450px; 
  border: 1px solid black;
 }
 
 .canvas-menu button {
  margin: 10px 0px 10px 0px;	
 }
 .chat-write{
  height: 50px;
  border: 1px solid black;
 }
 .chat-submit{
  height: 50px;
  border: 1px solid black;
 }
</style>
</head>
<body>
<div class="col-md-8">
<div class="col-md-10">
<div class="canvas-canvas">
 그림 그리는 곳
</div>
</div>
<div class="col-md-2 canvas-menu">
 <button class="canvas-size">크기조절</button>
 <button class="canvas-color">색상조절</button>
 <button class="canvas-write">글쓰기</button>
 <button class="canvas-img">사진첨부</button>
 <button class="canvas-capture">화면캡처</button>
</div>
<div class="col-md-12 chat-people">
<button class="man1">사람1</button>
<button class="man2">사람2</button>
</div>
</div>
<div class="col-md-4">
 <div class="col-md-12 chat-area">
 </div>
 <div class="col-md-12 chat-write">
 <input type="text" name="chatWrite" class="col-md-9 chat-write">
 <button class="col-md-3 chat-submit btn btn-primary">전송</button>
 </div>
</div>
</body>
</html>