<!-- main_jsdata.js STYLESHEET START -->
<script type="text/javascript">
    function featureSearch() {
        let input, filter;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        let selectedCheckboxes = checkboxSelected();
        let feats = document.getElementsByClassName("featurecoll")[0];
        let featureButton = feats.getElementsByClassName("collapsibleM");
        for (let i = 0; i < featureButton.length; i++) {
            let featbar = featureButton[i].getElementsByClassName("featbar")[0]
            let labels = featbar.getElementsByTagName("label")[0];
            if (featbar) {
                let txtValue = labels.innerText/*labels[0].textContent || labels[0].innerText*/;
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
        let input;
        input = document.getElementsByClassName("statuscheckbox");
        let truemap = new Map();
        let falsemap = new Map();
        for (let i = 0; i < input.length; i++) {
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
        let stats = [];
        let count = 0;
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
        let input = document.getElementsByClassName("statuscheckbox");
        for (let i = 0; i < input.length; i++) {
            input.item(i).checked = true;
        }
        featureSearch();
    }
</script>
<!-- main_jsdata.js STYLESHEET END -->