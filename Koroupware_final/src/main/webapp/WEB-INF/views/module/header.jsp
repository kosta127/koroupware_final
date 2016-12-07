<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function(){
		$(".search-button").click(function(){
			$("#searchForm").submit();
		});
		
	});

	function logout() {
		location.href = '/logout';
	}
	function attendList() {
		var emp_no = document.getElementById("hidden").value;
		location.href = "/attend/attendList/" + emp_no;
	}

	/* 출석 에이작스 */
	function attend() {
		alert(document.getElementById("hidden").value);
		var emp_no = document.getElementById("hidden").value;
		/* location.href = '/attend/attendStart/'+emp_no; */
		$.ajax({
			url : '/attend/attendStart/' + emp_no, //컨트롤러 갈 주소   ... 화면은 그데로 + 혼자 가서 컨토롤로 감
			type : 'get',
			dataType : 'text', //받을 값 : 제이손 -> json / String : text / ... 기타 등등이 있음
			success : check, //받을 값까지 다 성공 했을 때 이동 할 함수(그 함수는 파라메터로 data를 자동으로 가지고 옴)
			async : false
		//(기본은 true) false -> 동기, true -> 비동기   [비동기 :: 한번 수행, 동기 :: 내가 정한코딩데로 수행]
		});

	}

	function check(data) {
		if (data == "already") {
			alert("이미 출석 했습니다.");
		} else if (data == "attend") {
			alert("정상 출근");
		} else if (data == "late") {
			alert("지각");
		} else if (data = "restday") {
			alert("주말");
		}

	}
</script>
<style>
.main-font{
	margin-top : 5px;
 text-align: center;
}
.main-font1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 35px;
} 

.main-font2{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 30px;
}
.main-font3{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 30px;
}
.main-font4{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #F9A825;
   font-size: 30px;
}
.main-font5{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 30px;
}
.main-font6{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 30px;
}
.main-font7{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 30px;
}
.main-font8{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #F9A825;
   font-size: 30px;
}
.main-font9{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #0080c0;
   font-size: 30px;
}
.main-font10{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 30px;
} 

.main-font1-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 45px;
} 
.main-font2-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 40px;
   
}
.main-font3-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 40px;
}
.main-font4-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #F9A825;
   font-size: 40px;
}
.main-font5-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 40px;
}
.main-font6-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 40px;
}
.main-font7-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 40px;
}
.main-font8-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #F9A825;
   font-size: 40px;
}
.main-font9-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #0080c0;
   font-size: 40px;
}
.main-font10-1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 40px;
} 
.header-button{
	margin-top: 15px;
	margin-bottom: 10px;
	
}
.emp_name{
font-family: 'Noto Sans KR', sans-serif; 
  margin-top: 20px;
  text-align: center; 
} 

.emp_name a:hover{
 text-decoration: none;
}

.emp_img{
font-family: 'Noto Sans KR', sans-serif; 
  margin-top: 20px;
  text-align: center; 
}

.main-font a:hover{
text-decoration :none;
}
.header-search-span{
font-family: 'Noto Sans KR', sans-serif; 
}
.header-search-div{
 	margin-top: 15px;
}
 
.header-search{
  text-align: right;
  margin-top: 5px; 
}
.search-button{
	/* margin-top: 3px; */
	font-family: 'Noto Sans KR', sans-serif; 
}
.logout-button{
	font-family: 'Noto Sans KR', sans-serif; 
}
.update-button{
 font-family: 'Noto Sans KR', sans-serif; 
}
.header-emp-img{
	width: 60px;
	height: 60px;
	margin-top: -17px;
}
.for-inline{
	display: inline;
}
</style>
</head>
<body>
<div class="col-md-1 main-font">
	<a href="/main" class="hidden-xs hidden-sm">
	<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
	</a>
	<a href="/main" class="hidden-md hidden-lg">
	<span class="main-font1-1">K</span><span class="main-font2-1">o</span><span class="main-font3-1">r</span><span class="main-font4-1">o</span><span class="main-font5-1">u</span><span class="main-font6-1">p</span><span class="main-font7-1">w</span><span class="main-font8-1">a</span><span class="main-font9-1">r</span><span class="main-font10-1">e</span>
	</a>
</div>
<div class="col-md-1"></div>
<div class="col-md-6">
		<form id="searchForm" action="/search/search" method="post" class="form-inline">
			<div class="col-md-12 header-search-div">
				<div class="for-inline">
					<span class="header-search-span">회원/부서 검색</span>
					<select name="keyField" class="form-control">
						<option value="emp_name">사원</option>
						<option value="doc_name">문서</option>
					</select>
					<input type="text" class="form-control search-text" name="search_content">
					<button class="btn search-button btn-lg">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
				
		</div>
<div class="col-md-4">
<div class="col-md-2"></div>
<div class="col-md-3 emp_img">
<img class="header-emp-img block img-rounded" src="/displayFile?fileName=${login.emp_img}"/>
</div>
<input id="hidden" type="hidden" value=${login.emp_no }>
<div class="col-md-3 emp_name">
<a href="/empDataUpdate?emp_no=${login.emp_no }"><span class="header-emp-name block">${login.emp_name }</span></a>
</div>
<div class="col-md-4 header-button">
<button type="button" class="btn btn-lg" onclick="attend()"><i class="glyphicon glyphicon-ok"></i></button>
<button onclick="logout()" class="btn logout-button btn-lg"><i class="glyphicon glyphicon-off"></i></button>
</div>
</div>
</body>
</html>