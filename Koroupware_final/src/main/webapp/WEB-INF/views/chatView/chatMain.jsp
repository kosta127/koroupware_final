<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
 �׸� �׸��� ��
</div>
</div>
<div class="col-md-2 canvas-menu">
 <button class="canvas-size">ũ������</button>
 <button class="canvas-color">��������</button>
 <button class="canvas-write">�۾���</button>
 <button class="canvas-img">����÷��</button>
 <button class="canvas-capture">ȭ��ĸó</button>
</div>
<div class="col-md-12 chat-people">
<button class="man1">���1</button>
<button class="man2">���2</button>
</div>
</div>
<div class="col-md-4">
 <div class="col-md-12 chat-area">
 </div>
 <div class="col-md-12 chat-write">
 <input type="text" name="chatWrite" class="col-md-9 chat-write">
 <button class="col-md-3 chat-submit btn btn-primary">����</button>
 </div>
</div>
</body>
</html>