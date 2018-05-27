$(document).ready(function() {
    var pathArray = window.location.pathname.split('/');
    var driverId = pathArray[pathArray.length - 1];
    loadDriver(driverId);
    loadCities();
    loadAllWaggons();
});


function loadDriver(driverId) {

    $.get("/drivers/" + driverId, function (driver) {
        var name = $('#name');
        driver.append($("<option/>")
            .val(driver.name)
            .text(driver.name)
        )
    })
}


function  loadCities() {
    $.get("/cities", function(cities){
        var citySelect = $('#cities');
        for (cityIndex in cities) {
            citySelect
                .append(
                    $('<option />')
                        .val(cities[cityIndex].idMap)
                        .text(
                            cities[cityIndex].city
                        )
                )
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
    })
}

function editDriver() {
    var personalNumber = $('#personalNumber').val();
    var name = $('#name').val();
    var secondName = $('#secondName').val();
    var hoursWorked = $('#hoursWorked').val();
    var driverStatus = $('#driverStatus').val();
    var selectedCity = $('#cities').val();
    var selectedWaggon = $('#waggons').val();

    var driver = {
        personalNumber: personalNumber,
        name: name,
        secondName: secondName,
        hoursWorked: hoursWorked,
        driverStatus: driverStatus,
        city: selectedCity,
        waggon: selectedWaggon
    };

    $.ajax ({
        url: "/drivers",
        type: "POST",
        data: JSON.stringify(driver),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (driver) {
            window.location.href = "/welcome";
        }
    });

}


