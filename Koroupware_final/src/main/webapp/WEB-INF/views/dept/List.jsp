<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
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
	<link rel="stylesheet" type="text/css" href="/resources/dept/css/orgChart.css">
	<script type="text/javascript" src="/resources/dept/js/orgChart.js"></script>
</head>
<body>
	<div id="container" class="container">
		<section class="row">
			<c:forEach items="${orgCharList}" var="orgChart">
				<div class="panel-group">
					<div id="orgChartModelList" class="panel panel-default">
						<div class="panel-heading">
							<span class="panel-title">
								<a data-toggle="collapse" href="#deptCollapse${orgChart.deptVO.dept_no}"> 
									${orgChart.deptVO.dept_name}</a>
							</span>
						</div>
						<div id="deptCollapse${orgChart.deptVO.dept_no}" class="panel-collapse collapse">
							<div class="panel-body">
								<span> 업무 : ${orgChart.deptVO.dept_work} </span>
								<span> 위치 : ${orgChart.deptVO.dept_address} </span>
								<span> 연락처 : ${orgChart.deptVO.dept_telephone} </span>
								<ul>
									<c:forEach items="${orgChart.orgChartEmpVOList}" var="orgChartEmp">
									<li>
										<a href="#myModal" data-toggle="modal" id="orgChartEmpButton">
											<span class="hidden">${orgChartEmp.emp_no}</span>
												${orgChartEmp.emp_name}${orgChartEmp.office_name}
												(${orgChartEmp.position_name})
										</a>
									</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">검색중</h4>
						</div>
						<div class="modal-body" id="modalBody">
							<p>뜨는중</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						</div>
					</div>
					<!-- 모달 콘텐츠 -->
				</div>
				<!-- 모달 다이얼로그 -->
			</div>
			<!-- 모달 전체 윈도우 -->
		</section>
	</div>
</body>
</html>