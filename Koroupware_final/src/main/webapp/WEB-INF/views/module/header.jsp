<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
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
	font-size: 15px;
}
.header-search-div{
 	margin-top: 15px;
}
 
.header-search{
  text-align: right;
  margin-top: 5px; 
}
.search-button{
	margin-top: 3px;
	font-family: 'Noto Sans KR', sans-serif; 
}
.logout-button{
	font-family: 'Noto Sans KR', sans-serif; 
}
.update-button{
 font-family: 'Noto Sans KR', sans-serif; 
}
</style>
<body>
<div class="col-md-1 main-font">
<a href="main" class="hidden-xs hidden-sm">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
</a>
<a href="main" class="hidden-md hidden-lg">
<span class="main-font1-1">K</span><span class="main-font2-1">o</span><span class="main-font3-1">r</span><span class="main-font4-1">o</span><span class="main-font5-1">u</span><span class="main-font6-1">p</span><span class="main-font7-1">w</span><span class="main-font8-1">a</span><span class="main-font9-1">r</span><span class="main-font10-1">e</span>
</a>
</div>
<div class="col-md-1"></div>
<div class="col-md-6">
<div class="col-md-12 header-search-div">
<div class="col-md-4 header-search">
   <span class="header-search-span">회원/부서 검색</span>
  </div>    
      <div class="col-md-6">
      <input type="text" class="form-control search-text">
      </div>
      <div class="col-md-2">
      <button class="btn btn-block search-button"><i class="glyphicon glyphicon-search"></i></button>
      </div>
</div>      
</div>
<div class="col-md-4">
<div class="col-md-3"></div>
<div class="col-md-3 emp_img">
<span class="header-emp-img block">회원사진</span>
</div>
<div class="col-md-3 emp_name">
<a href="empDataUpdate?emp_no=1"><span class="header-emp-name block">회원이름</span></a>
</div>
<div class="col-md-3 header-button">
<button onclick="logout()" class="btn btn-block logout-button btn-lg"><i class="glyphicon glyphicon-off"></i></button>
</div>
</div>
</body>
</html>