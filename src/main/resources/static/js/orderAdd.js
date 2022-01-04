function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function firstRender(customer) {
    const selectCarsByCustomer = document.getElementsByClassName("selectCarsByCustomer").item(0);
    selectCarsByCustomer.innerHTML = "";

    let jsonResponse = new Map();

    const re = "Customer{id=(\\w*)";
    const customerId = customer.matchAll(re).next().value[1] + "";

    const form = new FormData();
    form.append("customerId", customerId);

    const settings = {
        "url": "/api/car/customerId",
        "method": "POST",
        "timeout": 0,
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": form
    };

    $.ajax(settings).done(function (response) {
        let key = "";
        let value = "";

        JSON.parse(response, function (k, v) {
            if (k === "id") {
                key = v;
                jsonResponse.set(key, value);
            }
            if (k === "name") {
                value = v;
            }
        });
        selectCarsByCustomer.style.visibility = 'visible';

        for (let jsonElementResponse of jsonResponse.keys()) {
            let optionElement = document.createElement('option');
            optionElement.setAttribute("th:value", jsonElementResponse);
            optionElement.label = jsonResponse.get(jsonElementResponse);
            selectCarsByCustomer.append(optionElement);
        }
    });
}
