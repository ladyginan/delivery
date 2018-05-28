$(document).ready(function() {
    var  waggonId = getWaggonId();
    loadWaggon(waggonId);
});

var loadedWaggon;

function getWaggonId() {
    var pathArray = window.location.pathname;
    pathArray = pathArray.replace('.html','').split('/');
    var waggonId = pathArray[pathArray.length - 1];
    return waggonId;
}

function loadWaggon(waggonId) {
    $('')
    $.get("/waggons/" + waggonId, function (waggon) {

        loadedWaggon = waggon;

        $('#regNumber').val(waggon.regNumber);
        $('#shiftSize').val(waggon.shiftSize);
        $('#capacity').val(waggon.capacity);
        $('#waggonStatus').val(waggon.status);
        loadCities();
    })
}
function  loadCities() {
    $.get("/cities", function(cities){
        var citySelect = $('#cities');
        for (cityIndex in cities) {
            citySelect
                .append(
                    $('<option />')
                        .val(cities[cityIndex].idCity)
                        .text(
                            cities[cityIndex].city
                        )
                )
        }

        if (loadedWaggon) {
            citySelect.val(loadedWaggon.mapId)
        }

    })
}

function editWaggon() {
    var regNumber = $('#regNumber').val();
    var shiftSize = $('#shiftSize').val();
    var capacity = $('#capacity').val();
    var waggonStatus = $('#waggonStatus').val();
    var selectedCity = $('#cities').val();

    var waggonId = getWaggonId();

    var waggon = {
        idWaggon: waggonId,
        regNumber: regNumber,
        shiftSize: shiftSize,
        capacity: capacity,
        status: waggonStatus,
        mapId: selectedCity
    };


    $.ajax ({
        url: "/waggons/edit/" + waggonId,
        type: "POST",
        data: JSON.stringify(waggon),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (waggon) {
            window.location.href = "/welcome";
        }

    });

}

