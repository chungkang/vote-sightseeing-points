// 내비게이션바 버튼 활성화
$("#navMap").attr('class', '');
$("#navLists").attr('class', 'active');
$("#navAdd").attr('class', '');

// 관광 포인트 지도에 출력
const point = JSON.parse($('#pointJSON').val());

let latitude = point.location.split(" ")[0]; //위도
let longitude = point.location.split(" ")[1]; //경도

// 지도 컨테이너 생성
const mymap = L.map('mapid', {
    center: [latitude, longitude],
    zoom: 9
});

// 지도 표시
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors' //화면 오른쪽 하단 attributors
}).addTo(mymap);

let marker = L.marker([latitude, longitude], {draggable : true}).addTo(mymap);


