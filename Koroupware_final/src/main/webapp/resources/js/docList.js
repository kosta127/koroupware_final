
//----
$(function(){ 
	var doc_box_no = $('#doc_box_no').val();
	var emp_no = $('#emp_no').val();
	console.log('doc box no : ' + doc_box_no + ' / emp_no : ' + emp_no);
	
	function fn_addDoc(){
		location.href="/doc/docRegist/"+doc_box_no+"/"+emp_no;
	}
	function fn_listDocHis(){
		location.href="/doc/doc_hisList/"+doc_box_no+"/"+emp_no;
	}
	function fn_detailDoc_box(){
		location.href="/doc/doc_boxRead/"+doc_box_no+"/"+emp_no;
	}
	
	/*************/
	if(doc_box_no != 0){
		$('#box_li_'+doc_box_no).addClass('active');
	}else{
		$('#box_li_all').addClass('active');
	}
	/*************/
	$('#add_doc_btn').on('click', fn_addDoc);
	$('#list_his_btn').on('click', fn_listDocHis);
	/*************/
	$('#doc_box_list li').each(function(item){
		var $current_li = $(this);
		if($current_li.attr('id')=='box_li_add') return;
		
		$current_li.find('a').on('click', function(){
			$('#doc_box_no').val($current_li.val());
			$('#doc_list_info').attr('method', 'post')
								.attr('action', '/doc/docList/'+emp_no)
								.submit();
			return false;
		})
	});
})