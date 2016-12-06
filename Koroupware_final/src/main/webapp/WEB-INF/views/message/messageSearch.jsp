<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".search").on("click",function(event){
			event.preventDefault();
			var searchKeyword = $("#searchKeyword").val();
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
<style type="text/css">
	.search {
		margin-left: 30px;
	}
</style>

</head>
<body>			<div class="search">
					<input type="text" name="searchKeyword" id="searchKeyword">
					<button class="btn btn-primary search">검색</button>
				</div>
			
				<div id="resultSearch"></div>
				
			
			
		
		
</body>
</html>