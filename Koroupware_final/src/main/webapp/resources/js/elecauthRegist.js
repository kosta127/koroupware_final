
$(function(){
	// CKEDITOR 사용 세팅
	CKEDITOR.replace('elec_auth_contents');	
})

$(function(){
	//임시저장버튼
	var $value = $('#elec_auth_temp_save');
	
	$value.on('click',function(){
		var form = $('#elec_auth_form');
		form.attr('action', '/elecauth/regist/1');
		form.submit();
	});
	
	//취소버튼
	$('#elec_auth_cancel').on('click', function(){
		history.back();
	})
})

$(function(){
	//문서양식
	$('#docform_div div.hidden_div').hide();
	//문서양식 변경
	$('#docFormList').on('change', function(){
		var str = $('#hidden_docform_div_'+$(this).val()).html();
		CKEDITOR.instances.elec_auth_contents.setData(str)
	})
})

$(function(){
	//결재마감일 달력 
	var $endDate = $('#elec_auth_enddate');
	$endDate.datepicker({minDate : 0,
						dateFormat : 'yy-MM-dd',
						monthNames : ['01', '02', '03', '04', '05', '06', 
							'07', '08', '09', '10', '11', '12'],
						monthNamesShort : ['01', '02', '03', '04', '05', '06', 
								'07', '08', '09', '10', '11', '12'],	
						dayNames: ['일', '월', '화', '수', '목', '금', '토'],
						closeText: '닫기',
				        prevText: '이전달',
				        nextText: '다음달',
				        currentText: '오늘',
				        changeYear: true,
				        changeMonth: true,
				        showButtonPanel: true,
				        showOtherMonths: true,
				        selectOtherMonths: true,
				        showMonthAfterYear: true});
})

$( function() {
	//결재자, 참조자 설정	
	var autoCompleteList = new Array();	
	
	$.ajax({
		url: '/elecauth/empListAsJson',
		type: 'post',
		dataType: 'json',
		success : setAutocompleteList
	});	
	
	function setAutocompleteList(data){		
		
		$.each(data, function(idx, empDetail){			
			autoCompleteList.push(
				{
					value: empDetail.emp_name,
					label: empDetail.emp_name,
				    emp_no: empDetail.emp_no,
				    dept_name: empDetail.dept_name,
				    position_name: empDetail.position_name,
				    office_name: empDetail.office_name,
				    emp_email: empDetail.emp_email,
				    desc: '<p class="emp_detail form-control-static">\n<span class="emp_name">'+empDetail.emp_name+'</span>' +
	        		 		'<span class="emp_dept"> '+empDetail.dept_name+'</span>' +
	        		 		'<span class="emp_position"> '+empDetail.position_name+' ' +
	        		 		empDetail.office_name+'</span><br><span class="emp_contract">'+empDetail.emp_email+'</span></p>'
				}
			);
		})		
	}

	//결재자
	var $approv = $('#elec_auth_approval');
	$approv.autocomplete({
	      minLength: 0,
	      source: autoCompleteList,
	      focus: function( event, ui ) {
	    	  //$approv.val( ui.item.value );
	        return false;
	      },
	      select: function( event, ui ) {
	    	$( '#'+$approv.attr('id')+'_list' ).append('<li class="appr_list">'+ui.item.desc+
	    			'<input type="hidden" name="approval_emp_no" value="'+ui.item.emp_no+'"></li>');
	    	$approv.val('');
	        return false;
	      }
	    })
	    .autocomplete( 'instance' )._renderItem = function( ul, item ) {
	      return $( '<li>' )
	        .append(item.desc)
	        .appendTo( ul );
	    };
	//참조자
    var $referr = $('#elec_auth_referrer');
    $referr.autocomplete({
	      minLength: 0,
	      source: autoCompleteList,
	      focus: function( event, ui ) {
	    	  //$referr.val( ui.item.value );
	        return false;
	      },
	      select: function( event, ui ) {
	    	$( '#'+$referr.attr('id')+'_list' ).append('<li class="ref_list">'+ui.item.desc+
	    			'<input type="hidden" name="referrer_emp_no" value="'+ui.item.emp_no+'"></li>');
	    	$referr.val('');
	        return false;
	      }
	    })
	    .autocomplete( 'instance' )._renderItem = function( ul, item ) {
	      return $( '<li>' )
	        .append(item.desc)
	        .appendTo( ul );
	    };
	
	//목록클릭시 사라지게
    $('#elec_auth_approval_list').on('click', '.appr_list', function(){
		$(this).remove();
	});
	$('#elec_auth_referrer_list').on('click', '.ref_list', function(){
		$(this).remove();
	});
	
	//결재자는 순서바꾸기 가능하게
	$('#elec_auth_approval_list').sortable({
      placeholder: "ui-state-highlight"
    });
	$('#elec_auth_approval_list').disableSelection();
});

$(function(){
	//검증
	$('#elec_auth_form').validate({
		rules : {
			doc_no : {required : true},
			elec_auth_enddate : {required : true},
			elec_auth_con_period : {required : true},
			elec_auth_title : {required : true, minlength : 1, maxlength : 200},
			elec_auth_contents : {required : true}
		},
		messages : {
			doc_no : {required : "문서를 선택해주세요"},
			elec_auth_enddate : {required : "결재마감일을 선택해주세요"},
			elec_auth_con_period : {required : "보존년한을 선택해주세요"},
			elec_auth_title : {required : "제목을 입력해주세요", 
								minlength : "제목을 1글자 이상 입력해주세요", maxlength : "제목이 너무 깁니다!!"},
			elec_auth_contents : {required : "내용을 작성해주세요"}
		},
		submitHandler : checkApprovals
	});
	
	//결재자선택했는지 검증
	function checkApprovals(){
		var cnt = 0;
		$('#elec_auth_approval_list input[type=hidden]').each(function(){
			cnt += 1;
		})
		if(cnt < 1){ //선택된 결재자 없음
			$('#elec_auth_approval').after('<label id="elec_auth_approval-error" class="error" for="elec_auth_approval">결재자를 선택해주세요</label>');
			$('#elec_auth_approval').focus();
			return false;
		}
		return true;
	}
})