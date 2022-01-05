/**
 * Загрузка незаконченных заказов
 */
function loadOrdersNotIssued() {
    loadToOrdersTable(document.location.href + 'api/order/get/all_not_issued');
}

/**
 * Загрузка всех заказов, даже законченных
 */
function loadOrdersAll() {
    loadToOrdersTable(document.location.href + 'api/order/get/all');
}

/**
 * Генерация таблицы заказов
 * @param jsonObj принятый с POST-запроса JSON
 */
function tableCycle(jsonObj) {
    var a = $('#orders').html();

    let output = "<table>";

    output += "<th>Наименование заказа</th><th>Статус</th><th>Заказчик</th>"

    for (let jsonObjKey of jsonObj) {
        output += "<tr class=\"popup-open\" style='background-color: " + jsonObjKey["status_color"] + "'><td onclick=\"orderPopupOpen(" + jsonObjKey["id"] + ")\">";
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

/**
 * Загрузка данных о заказах в таблицу
 * @param requestURL ссылка запроса
 */
function loadToOrdersTable(requestURL) {
    const request = new XMLHttpRequest();
    request.open("POST", requestURL);
    request.responseType = "json";
    request.send();

    request.onload = function() {
        const dataDB = request.response;
        tableCycle(dataDB);
    };
}

/**
 * Обработчик popup окна для детального описания заказа
 */
function orderPopupOpen(orderId) {
    var form = new FormData();
    form.append("id", orderId);

    var settings = {
        "url": document.location.href + "api/order/get/by_id",
        "dataType": "json",
        "method": "POST",
        "timeout": 0,
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": form
    };

    $.ajax(settings).done(function (responseData) {
        let innerHTML = "<p class=\"popup-header\">Заказ для одного парня</p>" +
            "<p>Ну я напарсил, что это номер " + orderId + ". Ну и ещё его название - " + responseData["name"] + "</p>" +
            "<p>А вот вообще всё, что я получил с сервера: \n" + JSON.stringify(responseData) + "</p>";

        renderPopupWindow(innerHTML, true);
        $('.popup-fade').fadeIn();
    });
}

function orderPopupClose() {
    $('.popup-fade').fadeOut();
    removeElementsByClass("popup-fade");
}

$(document).ready(function($) {
    $(document).keydown(function(e) {
        if (e.keyCode === 27) {
            e.stopPropagation();
            $('.popup-fade').fadeOut();
            removeElementsByClass("popup-fade");
        }
    });

    $('.popup-fade').click(function(e) {
        if ($(e.target).closest('.popup').length == 0) {
            $('.popup-fade').fadeOut();
            removeElementsByClass("popup-fade");
        }
    });
});

/**
 * Удаление элемента по имени класса
 * @param className имя класса для удаления
 */
function removeElementsByClass(className){
    var elements = document.getElementsByClassName(className);
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }
}

/**
 * Рендер Popup окна и добавление его в body
 * @param innerHTML внутренний текст с тегами
 * @param buttonClose (true/false) - добавить кнопку закрыть
 */
function renderPopupWindow(innerHTML, buttonClose) {
    let divParent = document.createElement('div');
    divParent.className = "popup-fade";

    let divChild = document.createElement('div');
    divChild.className = "popup";
    divChild.innerHTML = innerHTML;
    if (buttonClose) {
        divChild.innerHTML += "<input class=\"popup-close\" type=\"button\" value=\"Закрыть\" onclick=\"orderPopupClose()\"></input>";
    }

    divParent.append(divChild)

    document.body.append(divParent);
}