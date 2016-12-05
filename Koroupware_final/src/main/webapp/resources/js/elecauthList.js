$(function() {
	$("#write_ul").hide();
	
	$("#write").on("click", function() {
		self.location = "regist";
	});
	
	$("#receive").on("click", function(){
		$("#elecauth_list li").removeClass('active');
		$(this).addClass('active');
		
		$("#receive_ul").show();
		$("#write_ul").hide();
	});
	
	$("#write1").on("click", function(){
		$("#elecauth_list li").removeClass('active');
		$(this).addClass('active');
		
		$("#write_ul").show();
		$("#receive_ul").hide();
	});
});


