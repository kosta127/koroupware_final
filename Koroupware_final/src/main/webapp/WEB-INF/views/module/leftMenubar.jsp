<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
function webrtc() {
   window.open("http://localhost:8082/webrtc", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=0,left=10000,width=400,height=400");
	
}
$(function(){
	$('#est_btn').on('click', function(){
		alert(document.getElementById("hidden").value);
		var emp_no = document.getElementById("hidden").value;
		$.ajax({
		      url: '/estimate/est_do/'+emp_no, //컨트롤러 갈 주소   ... 화면은 그데로 + 혼자 가서 컨토롤로 감
		      type: 'get',
		      dataType: 'json', //받을 값 : 제이손 -> json / String : text / ... 기타 등등이 있음
		      success: check, //받을 값까지 다 성공 했을 때 이동 할 함수(그 함수는 파라메터로 data를 자동으로 가지고 옴)
		      async: false //(기본은 true) false -> 동기, true -> 비동기   [비동기 :: 한번 수행, 동기 :: 내가 정한코딩데로 수행]
		   }
		

		); 
		function check(data){
			
			if(data>0){
				alert("접근 가능");
				location.href = "/estimate/est_list";
			}else{
				alert("접근이 불가능");
			}
			
		}

		return false;
		
		
	})
	
});
</script>
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
          <li class="sidebar-orange"><a href="/dept/List">조직도</a></li> 
          <li class="sidebar-blue"><a href="/message/receivedmessageList/${login.emp_no}">쪽지</a></li>    
           <li class="sidebar-red"><a onclick="webrtc()">화상회의</a></li>
          <li class="sidebar-green"><a href="http://localhost:8082/imageroom/lobby?emp_no=${login.emp_no}">그림회의</a></li>
          <li class="sidebar-orange"><a href="">이메일</a></li>
          <li class="sidebar-blue"><a href="/attend/attendList/${login.emp_no}">출석확인</a></li>
          
			<li class="sidebar-red"><a id="est_btn">인사평가</a></li>                            
			
		</ul>
      </div>
      <div class="col-md-12 sidebar-center-void"></div>
      
</body>
</html>