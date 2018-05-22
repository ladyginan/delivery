$(document).ready(function(){
    var button = $('#load-ajax');

    button.onclick(loadMaps());
});
$(document).ready(function(){
    var button = $('#load-cargo');

    button.onclick(loadCargo());
});

function loadMaps() {

    var textField = $('#data');

    $.get("/ajax/json", function (data) {
        textField.val(JSON.stringify(data));
    })
}

function loadCargo() {
    var statusField = $('#status');

    $.get("/ajax/jsonCargo", function (status) {
        statusField.val(JSON.stringify(status))
    })
}