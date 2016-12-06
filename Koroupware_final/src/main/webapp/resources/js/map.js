$(function(){
	// 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이
	var placeOverlay = new daum.maps.CustomOverlay({
		zIndex : 100
	});
	var contentNode = document.createElement('div'); // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다
	var currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다
	var resultMarkers = []; // 결과 마커를 담을 배열입니다
	var userMarkers = []; // 유저 마커를 담을 배열
	var usersPos = []; // 유저 마커의 위치만을 담을 배열
	var overlay_user_array = []; // 유저 마커의 오버레이를 저장할 배열
	var midMarkers = []; // 중점 마커를 담을 배열
	var newPosLat = 0; // 중점 마커 위치정보
	var newPosLng = 0; // 중점 마커 위치정보
	var circles = {}; // 검색될 범위에 원을 그려줌
	var overlay_mid = {}; // 중점 표시 오버레이
	var overlay_user = {}; // 유저 표시 오버레이

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new daum.maps.LatLng(37.478855, 126.881176), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	//지도 표시------------------------------------------------------------------------------------------
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new daum.maps.Map(mapContainer, mapOption);

	// 장소 검색 객체를 생성합니다
	var ps = new daum.maps.services.Places(map);

	/* function setCenter() {
		// 이동할 위도 경도 위치를 생성합니다 
		var moveLatLon = new daum.maps.LatLng(37.478855, 126.881176);

		// 지도 중심을 이동 시킵니다
		map.setCenter(moveLatLon);
	} */

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

	/* // "마커 보이기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에 표시하는 함수입니다
	function showMarkers() {
		setMarkers(map)
	}

	// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
	function hideMarkers() {
		setMarkers(null);
	} */

	var midPoint = [];

	
	$('#search_btn').on('click', findMidPosition);
	
	//마커의 중간지점 구하기
	function findMidPosition() {
		removeMarker();

		var imageSrc = ''; // 마커이미지의 주소입니다
		var imageSize = new daum.maps.Size(32, 32); // 마커이미지의 크기입니다
		var imageOption = {
			offset : new daum.maps.Point(15, 32)
		}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합다
		var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
				imageOption);

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

		var marker_mid = new daum.maps.Marker({
			map : map,
			image : markerImage
		});
		midMarkers.push(marker_mid);
		marker_mid.setPosition(new daum.maps.LatLng(newPosLat, newPosLng));
		marker_mid.setMap(map);

		// 중점마커의 인포윈도우는 커스텀 오버레이로 나타내줌
		var content = '<div class="wrap middle">'
				+ '    <div class="info">' + '        <div class="title">'
				+ '            중점' + '        </div>' + '    </div>'
				+ '</div>';
		overlay_mid = new daum.maps.CustomOverlay({
			content : content,
			map : map,
			position : marker_mid.getPosition(),
			zIndex : 10
		});
		overlay_mid.setMap(map);

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
			

	// 카테고리 검색을 요청하는 함수입니다
	function searchPlaces() {
		if (!currCategory) {
			return;
		}
		// 커스텀 오버레이를 숨깁니다
		placeOverlay.setMap(null);
		// 지도에 표시되고 있는 마커를 제거합니다
		removeMarker();
		ps.categorySearch(currCategory, placesSearchCB, {
			location : new daum.maps.LatLng(newPosLat, newPosLng),
			radius : 500
		});
		console.log("1");
	}

	// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
	function placesSearchCB(status, data, pagination) {
		if (status === daum.maps.services.Status.OK) {
			// 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
			displayPlaces(data.places);
		} else if (status === daum.maps.services.Status.ZERO_RESULT) {
			// 검색결과가 없는경우 
			alert("검색 결과가 없습니다!");
		} else if (status === daum.maps.services.Status.ERROR) {
			// 에러로 인해 검색결과가 나오지 않은 경우 
			alert("ERROR!!");
		}
		console.log("2");
	}
	// 지도에 마커를 표출하는 함수입니다
	function displayPlaces(places) {
		// 몇번째 카테고리가 선택되어 있는지 얻어옵니다
		// 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
		var order = document.getElementById(currCategory).getAttribute(
				'data-order');
		for (var i = 0; i < places.length; i++) {
			// 마커를 생성하고 지도에 표시합니다
			var marker = addMarkerCate(new daum.maps.LatLng(
					places[i].latitude, places[i].longitude), order);
			// 마커와 검색결과 항목을 클릭 했을 때
			// 장소정보를 표출하도록 클릭 이벤트를 등록합니다
			(function(marker, place) {
				daum.maps.event.addListener(marker, 'click', function() {
					displayPlaceInfo(place);
				});
			})(marker, places[i]);
		}
		console.log("3");
	}
	// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
	function addMarkerCate(position, order) {
		var imageSrc = 'http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
		imageSize = new daum.maps.Size(27, 28), // 마커 이미지의 크기
		imgOptions = {
			spriteSize : new daum.maps.Size(72, 208), // 스프라이트 이미지의 크기
			spriteOrigin : new daum.maps.Point(46, (order * 36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
			offset : new daum.maps.Point(11, 28)
		// 마커 좌표에 일치시킬 이미지 내에서의 좌표
		}, markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
				imgOptions), marker = new daum.maps.Marker({
			position : position, // 마커의 위치
			image : markerImage
		});
		
		marker.setMap(map); // 지도 위에 마커를 표출합니다			
		resultMarkers.push(marker); // 배열에 생성된 마커를 추가합니다
		return marker;
	} 
	
	
	
	// 지도 위에 표시되고 있는 마커를 모두 제거합니다
	function removeMarker() {
		for (var i = 0; i < resultMarkers.length; i++) {
			resultMarkers[i].setMap(null);
		}
		resultMarkers = [];
	}
	// 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
	function displayPlaceInfo(place) {
		var content = '<div class="placeinfo">'
				+ '   <a class="title" href="' + place.placeUrl + '" target="_blank" title="' + place.title + '">'
				+ place.title + '</a>';
		if (place.newAddress) {
			content += '    <span title="' + place.newAddress + '">'
					+ place.newAddress
					+ '</span>'
					+ '  <span class="jibun" title="' + place.address + '">(지번 : '
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
	
	// 커스텀 오버레이 컨텐츠를 설정합니다
	placeOverlay.setContent(contentNode); 
	
	// 각 카테고리에 클릭 이벤트를 등록합니다
	addCategoryClickEvent();
	
	 // 각 카테고리에 클릭 이벤트를 등록합니다
	function addCategoryClickEvent() {
		console.log("5");
		var category = document.getElementById('category'), children = category.children;
		console.log("5");
		for (var i = 0; i < children.length; i++) {
			children[i].onclick = onClickCategory;
		}
		console.log("5");
	}
	 
	// 카테고리를 클릭했을 때 호출되는 함수입니다
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
	
	// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
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
});