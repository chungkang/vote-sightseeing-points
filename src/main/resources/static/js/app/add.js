// 내비게이션바 버튼 활성화
$("#navMap").attr('class', '');
$("#navLists").attr('class', '');
$("#navAdd").attr('class', 'active');

let latitude; //위도
let longitude; //경도
let marker;

// 현재위치 구하기
navigator.geolocation.getCurrentPosition(function(location) {
    latitude = location.coords.latitude;
    longitude = location.coords.longitude;

    // 지도 컨테이너 생성
    const mymap = L.map('mapid', {
        center: [latitude, longitude],
        zoom: 17
    });

    // 지도 표시
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors' //화면 오른쪽 하단 attributors
    }).addTo(mymap);

    marker = L.marker([latitude, longitude], {draggable : true}).addTo(mymap);
});

let authorIP;
// IP 얻기
$(function() {$.getJSON("https://api.ipify.org?format=jsonp&callback=?", function(json) { authorIP = json.ip; });});

// 등록요청
const add = {
    init : function () {
        const _this = this;
        $('#btn-add').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            name: $('#name').val(),
            location: marker.getLatLng().lat + ' ' + marker.getLatLng().lng,
            memo: $('#memo').val(),
            author: authorIP
        };

        $.ajax({
            type: 'POST',
            url: '/add',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('등록 요청되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

add.init();
