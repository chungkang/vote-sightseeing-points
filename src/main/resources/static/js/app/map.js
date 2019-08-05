// 내비게이션바 버튼 활성화
$("#navMap").attr('class', 'active');
$("#navLists").attr('class', '');
$("#navAdd").attr('class', '');

let lat; //위도
let lng; //경도
let mymap;

// 현재위치 구하기
navigator.geolocation.getCurrentPosition(function(location) {
    lat = location.coords.latitude;
    lng = location.coords.longitude;

    // 지도 컨테이너 생성
    mymap = L.map('mapid', {
        center: [lat, lng],
        zoom: 12
    });

    // 지도 표시
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors' //화면 오른쪽 하단 attributors
    }).addTo(mymap);

    // 관광 포인트 지도에 출력
    const points = JSON.parse($('#pointsJSON').val());
    const pointsLength = points.length;
    for (let i=0; i<pointsLength; i++) {
        let latitude = points[i].location.split(" ")[0];
        let longitude = points[i].location.split(" ")[1];
        (function () {
            eval(
                `const marker${i} = L.marker([${latitude}, ${longitude}]).addTo(mymap);
            marker${i}.bindPopup("<a href='/detail/${points[i].point_no}'>${points[i].name}</a>");
            `
            );
        })();
    }
});