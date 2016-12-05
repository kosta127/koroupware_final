<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- printTool -->
<script src="/resources/printTool/jQuery.print.js"></script>
<!-- api key 값 -->
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=	92bef817e206b1f4c06f9d6ccdf1ca20"></script>
<title>지도</title>
</head>
<body>

	<div id="map" style="width: 500px; height: 400px;"></div>
	<input type="button" onclick="findMidPosition();" value="submit">

	<!-- 지도 불러오기 -->
	<script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new daum.maps.LatLng(37.478855, 126.881176), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};
		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

		var markers = [];

		if (navigator.geolocation) {
			// GeoLocation을 이용해서 접속 위치를 얻어옵니다
			navigator.geolocation.getCurrentPosition(function(position) {
				var lat = position.coords.latitude; // 위도
				var lon = position.coords.longitude; // 경도
				var locPosition = new daum.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
				var message = '<div style="padding:5px;">현재 위치</div>'; // 인포윈도우에 표시될 내용입니다
				// 마커와 인포윈도우를 표시합니다
				displayMarker(locPosition, message);
			});
		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
			var locPosition = new daum.maps.LatLng(37.478855, 126.881176);
			var message = "geolocation을 사용할수 없어요..";
			displayMarker(locPosition, message);
		}

		function displayMarker(locPosition, message) {

			// 마커를 생성합니다
			var marker = new daum.maps.Marker({
				map : map,
				position : locPosition
			});

			var iwContent = message, // 인포윈도우에 표시할 내용
			iwRemoveable = true;

			// 인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({
				content : iwContent,
				removable : iwRemoveable
			});

			// 인포윈도우를 마커위에 표시합니다 
			infowindow.open(map, marker);

			// 지도 중심좌표를 접속위치로 변경합니다
			map.setCenter(locPosition);

			// 마커가 드래그 가능하도록 설정합니다 
			marker.setDraggable(true);
		}

		// 마커를 생성하고 지도위에 표시하는 함수입니다
		function addMarker(position) {
			var marker = new daum.maps.Marker({
				map : map,
				position : position,
				draggable : true
			// 드래그 가능하게
			});
			var markerPos = { // 마커의 위치 정보
				newLat : position.getLat().toFixed(4),
				newLng : position.getLng().toFixed(4)
			};
			var iwContent = new daum.maps.InfoWindow({
				position : position,
				content : "마커의 위치는 " + position.getLat().toFixed(4) + ","
						+ position.getLng().toFixed(4) + "입니다.",
				removable : true
			});
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			iwContent.open(map, marker);
			// 생성된 마커를 배열에 추가합니다
			markers.push(marker);
			iwContents.push(iwContent);
			markersPos.push(markerPos);
			var draggedMarker = {};
			var markerNum = 0;

			// ----------- 드래그 추가 된 부분 ------------//
			daum.maps.event.addListener(marker, 'dragstart', function() {
				draggedMarker.Lat = marker.getPosition().getLat().toFixed(4);
				draggedMarker.Lng = marker.getPosition().getLng().toFixed(4);
				for (var i = 0; i < markersPos.length; i++) { // 드래그 되는 마커를 알기 위해
					if (draggedMarker.Lat == markersPos[i].newLat
							&& draggedMarker.Lng == markersPos[i].newLng) {
						markerNum = i;
					}
				}
			});
			daum.maps.event.addListener(marker, 'dragend', function() {
				// 출발 마커의 드래그가 종료될 때 인포윈도우의 내용을 바꿔주면서 기존의 인포윈도우는 닫고 새 위치에 창을 열어줍니다
				iwContent.close(map, marker); // 기존의 인포윈도우 닫기
				iwContent = new daum.maps.InfoWindow(
						{ // 인포 윈도우 내용 바꾸기기
							position : marker.getPosition(),
							content : "마커의 위치는 "
									+ marker.getPosition().getLat().toFixed(4)
									+ ","
									+ marker.getPosition().getLng().toFixed(4)
									+ "입니다.",
							removable : true
						});
				var newPos = { //드래그 된 마커의 새 위치 정보
					newLat : marker.getPosition().getLat().toFixed(4),
					newLng : marker.getPosition().getLng().toFixed(4)
				};
				markersPos[markerNum] = newPos;
				iwContent.open(map, marker); //새 내용으로 오픈
				iwContents[markerNum] = iwContent; // 새 내용 삽입
			});
		}

		function setMarkers(map) {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}

		function findMidPosition() {
			// 버튼 누르면 두 지점의 중점을 찾음
			if (markersPos.length != 2) {
				alert("지도에 마커를 두개 찍어주세용");
			} else {
				// 중점 계산하기
				var marker1Lat = markersPos[0].newLat * 1;
				var marker1Lng = markersPos[0].newLng * 1;
				var marker2Lat = markersPos[1].newLat * 1;
				var marker2Lng = markersPos[1].newLng * 1;
				var newPosLat = ((marker1Lat + marker2Lat) / 2).toFixed(4);
				var newPosLng = ((marker1Lng + marker2Lng) / 2).toFixed(4);
				$('.position_mid').text(newPosLat + "," + newPosLng);
				// 두 마커간의 중점 찍는 거
				var marker = new daum.maps.Marker({
					map : map
				});

				// ----------- 추가 된 부분 ------------//
				if (midPoint.length == 1) {
					midPoint[0].setMap(null);
					midPoint.pop();
				}
				midPoint.push(marker);
				marker.setPosition(new daum.maps.LatLng(newPosLat, newPosLng));
				marker.setMap(map);
			}
		}
	</script>

</body>
</html>
