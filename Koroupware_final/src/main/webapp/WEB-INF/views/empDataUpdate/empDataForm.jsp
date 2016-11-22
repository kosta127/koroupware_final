<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	
	getTelList();
	
	  $('.emp_password1').keyup(function(){ //비밀번호 체크 start
	   $('.passError1').text('');
	   $('.passError2').text('');
	  });
	  
	  $('.emp_password2').keyup(function(){
	   if($('emp_password1').val() == null || $('emp_password1').val() == "" || 
			   $('emp_password2').val() == null || $('emp_password2').val() == ""){
		   $('.passError1').val('');
		    $('.passError2').val('');
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
	  
	  $('.emp-img-fileDrop').on("dragenter dragover", function(event) {
			event.preventDefault();
		});

		$('#emp-img-fileDrop').on("drop", function(event) {
			event.preventDefault();
			
			var files = event.originalEvent.dataTransfer.files;
			
			var file = files[0];
			console.log(file);
			var formData = new FormData();
			
			formData.append("file", file);
			
			$.ajax({
				url : "/empDataUpdate/uploadAjax",
				data : formData,
				dataType : 'text',
				processData : false,
				contentType: false,
				type : 'POST',
				success : function(data) {
					var str = "";
					 
					 if(checkImageType(data)){
						  str ="<div><a href=empDataUpdate/displayFile?fileName="+getImageLink(data)+">"
								  +"<img src='empDataUpdate/displayFile?fileName="+data+"'/>"
								  +"</a><small data-src="+data+">X</small>"
								  +"<input type='hidden' name='emp_img' value='"+getImageLink(data)+"'>"
								  +"</div>";
						  $('#emp-img-fileDrop').hide();
						  $('.notFile').remove();
					 }else{
						  str = "<div class='notFile'>지원하지 않는 형식의 파일입니다.</div>";
					  }
					$("#emp-img-uploadedFile").append(str);
					
				}
			});
		});
	  
		$("#emp-img-uploadedFile").on("click", "small", function(event) {
			
			var that = $(this);
			
			$.ajax({
				url : "/empDataUpdate/deleteFile",
				type: "POST",
				data: {fileName:$(this).attr("data-src")},
				dataType : "text",
				success : function(data) {
					if(data == "deleted"){
					  that.parent("div").remove();
					  $('#emp-img-fileDrop').show();
					}
				}
			});
			
		});
		
		 $('.emp-elec-auth-img-fileDrop').on("dragenter dragover", function(event) {
				event.preventDefault();
			});

			$('#emp-elec-auth-img-fileDrop').on("drop", function(event) {
				event.preventDefault();
				
				var files = event.originalEvent.dataTransfer.files;
				
				var file = files[0];
				console.log(file);
				var formData = new FormData();
				
				formData.append("file", file);
				
				$.ajax({
					url : "/empDataUpdate/uploadAjax",
					data : formData,
					dataType : 'text',
					processData : false,
					contentType: false,
					type : 'POST',
					success : function(data) {
						var str = "";
						 
						 if(checkImageType(data)){
							 console.log(getImageLink(data));
							 console.log(data);
							  str ="<div><a href=empDataUpdate/displayFile?fileName="+getImageLink(data)+">"
									  +"<img src='empDataUpdate/displayFile?fileName="+data+"'/>"
									  +"</a><small data-src="+data+">X</small>"
									  +"<input type='hidden' name='emp_elec_auth_img' value='"+getImageLink(data)+"'>"
									  +"</div>";
							  $('#emp-elec-auth-img-fileDrop').hide();
							  $('.notFile').remove();
						 }else{
							  str = "<div class='notFile'>지원하지 않는 형식의 파일입니다.</div>";
						  }
						$("#emp-elec-auth-img-uploadedFile").append(str);

					}
				});
			});
		  
			$("#emp-elec-auth-img-uploadedFile").on("click", "small", function(event) {
				
				var that = $(this);
				
				$.ajax({
					url : "/empDataUpdate/deleteFile",
					type: "POST",
					data: {fileName:$(this).attr("data-src")},
					dataType : "text",
					success : function(data) {
						if(data == "deleted"){
						  that.parent("div").remove();
						  $('#emp-elec-auth-img-fileDrop').show();
						}
					}
				});
				
			});
	
			
			
			function getTelList(){
				var emp_no = ${emp.emp_no};	
				$.getJSON("/empDataUpdate/tel/"+ emp_no, function(data){
					
					var str = "";
					console.log(data);
					$(data).each(
							
						function() {
							str += "<div class='col-md-3'>"
							str + "<span>"+this.tel_type+"</span>"
							str + "</div>"
							str + "<div class='col-md-7'>"
							str + "<span>"+this.tel_telephone+"</span>"
							str + "</div>"
							str + "<div class='col-md-2'>"
							str + "<button>삭제</button>"
							str + "</div>";
						});
					
					$('.tel-list').append(str);
				});
			}
			
			

		});
		


function checkImageType(fileName){
	
	var pattern = /jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);
	
}

