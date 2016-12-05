
// 결재자로 접속했을 경우 결재 수행
$(function() {
	$("#okReport").on("click", function() {
		var elec_auth_no=$(":input:hidden[name=elec_auth_no]").val();
		var emp_no=$(":input:hidden[name=emp_no]").val();
		location.href= "/elecauth/elecauthOkReport/"+elec_auth_no, emp_no;
	});

	$("#noReprot").on("click", function() {
		var elec_auth_no=$(":input:hidden[name=elec_auth_no]").val();
		var emp_no=$(":input:hidden[name=emp_no]").val();
		location.href= "/elecauth/elecauthNoReport/"+elec_auth_no, emp_no;
	});

	

});

//작성자로 접속했을 경우는 수정 및 삭제 가능
$(function(){

	$("#removeReport").on("click", function() {
		var elec_auth_no=$(":input:hidden[name=elec_auth_no]").val();
		location.href= "/elecauth/elecauthDelete/"+elec_auth_no;
	});
});