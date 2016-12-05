$(function(){
	//결재 등록버튼 이벤트
	$('#write').on('click', function() {
		self.location = 'regist';
	});
})

$(function() {
	console.log('reloaded kind -> ' + $('#kind').val() + '  receive -> ' + $('#receive').val())
	
	// 탭메뉴 이벤트	
	var $write_ul = $('#write_ul');
	var $receive_ul = $('#receive_ul');
	if($('#receive').val()=='ok'){ //내가받은목록이면
		console.log("????")
		$('#receive_li').addClass('active');
		$write_ul.hide();
	}else{
		$('#write_li').addClass('active');
		$receive_ul.hide();
	}

	$('#category_list li a[href*="'+ $('#kind').val() + '/' +$('#receive').val()+'"]')
					.parents('li').addClass('active');
	
	/**************************************/
	/*** 버튼 이벤트 ***/
	/**************************************/
	
	$('#receive_li').on('click', function(){
		doSubmit($receive_ul.find('li:first a').attr('href'));
	});
	
	$('#write_li').on('click', function(){
		doSubmit($write_ul.find('li:first a').attr('href'));
	});
	
	/**************************************/
	/**************************************/
	/**************************************/
	
	var $flagForm = $('#flag_form');
	$('#category_list a').on('click', function(){
		doSubmit($(this).attr('href'));
		return false;
	})
	
	function doSubmit(hrefStr){
		var params = hrefStr.split('/');
		$('#kind').val(params[0]);
		$('#receive').val(params[1]);
		
		$flagForm.attr('action', '/elecauth/elecauthList')
				.attr('method', 'post')
				.submit();
	}
});


