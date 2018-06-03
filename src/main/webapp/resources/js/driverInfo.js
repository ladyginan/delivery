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
    $.get("/driverInfo/" + driverId, function (driver) {

        loadedDriver = driver;

        $("#idDriver").val(driverId);
        $("#waggonRegNumber").val(driver.waggon);
        $("#orderNumber").val(driver.orderNumber);

    })
}



function loadCompanions() {
    $get("/driverInfo/companions",function(companions){
        var companions = $('#companions');
        for(companion in companions){
            companions
                .append(
                    $('<tr />')
                        .val(companions[companion].idCompanion)
                        .text(
                            companions[companion].fullname
                        )

                )
        }
    })
}
