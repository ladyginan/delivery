$(document).ready(function(){
    loadWaypoints();
    loadAllWaggons();
    loadDrivers();
});

function loadAllWaggons() {
    $.get("/waggons", function (waggons) {

        var waggonSelect = $('#waggons');

        for (waggon in waggons) {
            waggonSelect
                .append($("<option />")
                    .val(waggons[waggon].idWaggon)
                    .text(waggons[waggon].regNumber))
        }
    })
}

function loadDrivers() {
    $.get("/drivers", function (drivers) {

        var driverSelect = $('#drivers');

        for (driverIndex in drivers) {
            driverSelect
                .append(
                    $("<option />")
                        .val(drivers[driverIndex].idDriver)
                        .text(
                            drivers[driverIndex].personalNumber + " - " +
                            drivers[driverIndex].name + " - " +
                            drivers[driverIndex].secondName
                        )
                )
        }
    })
}

function loadWaypoints() {
    $.get("/points", function (waypoints) {

        var waypointSelect = $('#waypoints');

        for (waypointIndex in waypoints) {
            waypointSelect
                .append(
                    $("<option />")
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

function createOrder() {
    var selectedWaypoints = $('#waypoints').val();
    var selectedWaggon = $('#waggons').val();
    var selectedDrivers = $('#drivers').val();
    var regNumberOrder = $('#regNumberOrder').val();
    var orderStatus = $('#orderStatus').val();

    var order = {
        waypoints: selectedWaypoints,
        waggonId: selectedWaggon,
        drivers: selectedDrivers,
        regNumberOrder: regNumberOrder,
        orderStatus: orderStatus
    };

    $.ajax ({
        url: "/orders",
        type: "POST",
        data: JSON.stringify(order),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (order) {
            window.location.href = "/welcome";
        }
    });

}

// var loadMapsButton = $('#load-ajax');
//
// loadMapsButton.click(function () {
//     var textField = $('#data');
//
//     var cityNames = '';
//
//     $.get("/ajax/json", function (cities) {
//         for (city in cities) {
//             cityNames = cityNames + cities[city].city + "\n";
//         }
//
//         textField.val(cityNames);
//     })
// });
//
// var loadCargoButton = $('#load-cargo');
// loadCargoButton.click(function () {
//     var statusField = $('#status');
//
//     $.get("/ajax/jsonCargo", function (status) {
//         statusField.val(JSON.stringify(status))
//     })
// });
