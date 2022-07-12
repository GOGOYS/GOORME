	const rootPath = "${rootPath}"
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(35.160010812082966, 126.9102089290472),
		level: 4
	};

	var map = new kakao.maps.Map(container, options);
	
	
	 // 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map); 

	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);		   
	    
	    document.getElementById('mapx').value = latlng.getLat(); 
	    
	    document.getElementById('mapy').value = latlng.getLng(); 
	    
	    //input 박스 나타내기
	    document.querySelector('.input-form').style.display = "block";
	    
	});
	
	//input 박스 투명도로 숨기기
	var btn_close = document.querySelector('.btn-close')
	
	btn_close.addEventListener("click",()=>{
		document.querySelector('.input-form').style.display = "none";
	});
	
	var mapX = ${arrMapX}
	var mapY = ${arrMapY}
	var icon = ${arrIcon}
	

	// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
	var markers = [];
	


	// 마커 하나를 지도위에 표시합니다 
	for(var i = 0; i < mapX.length; i++){	
		 var imageSrc = '${rootPath}' + icon[i],  
    	imageSize = new kakao.maps.Size(64, 30), // 마커이미지의 크기입니다
    	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		addMarker(new kakao.maps.LatLng(mapX[i], mapY[i]), markerImage);
	}
		
	function addMarker(position, markerImage) {
	    
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        position: position
	        image: markerImage
	    });

	    // 마커가 지도 위에 표시되도록 설정합니다
	    marker.setMap(map);
	    
	    // 생성된 마커를 배열에 추가합니다
	    markers.push(marker);
	}
	
