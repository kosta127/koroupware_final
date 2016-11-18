<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<!-- jquery -->
	<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
	
	<!-- jquery-ui -->
	<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
	<link href="/resources/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet">
	<link href="/resources/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet">
	<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
	
	<!-- bootstrap 3.3.2 -->
	<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
	<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	
	<!-- custom -->
	<link rel="stylesheet" type="text/css" href="/resources/dept/css/orgChartTree.css">
	<script type="text/javascript" src="/resources/dept/js/orgChartTree.js"></script>
	<script type="text/javascript">
		$(function(){
			function toSmallImgTag(emp_img){
				var head = emp_img.substring(0, emp_img.indexOf('.'));
				var pattern = emp_img.substring(emp_img.indexOf('.'));
					
				return "empImg?fileName=" + head + "_small" + pattern;
			}
			
			$.get('ReadTree', function(data){
				var jsonData = getTreeModel( data, 1, {
				    id: "emp_no",
				    parentId: "emp_superior"
				});
				
				$(".horizontalTreeTop").zooTree(jsonData, {
				    forceCreate: true,
				    render: function(data) {
				   		var imgTag = toSmallImgTag(data.emp_img);
						
				    	var $div = $("<a>")
				    		.append("<img src='"+ imgTag +"'/><br/>")
			    			.append(data.dept_name + " ")
			    			.append(data.emp_name + " ")
			    			.append(data.office_name);
			    
			    		return $div;
				    }
				});
			});
		});
	</script>
</head>
<body>
	<div id="container" class="container">
		<div class="horizontalTreeTop"></div>
	</div>
</body>
</html>