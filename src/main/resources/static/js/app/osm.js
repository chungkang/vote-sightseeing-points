
// var mymap = L.map('mapid').setView([51.505, -0.09], 13);
// L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
//     attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
//     maxZoom: 18,
//     id: 'mapbox.streets',
//     accessToken: 'your.mapbox.access.token'
// }).addTo(mymap);

var map = L.map('mapid').setView([37.5,127],11);

var osm = L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',{
    attribution:'&copy; <a href="http://openstreetmap.org">OpenStreetMap</a> Contributors'
}).addTo(map);

var marker = L.marker([37.5, 127],{
    draggable: true
}).addTo(map);

marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();

function dragEnd(e) {
    alert("Drag ended the map" + marker.getLatLng().toString());
}

marker.on('dragend', dragEnd);

// var popup = L.popup()
//     .setLatLng([37.4, 127.5])
//     .setContent("I am a standalone popup.")
//     .openOn(map);

var popup = L.popup();

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("You clicked the map at " + e.latlng.toString())
        .openOn(map);
}

map.on('click', onMapClick);