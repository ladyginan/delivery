$(document).ready(function() {
    var  driverId = getDriverId();
    loadDriver(driverId);

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

        $("#personalNumber").val(driver.personalNumber).text(driver.personalNumber);
        var somethingToLook1 = $("#personalNumber");
        $("#waggonRegNumber").val(driver.waggon).text(driver.waggon);
        var somethingToLook2 = $("#waggonRegNumber");
        $("#orderNumber").val(driver.idOrder).text(driver.idOrder);

        loadCompanions(driverId);
        loadWaypoints(driverId);
    })
}



function loadCompanions(driverId) {
    $.get("/driverPage/companions/" + driverId,function(companions){
        var companionsTarget = $('#companions');
        for(companion in companions){
            companionsTarget
                .append(
                    $('<p />')
                        .val(companions[companion].idDriver)
                        .text(
                            companions[companion].personalNumber + " - " +
                            companions[companion].name + "   " +
                            companions[companion].secondName
                        )

                )
        }
    })
}

function loadWaypoints(driverId) {
    $.get("/driverPage/points/" + driverId, function (waypoints) {
        var waypointSelect = $('#wayPoints');

        for (waypointIndex in waypoints) {
            waypointSelect
                .append(
                    $("<p />")
                        .val(waypoints[waypointIndex].wayPointId)
                        .text(
                            waypoints[waypointIndex].cargoNumber + " - " +
                            waypoints[waypointIndex].cityDTO + " - " +
                            waypoints[waypointIndex].orderTypeDTO
                        )
                )
        }
    })
}


function saveChangeDriver(){
    var driverStatus = $('#driverShiftStatus').val();
    var orderCargo = $('#orderCargo').val();
    // var hoursWorked = $('#driverStatus').val();

    var  driverId = getDriverId();

    var driver = {
        idDriver: driverId,
        orderCargoStatus: orderCargo,
        driverStatus: driverStatus

    };

    $.ajax ({
        url: "/driverPage/driverInfo/" + driverId,
        type: "POST",
        data: JSON.stringify(driver),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (driver) {
            window.location.href = "/";
        }
    });

}