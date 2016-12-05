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
   