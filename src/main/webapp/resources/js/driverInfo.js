$(document).ready(function() {
    var  driverId = getDriverId();
    loadDriver(driverId);
    loadCompanions(driverId);
    loadWaypoints(driverId);
});

var loadedDriver;

function getDriverId() {
    var pathArray = window.location.pathname;
    pathArray = pathArray.replace('.html','').split('/');
    var driverId = pathArray[pathArray.length - 1];
    return driverId;
}

function loadDriver(driverId) {
    $.get("/driverPage/driverInfo/" + driverId, function (driver) {

        loadedDriver = driver;

        $("#idDriver").val(driverId);
        $("#waggonRegNumber").val(driver.waggon);
        $("#orderNumber").val(driver.orderNumber);

    })
}



function loadCompanions(driverId) {
    $.get("/driverPage/companions/" + driverId,function(companions){
        var companions = $('#companions');
        for(companion in companions){
            companions
                .append(
                    $('<tr />')
                        .val(companions[companion].idCompanion)
                        .text(
                            companions[companion].personalNumber + " - " +
                            companions[companion].name + " - " +
                            companions[companion].secondName
                        )

                )
        }
    })
}

function loadWaypoints(driverId) {
    $.get("/driverPage/points/" + driverId, function (waypoints) {
        var waypointSelect = $('#waypoints');

        for (waypointIndex in waypoints) {
            waypointSelect
                .append(
                    $("<tr />")
                        .val(waypoints[waypointIndex].idWayPoint)
                        .text(
                            waypoints[waypointIndex].city.city + " - " +
                            waypoints[waypointIndex].cargo.cargoNumber + " - " +
                            waypoints[waypointIndex].orderType
                        )
                )
        }
    })
}


function saveChangeDriver(){
    var driverStatus = $('#driverShiftStatus').val();
    var secondName = $('#orderCargo').val();
    var hoursWorked = $('#driverStatus').val();

    var  driverId = getDriverId();

    var driver = {
        idDriver: driverId,
        personalNumber: personalNumber,
        name: name,
        secondName: secondName,
        hoursWorked: hoursWorked,
        status: driverStatus,
        mapId: selectedCity,
        waggon: selectedWaggon
    };

    $.ajax ({
        url: "/driverPage/driverInfo" + driverId,
        type: "POST",
        data: JSON.stringify(driver),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (driver) {
            window.location.href = "/";
        }
    });

}