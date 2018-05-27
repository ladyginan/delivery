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
    $.get("/drivers/" + driverId, function (driver) {

        loadedDriver = driver;

        $("#firstName").val(driver.name);
        $("#personalNumber").val(driver.personalNumber);
        $("#secondName").val(driver.secondName);
        $("#hoursWorked").val(driver.hoursWorked);
        $("#driverStatus").val(driver.status);

        loadCities();
        loadAllWaggons();
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

        if (loadedDriver) {
            citySelect.val(loadedDriver.mapId)
        }

    })
}

function loadAllWaggons() {
    $.get("/waggons", function (waggons) {

        var waggonSelect = $('#waggons');
        for (waggon in waggons) {
            waggonSelect
                .append($("<option />")
                    .val(waggons[waggon].idWaggon)
                    .text(waggons[waggon].regNumber))
        }

        if (loadedDriver) {
            waggonSelect.val(loadedDriver.waggon)
        }
    })
}

function editDriver() {
    var personalNumber = $('#personalNumber').val();
    var name = $('#firstName').val();
    var secondName = $('#secondName').val();
    var hoursWorked = $('#hoursWorked').val();
    var driverStatus = $('#driverStatus').val();
    var selectedCity = $('#cities').val();
    var selectedWaggon = $('#waggons').val();

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
        url: "/drivers/edit/" + driverId,
        type: "POST",
        data: JSON.stringify(driver),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (driver) {
            window.location.href = "/drivers/edit/success";
        }
    });

}


