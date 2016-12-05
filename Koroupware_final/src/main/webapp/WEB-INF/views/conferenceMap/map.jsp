<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.map_wrap, .map_wrap * {
	margin: 0;
	padding: 0;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	font-size: 12px;
}

.map_wrap {
	position: relative;
	width: 100%;
	height: 350px;
}

#category {
	position: absolute;
	top: 10px;
	left: 10px;
	border-radius: 5px;
	border: 1px solid #909090;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
	background: #fff;
	overflow: hidden;
	z-index: 2;
}

#category li {
	float: left;
	list-style: none;
	width: 50px; px;
	border-right: 1px solid #acacac;
	padding: 6px 0;
	text-align: center;
	cursor: pointer;
}

#category li.on {
	background: #eee;
}

#category li:hover {
	background: #ffe6e6;
	border-left: 1px solid #acacac;
	margin-left: -1px;
}

#category li:last-child {
	margin-right: 0;
	border-right: 0;
}

#category li span {
	display: block;
	margin: 0 auto 3px;
	width: 27px;
	height: 28px;
}

#category li .category_bg {
	background:
		url(http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
		no-repeat;
}

#category li .subway {
	background-position: -10px 0;
}

#category li .cafe {
	background-position: -10px -36px;
}

#category li.on .category_bg {
	background-position-x: -46px;
}

.placeinfo_wrap {
	position: absolute;
	bottom: 28px;
	left: -150px;
	width: 300px;
}

.placeinfo {
	position: relative;
	width: 100%;
	border-radius: 6px;
	border: 1px solid #ccc;
	border-bottom: 2px solid #ddd;
	padding-bottom: 10px;
	background: #fff;
}

