$(document).ready(function(){
    var button = $('#load-ajax');

    button.onclick(loadMaps())
});

function loadMaps() {

    var textField = $('#data');

    $.get("/ajax/json", function (data, status) {
        textField.val(JSON.stringify(data));
    })
}