$(document).ready(function(){

    var loadMapsButton = $('#load-ajax');

    loadMapsButton.click(function () {
        var textField = $('#data');

        var cityNames = '';

        $.get("/ajax/json", function (cities) {
            for (city in cities) {
                cityNames = cityNames + cities[city].city + "\n";
            }

            textField.val(cityNames);
        })
    });

    var loadCargoButton = $('#load-cargo');
    loadCargoButton.click(function () {
        var statusField = $('#status');

        $.get("/ajax/jsonCargo", function (status) {
            statusField.val(JSON.stringify(status))
        })
    });
});
