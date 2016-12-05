<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script>
$(function(){
	
	$('.emp_id').keyup(function() { //실시간 아이디 체크 start
	 $.getJSON("/signUp/check", function(data) {
		console.log(data);
		
		if($('.emp_id').val().length < 5){
			$('.idError1').text('');
			$('.idError2').text('');
			$('.idError1').html('6자이상 입력해주세요.').addClass("error").removeClass("success");
			return false;
		}
		
		$(data).each(function() {
			if(this.toString() != $('.emp_id').val()){
				$('.idError1').text('');
				$('.idError2').text('');
				$('.idError2').html('사용가능한 아이디입니다.').addClass("success").removeClass("error");
			}else{
				$('.idError1').text('');
				$('.idError2').text('');
				$('.idError1').html('이미 존재하는 아이디입니다.').addClass("error").removeClass("success");
				return false;
			}
		});
	 });
	 }); // 실시간 아이디 체크 end
		
	  $('.emp_password1').keyup(function(){ //비밀번호 체크 start
	   $('.passError1').text('');
	   $('.passError2').text('');
	  });
	  
	  $('.emp_password2').keyup(function(){
	   if($('.emp_password1').val().length < 3 || 
			   $('.emp_password2').val().length < 3){
		   $('.passError1').text('');
		    $('.passError2').text('');
		    $('.passError1').html("4자이상 입력해주세요.").addClass("error").removeClass("success");
	   }
		  
	   if($('.emp_password1').val()!=$('.emp_password2').val()){
	    $('.passError1').text('');
	    $('.passError2').text('');
	    $('.passError1').html("비밀번호가 일치하지 않습니다.").addClass("error").removeClass("success");
	    return false;
	   }else{
	    $('.passError1').text('');
	    $('.passError2').text('');
	    $('.passError2').html("비밀번호가 일치합니다.").addClass("success").removeClass("error");
	   }
	  }); //비밀번호 체크 end
});

    function sample6_execDaumPostcode() { //다음 주소 api 
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
               // document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;
            }
        }).open();
    } //다음 주소 api 
    
    function cancel() {
    	history.back();
	} //돌아가기
   
</script>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
.success{
   color : #43A047;
}
.error{
   color: #E64A19;
} 
.passError1{
   text-align: right;
}
.main-font1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 55px;
}

.main-font2{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
}
.main-font3{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 50px;
}
.main-font4{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #F9A825;
   font-size: 50px;
}
.main-font5{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
}
.main-font6{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 50px;
}
.main-font7{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 50px;
}
.main-font8{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #F9A825;
   font-size: 50px;
}
.main-font9{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #0080c0;
   font-size: 50px;
}
.main-font10{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
} 
.logo-font{
 text-align: center;
 margin-top: 30px;
 margin-bottom: 30px; 
}
input{
 margin-top: 6px;
 margin-bottom: 6px;
}
span{
  font-family: 'Noto Sans KR', sans-serif; 
  font-size: 15px;
}
.signUp-submit{
background-color : #0080c0;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.signUp-submit:hover{
background-color : #0080c0;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.cancel-button{
background-color : #E64A19;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.cancel-button:hover{
background-color : #E64A19;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.addressSearch-button{
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
} 
.font-div{
 text-align : center;
 margin-top: 10px; 
}
  
.center-form{
 border-radius: 15px;
 margin-top : 30px;
 box-shadow: 5px 5px 5px 5px lightgray; 
}

.center-form-bottom{
 margin-top: 40px;
 margin-bottom: 20px; 
}

.bottom-void{
 height: 30px;
}
.idError{
 text-align: right;
}
</style>
</head>
<body>
<div class="col-md-2"></div> <!-- 왼쪽 여백 div -->
<div class="col-md-8">
<div class="col-md-12 center-form">
<div class="col-md-12 logo-font">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
</div>
<form action="signUp" method="post"> <!-- 폼 시작 -->
<div class="col-md-12"> 
<div class="col-md-2 font-div"> <!-- 아이디 시작  -->

<span>아이디</span> 
</div>  
<div class="col-md-4">
<input type="text" class="form-control emp_id" name="emp_id">
<div class="idError">
<div class="col-md-12 idError1 idError2"></div>
</div>
</div>
<!-- 아이디 끝  -->
<div class="col-md-2 font-div"> <!-- 이름 시작 -->
<span>이름</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_name">
</div>
</div> <!-- 이름 끝 -->
<div class="col-md-12"> <!-- 비밀번호 시작 -->
<div class="col-md-2 font-div">
<span>비밀번호</span>
</div>
<div class="col-md-4">
 <input type="password" class="form-control emp_password1" maxlength="10" name="emp_password">
</div>
<div class="col-md-2 font-div"> 
<span>비밀번호 확인</span>
</div> 
<div class="col-md-4">
<input type="password" class="form-control emp_password2" maxlength="15">
</div>
</div> <!-- 비밀번호 끝 -->
<div class="col-md-12"><div class="col-md-12"><div class="col-md-6"></div><div class="col-md-6 passError1 passError2"></div></div></div> <!-- 비밀번호 에러칸 -->
<div class="col-md-12"> <!-- 주민번호 시작 -->
<div class="col-md-2 font-div">
<span>주민등록번호</span>
</div>
<div class="col-md-5">
<input type="text" class="form-control" maxlength="6" name="emp_residentNum_left"> 
</div>
<div class="col-md-5">
<input type="password" class="form-control" maxlength="7" name="emp_residentNum_right">
</div>
</div> <!-- 주민번호 끝 -->
<div class="col-md-12"> <!-- 이메일 시작  -->
<div class="col-md-2 font-div">
<span>이메일</span>
</div>
<div class="col-md-4">
  <input type="text" class="form-control" name="emp_email">
</div>
<div class="col-md-2 font-div">
<span >결재사인키</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control emp_elec_auth_signkey" name="emp_elec_auth_signkey">
</div>
</div> <!-- 이메일 끝 -->
<div class="col-md-12"> <!-- 전화번호 시작  -->
<div class="col-md-2 font-div">
<span>전화번호</span>
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="3" class="form-control inputs" name="tel_telephone_left">  
</div> 
<div class="col-md-4"> 
 <input type="text" maxlength="4" class="form-control inputs" name="tel_telephone_center">
</div>
<div class="col-md-4"> 
 <input type="text" maxlength="4" class="form-control" name="tel_telephone_right">
</div> <!-- 전화번호 끝 --> 
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>주소</span>
</div>
<div class="col-md-8">
<input type="text" id="sample6_address" class="form-control" name="emp_address">
</div>
<div class="col-md-2">
<input type="button" onclick="sample6_execDaumPostcode()" value="주소찾기" class="btn btn-block addressSearch-button"> <!-- butto태그로 하면 안됨 -->
</div>
</div>
<div class="col-md-12 center-form-bottom">
 <div class="col-md-2">
</div>
<div class="col-md-4">
</div>
<div class="col-md-2"></div>
<div class="col-md-2">
<input type="submit" class="btn btn-block signUp-submit" value="확인"> <!-- 폼 끝 -->
</div>
<div class="col-md-2">
<input type="button" onclick="cancel()" value="취소" class="btn btn-block cancel-button"> <!-- 취소 버튼 -->
</div>
</div> 
</form>
<div class="col-md-12 bottom-void"></div>
</div>
</div>
<div class="col-md-2"></div> <!-- 오른쪽 여백 div -->
</body>
</html>