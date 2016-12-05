<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
.nav-sidebar .sidebar-blue a { 
    cursor: default;
    background-color: #fff; 
    color: black; 
}
.nav-sidebar .sidebar-blue a:hover {
    background-color: #0080c0;
    color: white;   
}

.nav-sidebar .sidebar-blue a:ACTIVE {
    background-color: #0080c0;
    color: white;   
}

.nav-sidebar .sidebar-red a { 
    cursor: default;
    background-color: #fff; 
    color: black; 
}
.nav-sidebar .sidebar-red a:hover {
    background-color: #E64A19;  
    color: white; 
}

.nav-sidebar .sidebar-green a { 
    cursor: default;
    background-color: #fff; 
    color: black; 
}
.nav-sidebar .sidebar-green a:hover {
    background-color: #43A047; 
    color: white;  
}

.nav-sidebar .sidebar-orange a { 
    cursor: default;
    background-color: #fff; 
    color: black; 
}
.nav-sidebar .sidebar-orange a:hover {
    background-color: #F9A825; 
    color: white;  
}

.tabs li{
  box-shadow: 1px 1px 0.5px 0.5px lightgray; 
  margin-bottom: 2px;
}

.tabs li:hover{
  box-shadow: 2px 2px 2px 2px lightgray; 
  margin-bottom: 7px;
}

.tabs li a{
	font-family: 'Noto Sans KR', sans-serif; 
	font-size: 15px;
}
.nav-sidebar{ 
	margin-top: 30px;
}

.sidebar-center-void{
	margin-top: 30px;
	margin-bottom: 30px
}

</style>
</head>
<body> 
      <div class="nav-sidebar">
        	<ul class="nav tabs">
          <li class="sidebar-blue"><a href="/elecauth/elecauthList">전자결재</a></li>
          <li class="sidebar-red"><a href="/doc/doc_boxList/${login.emp_no}">문서</a></li>
          <li class="sidebar-green"><a href="">게시판</a></li>
          <li class="sidebar-orange"><a href="">조직도</a></li> 
          <li class="sidebar-blue"><a href="/message/receivedmessageList/${login.emp_no}">쪽지</a></li>    
           <li class="sidebar-red"><a href="/webrtc">화상회의</a></li>
          <li class="sidebar-green"><a href="">그림회의</a></li>
          <li class="sidebar-orange"><a href="">이메일</a></li> 
          <li class="sidebar-blue"><a href="">출석부</a></li>                          
		</ul>
      </div>
      <div class="col-md-12 sidebar-center-void"></div>
      
</body>
</html>