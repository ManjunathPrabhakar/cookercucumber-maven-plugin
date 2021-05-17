function downloadit() {
    alert("Cooker Says : PDF, Excel, Image Download Coming Soon!")
}

function statusEmoji(current) {
    var c = current.getElementsByTagName("i")[0];
    switch (c.innerText.toLowerCase()) {
        case "sentiment_very_dissatisfied" :
            alert("Pass % Between 0-20%");
            break;
        case "sentiment_dissatisfied" :
            alert("Pass % Between 21-40%");
            break;
        case "sentiment_neutral" :
            alert("Pass % Between 41-60%");
            break;
        case "sentiment_satisfied" :
            alert("Pass % Between 61-80%");
            break;
        case "sentiment_very_satisfied" :
            alert("Pass % Between 81-100%");
            break;
    }
}

function featureSearch() {
    var input, filter;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();

    var selectedCheckboxes = checkboxSelected();

    var feats = document.getElementsByClassName("featurecoll")[0];
    var featureButton = feats.getElementsByClassName("collapsibleM");

    for (var i = 0; i < featureButton.length; i++) {
        var featbar = featureButton[i].getElementsByClassName("featbar")[0]
        var labels = featbar.getElementsByTagName("label")[0];
        if (featbar) {
            var txtValue = labels.innerText/*labels[0].textContent || labels[0].innerText*/;
            //Feature Name or Feature URI and selected checkboxes
            if (((txtValue.toUpperCase().indexOf(filter) > -1) | (labels.getAttribute("data-feature-uri").toUpperCase().indexOf(filter) > -1))
                && selectedCheckboxes.includes(labels.className)) {
                featureButton[i].style.display = "";
            } else {
                featureButton[i].style.display = "none";
            }
        }
    }
}

function checkboxSelected() {
    var input, filter;
    input = document.getElementsByClassName("statuscheckbox");
    var truemap = new Map();
    var falsemap = new Map();
    for (var i = 0; i < input.length; i++) {
        if (input.item(i).checked) {
            truemap.set(i, input.item(i).checked);
        } else {
            falsemap.set(i, input.item(i).checked);
        }
    }
    if (truemap.size === 0) {
        alert("Select atleast once status to filter");
        input.item(0).checked = true;
        input.item(1).checked = true;
        input.item(2).checked = true;
        input.item(3).checked = true;
        featureSearch();
        throw "Select atleast once status to filter";
    }
    var stats = [];
    var count = 0;
    truemap.forEach((v, k) => {
        if (k === 0) {
            stats[count] = 'passfeature';
        } else if (k === 1) {
            stats[count] = 'failfeature';
        } else if (k === 2) {
            stats[count] = 'skipfeature';
        } else if (k === 3) {
            stats[count] = 'otherfeature';
        }
        count = count + 1;
    });

    return stats;
}

function resetfeaturefilter() {
    document.getElementById("myInput").value = "";
    var input = document.getElementsByClassName("statuscheckbox");
    for (var i = 0; i < input.length; i++) {
        input.item(i).checked = true;
    }
    featureSearch();
}