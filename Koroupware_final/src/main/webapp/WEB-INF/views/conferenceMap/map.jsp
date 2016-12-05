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
	font-family: 'Malgun Gothic', dotum, '����', sans-serif;
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
			<li id="SW8"><span class="category_bg subway"></span> ����ö</li>
			<li id="CE7"><span class="category_bg cafe"></span> ī��</li>
		</ul>
	</div>

	<!-- ������ ǥ���� div �Դϴ� -->
	<p>
		<button onclick="setCenter()">���� �߽���ǥ �̵���Ű��</button>
	</p>
	<p>
		<button onclick="hideMarkers()">��Ŀ ���߱�</button>
		<button onclick="showMarkers()">��Ŀ ���̱�</button>
	</p>
	<p>
		<button onclick="findMidPosition()">�߰����� Ž��</button>
	</p>



	<script type="text/javascript"
		src="//apis.daum.net/maps/maps3.js?apikey=92bef817e206b1f4c06f9d6ccdf1ca20&libraries=services"></script>
	<script>
		// ��Ŀ�� Ŭ������ �� �ش� ����� �������� ������ Ŀ���ҿ�������
		var placeOverlay = new daum.maps.CustomOverlay({
			zIndex : 100
		});
		var contentNode = document.createElement('div'); // Ŀ���� ���������� ������ ������Ʈ �Դϴ�
		var currCategory = ''; // ���� ���õ� ī�װ��� ������ ���� �����Դϴ�
		var resultMarkers = []; // ��� ��Ŀ�� ���� �迭�Դϴ�
		var userMarkers = []; // ���� ��Ŀ�� ���� �迭
		var usersPos = []; // ���� ��Ŀ�� ��ġ���� ���� �迭
		var overlay_user_array = []; // ���� ��Ŀ�� �������̸� ������ �迭
		var midMarkers = []; // ���� ��Ŀ�� ���� �迭
		var newPosLat = 0; // ���� ��Ŀ ��ġ����
		var newPosLng = 0; // ���� ��Ŀ ��ġ����
		var circles = {}; // �˻��� ������ ���� �׷���
		var overlay_mid = {}; // ���� ǥ�� ��������
		var overlay_user = {}; // ���� ǥ�� ��������

		var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
		mapOption = {
			center : new daum.maps.LatLng(37.478855, 126.881176), // ������ �߽���ǥ
			level : 3
		// ������ Ȯ�� ����
		};

		//���� ǥ��------------------------------------------------------------------------------------------
		// ������ ǥ���� div��  ���� �ɼ�����  ������ �����մϴ�
		var map = new daum.maps.Map(mapContainer, mapOption);

		// ��� �˻� ��ü�� �����մϴ�
		var ps = new daum.maps.services.Places(map);

		function setCenter() {
			// �̵��� ���� �浵 ��ġ�� �����մϴ� 
			var moveLatLon = new daum.maps.LatLng(37.478855, 126.881176);

			// ���� �߽��� �̵� ��ŵ�ϴ�
			map.setCenter(moveLatLon);
		}

		//���� Ȯ�� ���--------------------------------------------------------------------------------------
		// �Ϲ� ������ ��ī�̺�� ���� Ÿ���� ��ȯ�� �� �ִ� ����Ÿ�� ��Ʈ���� �����մϴ�
		var mapTypeControl = new daum.maps.MapTypeControl();

		// ������ ��Ʈ���� �߰��ؾ� �������� ǥ�õ˴ϴ�
		// daum.maps.ControlPosition�� ��Ʈ���� ǥ�õ� ��ġ�� �����ϴµ� TOPRIGHT�� ������ ���� �ǹ��մϴ�
		map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

		// ���� Ȯ�� ��Ҹ� ������ �� �ִ�  �� ��Ʈ���� �����մϴ�
		var zoomControl = new daum.maps.ZoomControl();
		map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);

		//������ ��Ŀǥ��1 ��Ŀ �迭 ����-----------------------------------------------------------------------
		// ������ Ŭ�������� Ŭ���� ��ġ�� ��Ŀ�� �߰��ϵ��� ������ Ŭ���̺�Ʈ�� ����մϴ�
		daum.maps.event.addListener(map, 'click', function(mouseEvent) {
			// Ŭ���� ��ġ�� ��Ŀ�� ǥ���մϴ� 
			addMarker(mouseEvent.latLng);
		});

		// ������ ǥ�õ� ��Ŀ ��ü�� ������ ���� �迭�Դϴ�
		var markers = [];

		// marker�� ��ġ���� ������ ���� �迭
		var markersLat = []; //����
		var markersLng = []; //�浵

		//�߽���ǥ ��Ŀ ǥ��
		addMarker(new daum.maps.LatLng(37.478855, 126.881176));

		var circles = {}; // �˻��� ������ ���� �׷���

		var overlay_mid = {}; // ���� ǥ�� ��������
		var overlay_user = {}; // ���� ǥ�� ��������

		//������ ��Ŀǥ��2-----------------------------------------------------------------------
		// ��Ŀ�� �����ϰ� �������� ǥ���ϴ� �Լ��Դϴ�
		function addMarker(position) {

			// ��Ŀ�� �����մϴ�
			var marker = new daum.maps.Marker({
				map : map,
				position : position,
				draggable : true
			});

			//��Ŀ �巡�� ����
			marker.setDraggable(true);

			// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
			marker.setMap(map);

			// ������ ��Ŀ�� �迭�� �߰��մϴ�
			markers.push(marker);

			//��Ŀ�� ������ �迭�� �߰�
			markersLat.push(marker.getPosition().getLat().toFixed(4));

			//��Ŀ�� �浵�� �迭�� �߰�
			markersLng.push(marker.getPosition().getLng().toFixed(4));
		}

		/*var draggedMarker={};
		var markerNum=0;
		
		 // ----------- �巡�� �߰� �� �κ� ------------//
		daum.maps.event.addListener(marker, "dragstart", function () {
		  draggedMarker.Lat = marker.getPosition().getLat().toFixed(4);
		  draggedMarker.Lng = marker.getPosition().getLng().toFixed(4);
		  for(var i=0; i<markers.length; i++) { // �巡�� �Ǵ� ��Ŀ�� �˱� ����
		    if(draggedMarker.Lat == markersLat[i] && draggedMarker.Lng == markersLng[i]){
		    	 markerNum = i;
		    }
		  }
		});
		
		daum.maps.event.addListener(marker, "dragend", function (){
			 markersLat[markerNum] = marker.getPosition().getLat().toFixed(4);
			 markersLng[markerNum] = marker.getPosition().getLng().toFixed(4);
			 
			 var newPos = { //�巡�� �� ��Ŀ�� �� ��ġ ����
			            newLat: markersLat[markerNum],
			            newLng: markersLng[markerNum]
			          };
			 
			 markers[markerNum]=newPos;
		}); */
		//�巡�� �κ� �۵� x
		// �迭�� �߰��� ��Ŀ���� ������ ǥ���ϰų� �����ϴ� �Լ��Դϴ�
		function setMarkers(map) {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}

		// "��Ŀ ���̱�" ��ư�� Ŭ���ϸ� ȣ��Ǿ� �迭�� �߰��� ��Ŀ�� ������ ǥ���ϴ� �Լ��Դϴ�
		function showMarkers() {
			setMarkers(map)
		}

		// "��Ŀ ���߱�" ��ư�� Ŭ���ϸ� ȣ��Ǿ� �迭�� �߰��� ��Ŀ�� �������� �����ϴ� �Լ��Դϴ�
		function hideMarkers() {
			setMarkers(null);
		}

		var midPoint = [];

		//��Ŀ�� �߰����� ���ϱ�
		function findMidPosition() {
			removeMarker();

			var imageSrc = ''; // ��Ŀ�̹����� �ּ��Դϴ�
			var imageSize = new daum.maps.Size(32, 32); // ��Ŀ�̹����� ũ���Դϴ�
			var imageOption = {
				offset : new daum.maps.Point(15, 32)
			}; // ��Ŀ�̹����� �ɼ��Դϴ�. ��Ŀ�� ��ǥ�� ��ġ��ų �̹��� �ȿ����� ��ǥ�� �����մϴ�.
			// ��Ŀ�� �̹��������� ������ �ִ� ��Ŀ�̹����� �����մ�
			var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
					imageOption);

			var tot1 = 0; //������ ��
			var tot2 = 0; //�浵�� ��

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
			// �� ��Ŀ���� ���� ��� ��
			map.setCenter(midPoint);
			addMarker(new daum.maps.LatLng(newPosLat, newPosLng));

			var marker_mid = new daum.maps.Marker({
				map : map,
				image : markerImage
			});
			midMarkers.push(marker_mid);
			marker_mid.setPosition(new daum.maps.LatLng(newPosLat, newPosLng));
			marker_mid.setMap(map);

			// ������Ŀ�� ����������� Ŀ���� �������̷� ��Ÿ����
			var content = '<div class="wrap middle">'
					+ '    <div class="info">' + '        <div class="title">'
					+ '            ����' + '        </div>' + '    </div>'
					+ '</div>';
			overlay_mid = new daum.maps.CustomOverlay({
				content : content,
				map : map,
				position : marker_mid.getPosition(),
				zIndex : 10
			});
			overlay_mid.setMap(map);

			// ���� ��Ŀ�� �߽����� �ϴ� ���� �׷���
			circles = new daum.maps.Circle({
				center : new daum.maps.LatLng(newPosLat, newPosLng), // ���� �߽���ǥ �Դϴ�
				radius : 500, // ���� ������ ���� �������Դϴ�
				strokeWeight : 5, // ���� �β��Դϴ�
				strokeColor : '#75B8FA', // ���� �����Դϴ�
				strokeOpacity : 1, // ���� ������ �Դϴ� 1���� 0 ������ ���̸� 0�� �������� �����մϴ�
				strokeStyle : 'dashed', // ���� ��Ÿ�� �Դϴ�
				fillColor : '#CFE7FF', // ä��� �����Դϴ�
				fillOpacity : 0.7
			// ä��� ������ �Դϴ�
			});
			// ������ ���� ǥ���մϴ�
			circles.setMap(map);
			map.setCenter(new daum.maps.LatLng(newPosLat, newPosLng));
			map.setLevel(5);
		}
				

		// ī�װ� �˻��� ��û�ϴ� �Լ��Դϴ�
		function searchPlaces() {
			if (!currCategory) {
				return;
			}
			// Ŀ���� �������̸� ����ϴ�
			placeOverlay.setMap(null);
			// ������ ǥ�õǰ� �ִ� ��Ŀ�� �����մϴ�
			removeMarker();
			ps.categorySearch(currCategory, placesSearchCB, {
				location : new daum.maps.LatLng(newPosLat, newPosLng),
				radius : 500
			});
			console.log("1");
		}

		// ��Ұ˻��� �Ϸ���� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
		function placesSearchCB(status, data, pagination) {
			if (status === daum.maps.services.Status.OK) {
				// ���������� �˻��� �Ϸ������ ������ ��Ŀ�� ǥ���մϴ�
				displayPlaces(data.places);
			} else if (status === daum.maps.services.Status.ZERO_RESULT) {
				// �˻������ ���°�� 
				alert("�˻� ����� �����ϴ�!");
			} else if (status === daum.maps.services.Status.ERROR) {
				// ������ ���� �˻������ ������ ���� ��� 
				alert("ERROR!!");
			}
			console.log("2");
		}
		// ������ ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
		function displayPlaces(places) {
			// ���° ī�װ��� ���õǾ� �ִ��� ���ɴϴ�
			// �� ������ ��������Ʈ �̹��������� ��ġ�� ����ϴµ� ���˴ϴ�
			var order = document.getElementById(currCategory).getAttribute(
					'data-order');
			for (var i = 0; i < places.length; i++) {
				// ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
				var marker = addMarkerCate(new daum.maps.LatLng(
						places[i].latitude, places[i].longitude), order);
				// ��Ŀ�� �˻���� �׸��� Ŭ�� ���� ��
				// ��������� ǥ���ϵ��� Ŭ�� �̺�Ʈ�� ����մϴ�
				(function(marker, place) {
					daum.maps.event.addListener(marker, 'click', function() {
						displayPlaceInfo(place);
					});
				})(marker, places[i]);
			}
			console.log("3");
		}
		// ��Ŀ�� �����ϰ� ���� ���� ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
		function addMarkerCate(position, order) {
			var imageSrc = 'http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // ��Ŀ �̹��� url, ��������Ʈ �̹����� ���ϴ�
			imageSize = new daum.maps.Size(27, 28), // ��Ŀ �̹����� ũ��
			imgOptions = {
				spriteSize : new daum.maps.Size(72, 208), // ��������Ʈ �̹����� ũ��
				spriteOrigin : new daum.maps.Point(46, (order * 36)), // ��������Ʈ �̹��� �� ����� ������ �»�� ��ǥ
				offset : new daum.maps.Point(11, 28)
			// ��Ŀ ��ǥ�� ��ġ��ų �̹��� �������� ��ǥ
			}, markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
					imgOptions), marker = new daum.maps.Marker({
				position : position, // ��Ŀ�� ��ġ
				image : markerImage
			});
			
			marker.setMap(map); // ���� ���� ��Ŀ�� ǥ���մϴ�			
			resultMarkers.push(marker); // �迭�� ������ ��Ŀ�� �߰��մϴ�
			return marker;
		} 
		
		
		
		// ���� ���� ǥ�õǰ� �ִ� ��Ŀ�� ��� �����մϴ�
		function removeMarker() {
			for (var i = 0; i < resultMarkers.length; i++) {
				resultMarkers[i].setMap(null);
			}
			resultMarkers = [];
		}
		// Ŭ���� ��Ŀ�� ���� ��� �������� Ŀ���� �������̷� ǥ���ϴ� �Լ��Դϴ�
		function displayPlaceInfo(place) {
			var content = '<div class="placeinfo">'
					+ '   <a class="title" href="' + place.placeUrl + '" target="_blank" title="' + place.title + '">'
					+ place.title + '</a>';
			if (place.newAddress) {
				content += '    <span title="' + place.newAddress + '">'
						+ place.newAddress
						+ '</span>'
						+ '  <span class="jibun" title="' + place.address + '">(���� : '
						+ place.address + ')</span>';
			} else {
				content += '    <span title="' + place.address + '">'
						+ place.address + '</span>';
			}
			content += '    <span class="tel">' + place.phone + '</span>'
					+ '</div>' + '<div class="after"></div>';
			contentNode.innerHTML = content;
			placeOverlay.setPosition(new daum.maps.LatLng(place.latitude,
					place.longitude));
			placeOverlay.setMap(map);
		} 
		
		// Ŀ���� �������� �������� �����մϴ�
		placeOverlay.setContent(contentNode); 
		
		// �� ī�װ��� Ŭ�� �̺�Ʈ�� ����մϴ�
		addCategoryClickEvent();
		
		 // �� ī�װ��� Ŭ�� �̺�Ʈ�� ����մϴ�
		function addCategoryClickEvent() {
			console.log("5");
			var category = document.getElementById('category'), children = category.children;
			console.log("5");
			for (var i = 0; i < children.length; i++) {
				children[i].onclick = onClickCategory;
			}
			console.log("5");
		}
		 
		// ī�װ��� Ŭ������ �� ȣ��Ǵ� �Լ��Դϴ�
		function onClickCategory() {
			var id = this.id, className = this.className;
			placeOverlay.setMap(null);
			if (className === 'on') {
				currCategory = '';
				changeCategoryClass();
				removeMarker();
			} else {
				currCategory = id;
				changeCategoryClass(this);
				searchPlaces();
			}
			console.log("6");
		}
		
		// Ŭ���� ī�װ����� Ŭ���� ��Ÿ���� �����ϴ� �Լ��Դϴ�
		function changeCategoryClass(el) {
			var category = document.getElementById('category'), children = category.children, i;
			for (i = 0; i < children.length; i++) {
				children[i].className = '';
			}
			if (el) {
				el.className = 'on';
			}
			console.log("7");
		}
		
	</script>
</body>
</html>
