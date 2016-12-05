$(function(){
	var emp_no = $('.emp_no').val();	
	console.log(emp_no);
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
			
				$.getJSON("/empDataUpdate/"+ emp_no, function(data){
					var str = "";
					console.log("나는 겟텔리스트야");
					//console.log(data);
					$(data).each(
						function() {
							str += "<div class='telFontList'><div class='col-md-3 tel-center'>"
							+ "<span class='tel-font'>"+this.tel_type+"</span>"
							+ "</div>"
						    + "<div class='col-md-7 font-center'>"
							+ "<span class='tel-font'>"+telInMinus(this.tel_telephone)+"</span>"
						 	+ "</div>"
							+ "<div data-tel-no='" + this.tel_no + "' class='col-md-2 font-center'>"
							+ "<input type='button' class='btn btn-block telDelete' value='삭제'>"
							+ "</div><div>";
						});
					$('#telList').html(str);
				}); 
				
			}
			
		$('#telList').on("click", ".telDelete", function() {
			var tel_no_parent = $(this).parent();
			var tel_no = tel_no_parent.attr("data-tel-no");
			console.log(tel_no);
			
			$.ajax({
				type : "delete",
				url : "/empDataUpdate/" + tel_no,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : "text",
				success : function(result){
					if (result === "SUCCESS"){
						console.log("삭제");
						getTelList();
					}
				}
			});
		});
		
		$('#addTel').on("click", function() {
			var telType = $('.tel-type').val();
			var telephone = $('.tel-telephone-left').val()+$('.tel-telephone-center').val()+$('.tel-telephone-right').val();
			$.ajax({
				type : "post",
				url : "/empDataUpdate/addTel",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : "text", 
				data : JSON.stringify({
					emp_no : emp_no,
					tel_type : telType,
					tel_telephone : telephone
				}),
				success : function(data) {
					if(data == "SUCCESS"){
						console.log("성공");
						getTelList();
					}
				}
			});
		});
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
function telInMinus(telephone){ //전화번호 짝대기 붙히기 
	if(telephone.substr(0, 2) === "02"){
		if(telephone.length == 9){
			return telephone.substr(0, 2)+"-"+telephone.substr(2, 3)+"-"+telephone.substr(5, 4);
		}else{
			return telephone.substr(0, 2)+"-"+telephone.substr(2, 4)+"-"+telephone.substr(6, 4);
		}
	}else{
		if(telephone.length == 11){
			return telephone.substr(0, 3)+"-"+telephone.substr(3, 4)+"-"+telephone.substr(7, 4);
		}else{
			return telephone.substr(0, 3)+"-"+telephone.substr(3, 3)+"-"+telephone.substr(6, 4);
		}
	}
}
function main() {
	location.href= "main";
}