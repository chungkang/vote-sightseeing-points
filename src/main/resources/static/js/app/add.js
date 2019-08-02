// 내비게이션바 버튼 활성화
$("#navMap").attr('class', '');
$("#navLists").attr('class', '');
$("#navAdd").attr('class', 'active');

let lat = 36.1358642; //위도
let lng = 128.0785804; //경도

// 지도 컨테이너 생성
const mymap = L.map('mapid', {
    center: [lat, lng],
    zoom: 9
});

// 지도 표시
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors' //화면 오른쪽 하단 attributors
}).addTo(mymap);

// 현재위치 구하기
navigator.geolocation.getCurrentPosition(function(location) {
    lat = location.coords.latitude;
    lng = location.coords.longitude;

    L.marker([lat, lng], {draggable : true}).addTo(mymap);
});