function getOriginalName(fileName){	
	
	var idx = fileName.indexOf("_") + 1 ;
	return fileName.substr(idx);
	
}


function getImageLink(fileName){
	
	if(!checkImageType(fileName)){
		return;
	}
	var front = fileName.substr(0,12);
	var end = fileName.substr(14);
	
	return front + end;
	
}

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

function main() {
	location.href= "main";
}


</script>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
.top-span{
	margin-top:30px;
	margin-bottom: 50px;
	text-align: center;
	font-family: 'Noto Sans KR', sans-serif; 
  	font-size: 25px;
}

.middle-span{
margin-top:30px;
	margin-bottom: 50px;
	text-align: center;
	font-family: 'Noto Sans KR', sans-serif; 
  	font-size: 20px;
}
.success{
   color : #43A047;
}
.error{
   color: #E64A19;
} 
.passError1{
   text-align: right;
}
.top-span{
  color: #0080c0;
}
.middle-span{
  color: #43A047; 
}
.center-form input{
    margin-top: 10px;
    margin-bottom: 10px;
}
.font-center{
	text-align: center;
}
.emp-update-bottom-void{
  margin-bottom: 30px;
}
.font-div{
  margin-top: 15px;
  font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px; 
}
.btn-block{
  font-family: 'Noto Sans KR', sans-serif; 
  font-size: 15px; 
}
.tel-list-font{
  padding-bottom: 15px;
  text-align: center;
  margin-top: 15px;
  margin-bottom: 15px;
  font-family: 'Noto Sans KR', sans-serif; 
  font-size: 15px; 
  border-bottom: 1px dotted gray;
}
.emp-img-fileDrop, .emp-elec-auth-img-fileDrop{
  font-family: 'Noto Sans KR', sans-serif; 
  font-size: 15px; 
	text-align: center;
	height : 100px;
	border: 1px dotted black;
	padding-top: 40px;
}
</style>
</head>
<body>
<div class="col-md-1"></div>
<div class="col-md-10 center-form">
<div class="col-md-12 top-span">
<div class="col-md-4"></div>
<div class="col-md-4">
<span>회원정보</span>
</div>
<div class="col-md-4"></div>
</div>
<form action="empDataUpdate" method="post">
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>비밀번호</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control emp_password1" name="emp_password">
</div>
<div class="col-md-2 font-div">
<span>비밀번호 확인</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control emp_password2">
</div>
</div>
<div class="col-md-12"><div class="col-md-12"><div class="col-md-6"></div><div class="col-md-6 passError1 passError2"></div></div></div> <!-- 비밀번호 에러칸 -->
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>이름</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_name" value="${emp.emp_name }">
</div>

