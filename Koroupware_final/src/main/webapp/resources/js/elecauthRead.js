
// 결재자로 접속했을 경우 결재 수행
$(function() {
	$('#appr_reject_div input[type=button]').on('click', function(){
		var for_action = ($(this).val()=='승인')?'elecauthOkReport':'elecauthNoReport';
		$('#appr_reject_form').attr('action', '/elecauth/'+for_action)
								.submit();
	});				
	
});

//작성자로 접속했을 경우는 수정 및 삭제 가능
$(function(){

	$("#removeReport").on("click", function() {
		var elec_auth_no=$(":input:hidden[name=elec_auth_no]").val();
		location.href= "/elecauth/elecauthDelete/"+elec_auth_no;
	});
});