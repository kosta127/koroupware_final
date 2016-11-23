<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".search").on("click",function(event){
			event.preventDefault();
			var searchKeyword = $("input").val();
			  $.ajax({
				url : "/message/messageSearch",
				type : "post",
				dataType : "json",
				data : "searchKeyword="+searchKeyword,
				success : function(data){
						 
						 var html ="";
						 $.each(data,function(i){
							 
							html += "<a data-src="+data[i].emp_no+">";
							html += data[i].emp_name+"</a>&nbsp;&nbsp;";
							html += "<label>";
							html += data[i].dept_name+"</label><br>";
							
							
							$("#resultSearch").html(html);
						 });
						 
						
					
				}
			});  
		});
		
		$("#resultSearch").on("click","a",function(event){
			
			var html = "<input type='hidden' name='message_receiver_no' value='"+$(this).attr("data-src")+"'>";
			
			$("form").append(html);
			alert($(this).text());
			
			opener.receiver({
				receiver_no: $(this).attr("data-src"),
				receiver_name: $(this).text(),
				
			});
			window.close();
			
			
		});
		
	});
</script>
<title>Insert title here</title>

</head>
<body>
				<input type="text" name="searchKeyword" id="recevier_name">
				<button class="search">검색</button>
				<div id="resultSearch"></div>
				
			
			
		
		
</body>
</html>