<div class="col-md-2 font-div">
<span>이메일</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_email" value="${emp.emp_email }">
</div>
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>주소</span>
</div>
<div class="col-md-6">
<input type="text" class="form-control" id="sample6_address" name="emp_address" value="${emp.emp_address }">
</div>
<div class="col-md-4">
<input type="button" onclick="sample6_execDaumPostcode()" class="btn btn-block" value="주소찾기">
</div>
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>사진</span>
</div>
<div class="col-md-4">
 <c:if test="${emp.emp_img eq null }"> 
<div class="emp-img-fileDrop" id="emp-img-fileDrop"><span class="img-text">사진을 넣어주세요.</span></div>
<div class="emp-img-uploadedFile" id="emp-img-uploadedFile"></div>
</c:if>
<c:if test="${emp.emp_img ne null }">
<div><a href="empDataUpdate/displayFile?fileName=${emp.emp_img }">
								 <img src="empDataUpdate/displayFile?fileName=${emp.emp_img }"/>
								  </a><small data-src="${emp.emp_img }">X</small>
								  <input type='hidden' name='emp_img' value="${emp.emp_img }">
								  </div>
</c:if>
</div>
<div class="col-md-2 font-div">
<span>결재사진</span>
</div>
<div class="col-md-4">
<c:if test="${emp.emp_img eq null }"> 
<div class="emp-elec-auth-img-fileDrop" id="emp-elec-auth-img-fileDrop"><span class="img-text">사진을 넣어주세요.</span></div>
<div class="emp-elec-auth-img-uploadedFile" id="emp-elec-auth-img-uploadedFile"></div>
</c:if>
<c:if test="${emp.emp_img ne null }">
<div><a href="empDataUpdate/displayFile?fileName=${emp.emp_elec_auth_img }">
								 <img src="empDataUpdate/displayFile?fileName=${emp.emp_elec_auth_img }"/>
								  </a><small data-src="${emp.emp_elec_auth_img }">X</small>
								  <input type='hidden' name='emp_img' value="${emp.emp_elec_auth_img }">
								  </div>
</c:if>
</div>
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>결재사인키</span> 
</div>
<div class="col-md-4">
<input type="password" class="form-control" name="emp_elec_auth_signkey">
</div>
</div> 
<div class="col-md-12 middle-span">
<div class="col-md-4"></div>
<div class="col-md-4">
<span>전화번호</span>
</div>
<div class="col-md-4"></div>
</div>
<div class="col-md-12">
<div class="col-md-1 font-div">
<span>용도</span>
</div>
<div class="col-md-2">
<input type="text" class="form-control tel_type" name="tel_type">
</div>
<div class="col-md-1 font-div">
<span>번호</span>
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="3" class="form-control tel-telephone-left" name="tel_telephone_left">  
</div> 
<div class="col-md-2"> 
 <input type="text" maxlength="4" class="form-control tel-telephone-center" name="tel_telephone_center">
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="4" class="form-control tel-telephone-right" name="tel_telephone_right">
</div>
<div class="col-md-2">
<input type="button" class="btn btn-block addTel" value="추가">
</div>
<div class="col-md-12 tel-list-font">
 <span>전화번호 목록</span>
</div>
<div class="col-md-12 tel-list">
<div class="col-md-12">
<div class="col-md-3 font-div font-center">
<span>용도</span>
</div>
<div class="col-md-7 font-div font-center">
<span>번호</span>
</div>
<div class="col-md-2"></div>
</div>
<div class="col-md-3"></div>
<div class="col-md-7"></div>
<div class="col-md-2">
 <button class="btn btn-block deleteTel">삭제</button>
</div>
</div>
</div>
<div class="col-md-6">
<input type="submit" class="btn btn-block update-submit" value="수정">
</div>
<div class="col-md-6">
<input type="button" onclick="main()" value="취소" class="btn btn-block cancel-button"> <!-- 취소 버튼 -->
</div>
</form>
</div>
<div class="col-md-1"></div>
<div class="col-md-12 emp-update-bottom-void"></div>
</body>
</html>