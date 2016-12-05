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
<!-- api key �� -->
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=	92bef817e206b1f4c06f9d6ccdf1ca20"></script>
<title>����</title>
</head>
<body>

	<div id="map" style="width: 500px; height: 400px;"></div>
	<input type="button" onclick="findMidPosition();" value="submit">

	<!-- ���� �ҷ����� -->
	<script>
		var container = document.getElementById('map'); //������ ���� ������ DOM ���۷���
		var options = { //������ ������ �� �ʿ��� �⺻ �ɼ�
			center : new daum.maps.LatLng(37.478855, 126.881176), //������ �߽���ǥ.
			level : 3
		//������ ����(Ȯ��, ��� ����)
		};
		var map = new daum.maps.Map(container, options); //���� ���� �� ��ü ����

		var markers = [];

		if (navigator.geolocation) {
			// GeoLocation�� �̿��ؼ� ���� ��ġ�� ���ɴϴ�
			navigator.geolocation.getCurrentPosition(function(position) {
				var lat = position.coords.latitude; // ����
				var lon = position.coords.longitude; // �浵
				var locPosition = new daum.maps.LatLng(lat, lon); // ��Ŀ�� ǥ�õ� ��ġ�� geolocation���� ���� ��ǥ�� �����մϴ�
				var message = '<div style="padding:5px;">���� ��ġ</div>'; // ���������쿡 ǥ�õ� �����Դϴ�
				// ��Ŀ�� ���������츦 ǥ���մϴ�
				displayMarker(locPosition, message);
			});
		} else { // HTML5�� GeoLocation�� ����� �� ������ ��Ŀ ǥ�� ��ġ�� ���������� ������ �����մϴ�
			var locPosition = new daum.maps.LatLng(37.478855, 126.881176);
			var message = "geolocation�� ����Ҽ� �����..";
			displayMarker(locPosition, message);
		}

		function displayMarker(locPosition, message) {

			// ��Ŀ�� �����մϴ�
			var marker = new daum.maps.Marker({
				map : map,
				position : locPosition
			});

			var iwContent = message, // ���������쿡 ǥ���� ����
			iwRemoveable = true;

			// ���������츦 �����մϴ�
			var infowindow = new daum.maps.InfoWindow({
				content : iwContent,
				removable : iwRemoveable
			});

			// ���������츦 ��Ŀ���� ǥ���մϴ� 
			infowindow.open(map, marker);

			// ���� �߽���ǥ�� ������ġ�� �����մϴ�
			map.setCenter(locPosition);

			// ��Ŀ�� �巡�� �����ϵ��� �����մϴ� 
			marker.setDraggable(true);
		}

		// ��Ŀ�� �����ϰ� �������� ǥ���ϴ� �Լ��Դϴ�
		function addMarker(position) {
			var marker = new daum.maps.Marker({
				map : map,
				position : position,
				draggable : true
			// �巡�� �����ϰ�
			});
			var markerPos = { // ��Ŀ�� ��ġ ����
				newLat : position.getLat().toFixed(4),
				newLng : position.getLng().toFixed(4)
			};
			var iwContent = new daum.maps.InfoWindow({
				position : position,
				content : "��Ŀ�� ��ġ�� " + position.getLat().toFixed(4) + ","
						+ position.getLng().toFixed(4) + "�Դϴ�.",
				removable : true
			});
			// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
			marker.setMap(map);
			iwContent.open(map, marker);
			// ������ ��Ŀ�� �迭�� �߰��մϴ�
			markers.push(marker);
			iwContents.push(iwContent);
			markersPos.push(markerPos);
			var draggedMarker = {};
			var markerNum = 0;

			// ----------- �巡�� �߰� �� �κ� ------------//
			daum.maps.event.addListener(marker, 'dragstart', function() {
				draggedMarker.Lat = marker.getPosition().getLat().toFixed(4);
				draggedMarker.Lng = marker.getPosition().getLng().toFixed(4);
				for (var i = 0; i < markersPos.length; i++) { // �巡�� �Ǵ� ��Ŀ�� �˱� ����
					if (draggedMarker.Lat == markersPos[i].newLat
							&& draggedMarker.Lng == markersPos[i].newLng) {
						markerNum = i;
					}
				}
			});
			daum.maps.event.addListener(marker, 'dragend', function() {
				// ��� ��Ŀ�� �巡�װ� ����� �� ������������ ������ �ٲ��ָ鼭 ������ ����������� �ݰ� �� ��ġ�� â�� �����ݴϴ�
				iwContent.close(map, marker); // ������ ���������� �ݱ�
				iwContent = new daum.maps.InfoWindow(
						{ // ���� ������ ���� �ٲٱ��
							position : marker.getPosition(),
							content : "��Ŀ�� ��ġ�� "
									+ marker.getPosition().getLat().toFixed(4)
									+ ","
									+ marker.getPosition().getLng().toFixed(4)
									+ "�Դϴ�.",
							removable : true
						});
				var newPos = { //�巡�� �� ��Ŀ�� �� ��ġ ����
					newLat : marker.getPosition().getLat().toFixed(4),
					newLng : marker.getPosition().getLng().toFixed(4)
				};
				markersPos[markerNum] = newPos;
				iwContent.open(map, marker); //�� �������� ����
				iwContents[markerNum] = iwContent; // �� ���� ����
			});
		}

		function setMarkers(map) {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}

		function findMidPosition() {
			// ��ư ������ �� ������ ������ ã��
			if (markersPos.length != 2) {
				alert("������ ��Ŀ�� �ΰ� ����ּ���");
			} else {
				// ���� ����ϱ�
				var marker1Lat = markersPos[0].newLat * 1;
				var marker1Lng = markersPos[0].newLng * 1;
				var marker2Lat = markersPos[1].newLat * 1;
				var marker2Lng = markersPos[1].newLng * 1;
				var newPosLat = ((marker1Lat + marker2Lat) / 2).toFixed(4);
				var newPosLng = ((marker1Lng + marker2Lng) / 2).toFixed(4);
				$('.position_mid').text(newPosLat + "," + newPosLng);
				// �� ��Ŀ���� ���� ��� ��
				var marker = new daum.maps.Marker({
					map : map
				});

				// ----------- �߰� �� �κ� ------------//
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
