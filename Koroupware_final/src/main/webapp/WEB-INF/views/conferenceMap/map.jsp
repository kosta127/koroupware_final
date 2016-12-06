<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- map -->
<script src="//apis.daum.net/maps/maps3.js?apikey=92bef817e206b1f4c06f9d6ccdf1ca20&libraries=services"></script>
<link href="/resources/css/map.css" rel="stylesheet">
<script src="/resources/js/map.js"></script>
</head>
<body>
	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
		<ul id="category">
			<li id="SW8"><span class="category_bg subway"></span> ����ö</li>
			<li id="CE7"><span class="category_bg cafe"></span> ī��</li>
		</ul>
	</div>
	<br>
	
	<!-- ������ ǥ���� div �Դϴ� -->
	<!-- <p>
		<button onclick="setCenter()">���� �߽���ǥ �̵���Ű��</button>
	</p> -->
	<!-- <p>
		<button onclick="hideMarkers()">��Ŀ ���߱�</button>
		<button onclick="showMarkers()">��Ŀ ���̱�</button>
	</p> -->
	
	<p>
		<button class="btn btn-primary" onclick="findMidPosition()">�߰����� Ž��</button>
	</p>

</body>
</html>
