$(document).ready(function(){
    loadDrivers();
});

function loadDrivers() {
    $.get("/driverPage", function (drivers) {

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

function createDriverUser() {
    var selectedDriver = $('#driver').val();

    var userDriver = {
        driver: selectedDriver,
    };

    $.ajax ({
        url: "/selectProfile",
        type: "POST",
        data: JSON.stringify(userDriver),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (drivers) {
            window.location.href = "/driverInfo";
        }
    });

}