.placeinfo:nth-of-type(n) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.placeinfo_wrap .after {
	content: '';
	position: relative;
	margin-left: -12px;
	left: 50%;
	width: 22px;
	height: 12px;
	background:
		url('http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.placeinfo a, .placeinfo a:hover, .placeinfo a:active {
	color: #fff;
	text-decoration: none;
}

.placeinfo a, .placeinfo span {
	display: block;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.placeinfo span {
	margin: 5px 5px 0 5px;
	cursor: default;
	font-size: 13px;
}

.placeinfo .title {
	font-weight: bold;
	font-size: 14px;
	border-radius: 6px 6px 0 0;
	margin: -1px -1px 0 -1px;
	padding: 10px;
	color: #fff;
	background: #d95050;
	background: #d95050
		url(http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
		no-repeat right 14px center;
}

.placeinfo .tel {
	color: #0f7833;
}

.placeinfo .jibun {
	color: #999;
	font-size: 11px;
	margin-top: 0;
}
</style>
</head>
<body>
	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
		<ul id="category">
			<li id="BK9"><span class="category_bg subway"></span>
				지하철</li>
			<li id="CE7"><span class="category_bg cafe"></span>
				카페</li>
		</ul>
	</div>

	<!-- 지도를 표시할 div 입니다 -->
	<p>
		<button onclick="setCenter()">지도 중심좌표 이동시키기</button>
		<button onclick="panTo()">지도 중심좌표 부드럽게 이동시키기</button>
	</p>
	<p>
		<button onclick="hideMarkers()">마커 감추기</button>
		<button onclick="showMarkers()">마커 보이기</button>
	</p>
	<p>
		<button onclick="findMidPosition()">중간지점 탐색</button>
	</p>



	<script type="text/javascript"
		src="//apis.daum.net/maps/maps3.js?apikey=92bef817e206b1f4c06f9d6ccdf1ca20"></script>
	<script>
		// 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
		var placeOverlay = new daum.maps.CustomOverlay({
			zIndex : 1
		}), contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
		markers = [], // 마커를 담을 배열입니다
		currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new daum.maps.LatLng(37.478855, 126.881176), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		//지도 표시------------------------------------------------------------------------------------------
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new daum.maps.Map(mapContainer, mapOption);

		function setCenter() {
			// 이동할 위도 경도 위치를 생성합니다 
			var moveLatLon = new daum.maps.LatLng(37.478855, 126.881176);

			// 지도 중심을 이동 시킵니다
			map.setCenter(moveLatLon);
		}

		//지도 확대 축소--------------------------------------------------------------------------------------
		// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
		var mapTypeControl = new daum.maps.MapTypeControl();

		// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
		// daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
		map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		var zoomControl = new daum.maps.ZoomControl();
		map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);

		//여러개 마커표시1 마커 배열 생성-----------------------------------------------------------------------
		// 지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
		daum.maps.event.addListener(map, 'click', function(mouseEvent) {
			// 클릭한 위치에 마커를 표시합니다 
			addMarker(mouseEvent.latLng);
		});

		// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
		var markers = [];

		// marker의 위치만을 가지고 있을 배열
		var markersLat = []; //위도
		var markersLng = []; //경도

		//중심좌표 마커 표시
		addMarker(new daum.maps.LatLng(37.478855, 126.881176));

		var circles = {}; // 검색될 범위에 원을 그려줌

		var overlay_mid = {}; // 중점 표시 오버레이
		var overlay_user = {}; // 유저 표시 오버레이

		//여러개 마커표시2-----------------------------------------------------------------------
		// 마커를 생성하고 지도위에 표시하는 함수입니다
		function addMarker(position) {

			// 마커를 생성합니다
			var marker = new daum.maps.Marker({
				map : map,
				position : position,
				draggable : true
			});

			//마커 드래그 가능
			marker.setDraggable(true);

			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);

			// 생성된 마커를 배열에 추가합니다
			markers.push(marker);

			//마커의 위도를 배열에 추가
			markersLat.push(marker.getPosition().getLat().toFixed(4));

			//마커의 경도를 배열에 추가
			markersLng.push(marker.getPosition().getLng().toFixed(4));
		}

		/*var draggedMarker={};
		var markerNum=0;
		
		 // ----------- 드래그 추가 된 부분 ------------//
		daum.maps.event.addListener(marker, "dragstart", function () {
		  draggedMarker.Lat = marker.getPosition().getLat().toFixed(4);
		  draggedMarker.Lng = marker.getPosition().getLng().toFixed(4);
		  for(var i=0; i<markers.length; i++) { // 드래그 되는 마커를 알기 위해
		    if(draggedMarker.Lat == markersLat[i] && draggedMarker.Lng == markersLng[i]){
		    	 markerNum = i;
		    }
		  }
		});
		
		daum.maps.event.addListener(marker, "dragend", function (){
			 markersLat[markerNum] = marker.getPosition().getLat().toFixed(4);
			 markersLng[markerNum] = marker.getPosition().getLng().toFixed(4);
			 
			 var newPos = { //드래그 된 마커의 새 위치 정보
			            newLat: markersLat[markerNum],
			            newLng: markersLng[markerNum]
			          };
			 
			 markers[markerNum]=newPos;
		}); */
		//드래그 부분 작동 x
		// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
		function setMarkers(map) {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}

		// "마커 보이기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에 표시하는 함수입니다
		function showMarkers() {
			setMarkers(map)
		}

		// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
		function hideMarkers() {
			setMarkers(null);
		}

		var midPoint = [];

		//마커의 중간지점 구하기
		function findMidPosition() {

			var tot1 = 0; //위도의 합
			var tot2 = 0; //경도의 합

			for (var i = 0; i < markers.length; i++) {
				tot1 += markersLat[i] * 1;
				tot2 += markersLng[i] * 1;

				var newPosLat = (tot1 / markers.length).toFixed(4);
				var newPosLng = (tot2 / markers.length).toFixed(4);
			}
			console.log(tot1);
			console.log(tot2);
			console.log(newPosLat);
			console.log(newPosLng);

			var midPoint = new daum.maps.LatLng(newPosLat, newPosLng);
			// 두 마커간의 중점 찍는 거
			map.setCenter(midPoint);
			addMarker(new daum.maps.LatLng(newPosLat, newPosLng));

			// 중점 마커를 중심으로 하는 원을 그려줌
			circles = new daum.maps.Circle({
				center : new daum.maps.LatLng(newPosLat, newPosLng), // 원의 중심좌표 입니다
				radius : 500, // 미터 단위의 원의 반지름입니다
				strokeWeight : 5, // 선의 두께입니다
				strokeColor : '#75B8FA', // 선의 색깔입니다
				strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				strokeStyle : 'dashed', // 선의 스타일 입니다
				fillColor : '#CFE7FF', // 채우기 색깔입니다
				fillOpacity : 0.7
			// 채우기 불투명도 입니다
			});
			// 지도에 원을 표시합니다
			circles.setMap(map);
			map.setCenter(new daum.maps.LatLng(newPosLat, newPosLng));
			map.setLevel(5);

		}
	</script>
</body>
</html>
