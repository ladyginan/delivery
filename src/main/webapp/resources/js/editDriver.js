$(document).ready(function() {
    var pathArray = window.location.pathname;
    pathArray = pathArray.replace('.html','').split('/');
    var driverId = pathArray[pathArray.length - 1];
    loadDriver(driverId);
    loadCities();
    loadAllWaggons();
});


function loadDriver(driverId) {
    $.get("/drivers/" + driverId, function (driver) {
        $("#firstName").val(driver.name);
        $("#personalNumber").val(driver.personalNumber);
        $("#secondName").val(driver.secondName);
        $("#hoursWorked").val(driver.hoursWorked);
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
    var name = $('#firstName').val();
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


