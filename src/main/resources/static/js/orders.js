function loadOrdersNotIssued() {
    const requestURL = document.location.href + 'api/order/get/all_not_issued';

    const request = new XMLHttpRequest();
    request.open("POST", requestURL);
    request.responseType = "json";
    request.send();

    request.onload = function() {
        const dataDB = request.response;
        tableCycle(dataDB);
    };
}

function tableCycle(jsonObj) {
    var a = $('#orders').html();

    let output = "<table>";

    output += "<th>Наименование заказа</th><th>Статус</th><th>Заказчик</th>"

    for (let jsonObjKey of jsonObj) {
        output += "<tr style='background-color: " + jsonObjKey["status_color"] + "; color: azure'><td>";
        output += jsonObjKey["name"];
        output += "</td><td>";
        output += jsonObjKey["status"];
        output += "</td><td>";
        output += jsonObjKey["customer"];
        output += "</td>"
    }

    output += "</table>";

    $('#orders').html(output);
}