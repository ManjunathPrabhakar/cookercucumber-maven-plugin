<!--scripts start-->
<script>
    /* ===== START OF COLLAPSIBLE IMPLEMENTATION ===== */
    /* Code to Implement Collapasible's */
    let coll_element = document.getElementsByClassName("collapsibleM");
    for (let i = 0; i < coll_element.length; i++) {
        coll_element[i].addEventListener("click", function () {
            this.classList.toggle("active");
            let content = this.nextElementSibling;
            if (content.style.display === "block") {
                content.style.display = "none";
            } else {
                content.style.display = "block";
            }
        });
    }
    /* ===== END OF COLLAPSIBLE IMPLEMENTATION ===== */
</script>
<!--show Graph : features bar chart scripts-->
<script>
    function loadGraphPageFeaturesbarchart() {
        // Chart
        let canvas = document.getElementById('chart-area-features');
        let ctx = canvas.getContext("2d");
        let chart = new Chart(ctx, {
            "data": {
                "labels": [${getFeatureNames()?remove_ending(",")}],
                <#function getFeatureNames>
                <#local str=''>
                <@compress single_line=true>
                <#list featurepojos as featurepojo>
                <#local str += "\"" + featurepojo.getName() + "\"" + ",">
                </#list>
                </@compress>
                <#return (str)>
                </#function>
                "datasets": [
                    {
                        "data": [${getFeatStatusData("pass")?remove_ending(",")}],
                        "backgroundColor": "lightgreen",
                        "label": "passed"
                    },
                    {
                        "data": [${getFeatStatusData("fail")?remove_ending(",")}],
                        "backgroundColor": "salmon",
                        "label": "failed"
                    },
                    {
                        "data": [${getFeatStatusData("skip")?remove_ending(",")}],
                        "backgroundColor": "peachpuff",
                        "label": "skipped"
                    },
                    {
                        "data": [${getFeatStatusData("other")?remove_ending(",")}],
                        "backgroundColor": "lavender",
                        "label": "others"
                    }
                    <#function getFeatStatusData(status)>
                    <#local str=''>
                    <#list featurepojos as featurepojo>
                    <#list featurepojo.getFeaturesStatusesCount() as stats,count>
                    <#if stats == status>
                    <@compress single_line=true>
                    <#local str += count + ",">
                    </@compress>
                    </#if>
                    </#list>
                    </#list>
                    <#return (str)>
                    </#function>
                ]
            },
            "options":
                {
                    responsive: true,
                    maintainAspectRatio: false,
                    "scales": {
                        "xAxes": [
                            {
                                "ticks": {
                                    "min": 0,
                                    "stepSize": 0,
                                    "display": false,
                                    callback: function (value) {
                                        return value.substr(0, 10) || '';
                                    }
                                },
                                "stacked": true,
                                "scaleLabel": {
                                    "display": true,
                                    "labelString": "${totalFeatures} Features"
                                },
                                "stepSize": 0.0
                            }
                        ],
                        "yAxes": [
                            {
                                "ticks": {
                                    "min": 0,
                                    "stepSize": 4,
                                    "display": true
                                },
                                "stacked": true,
                                "scaleLabel": {
                                    "display": true,
                                    "labelString": "Number of Scenarios"
                                },
                                "stepSize": 0.0
                            }
                        ]
                    },
                    "events": [
                        "click",
                        "mousemove"
                    ],
                    tooltips: {
                        enabled: true,
                        mode: 'label',
                        callbacks: {
                            title: function (toolTipItems, data) {
                                let titleData = data.labels[toolTipItems[0].index];
                                return titleData;
                            },
                            label: function (toolTipItems, data) {
                                let curVal = (data.datasets[toolTipItems.datasetIndex]).data[toolTipItems.index];
                                let labelData = (data.datasets[toolTipItems.datasetIndex]).label;
                                if (curVal > 0) {
                                    return labelData + ":" + curVal;
                                }
                            }
                        }
                    }
                },
            "type": "bar"
        });
    };
</script>
<!--show Graph : scenarios bar chart scripts-->
<script>
    function loadGraphPageScenariosbarchart() {
        // Chart
        let canvas = document.getElementById('chart-area-scenarios');
        let ctx = canvas.getContext("2d");
        let chart = new Chart(ctx, {
            "data": {
                "labels": [${getScenarioNames()?remove_ending(",")}],

                <#function getScenarioNames>
                <#local str=''>
                <#list featurepojos as featurepojo>
                <#list featurepojo.getElements() as elements>
                <#if elements.getType() == 'scenario'>
                <@compress single_line=true>
                <#local str += "\"" + elements.getName() + "\"" + ",">
                </@compress>
                </#if>
                </#list>
                </#list>
                <#return (str)>
                </#function>

                "datasets": [
                    {
                        "data": [${getScnStatusData("pass")?remove_ending(",")}],
                        "backgroundColor": "lightgreen",
                        "label": "passed"
                    },
                    {
                        "data": [${getScnStatusData("fail")?remove_ending(",")}],
                        "backgroundColor": "salmon",
                        "label": "failed"
                    },
                    {
                        "data": [${getScnStatusData("skip")?remove_ending(",")}],
                        "backgroundColor": "peachpuff",
                        "label": "skipped"
                    },
                    {
                        "data": [${getScnStatusData("other")?remove_ending(",")}],
                        "backgroundColor": "lavender",
                        "label": "others"
                    }
                ]
                <#function getScnStatusData(status)>
                <#local str=''>
                <#list featurepojos as featurepojo>
                <#list featurepojo.getElements() as elements>
                <#if elements.getType() == 'scenario'>
                <#list elements.getScenariosStatusesCount() as stats,count>
                <#if stats == status>
                <@compress single_line=true>
                <#local str += count + ",">
                </@compress>
                </#if>
                </#list>
                </#if>
                </#list>
                </#list>
                <#return (str)>
                </#function>
            },
            "options":
                {
                    responsive: true,
                    maintainAspectRatio: false,
                    "scales": {
                        "xAxes": [
                            {
                                "ticks": {
                                    "min": 0,
                                    "stepSize": 0,
                                    "display": false,
                                    callback: function (value) {
                                        return value.substr(0, 10) || '';
                                    }
                                },
                                "stacked": true,
                                "scaleLabel": {
                                    "display": true,
                                    "labelString": "${totalScenarios} Scenarios"
                                },
                                "stepSize": 0.0
                            }
                        ],
                        "yAxes": [
                            {
                                "ticks": {
                                    "min": 0,
                                    "stepSize": 5,
                                    "display": true
                                },
                                "stacked": true,
                                "scaleLabel": {
                                    "display": true,
                                    "labelString": "Number of Steps"
                                },
                                "stepSize": 0.0
                            }
                        ]
                    },
                    "events": [
                        "click",
                        "mousemove"
                    ],
                    tooltips: {
                        enabled: true,
                        mode: 'label',
                        callbacks: {
                            title: function (toolTipItems, data) {
                                let titleData = data.labels[toolTipItems[0].index];
                                return titleData;
                            },
                            label: function (toolTipItems, data) {
                                let curVal = (data.datasets[toolTipItems.datasetIndex]).data[toolTipItems.index];
                                let labelData = (data.datasets[toolTipItems.datasetIndex]).label;
                                if (curVal > 0) {
                                    return labelData + ":" + curVal;
                                }
                            }
                        }
                    }
                },
            "type": "bar"
        });
    };
</script>
<!--show percentage in pie scripts-->
<script>
    Chart.pluginService.register({
        beforeDraw: function (chart) {
            let width = chart.chart.width,
                height = chart.chart.height,
                ctx = chart.chart.ctx;

            ctx.restore();
            let fontSize = ((height / 114).toFixed(2)) - ((height / 114).toFixed(2)) * 0.2;
            ctx.font = fontSize + "em Arial";
            ctx.textBaseline = "middle";
            ctx.fillStyle = chart.options.centerTextColor;

            let text = chart.options.centerText || '',
                textX = Math.round((width - ctx.measureText(text).width) / 2),
                textY = height / 2;

            ctx.fillText(text, textX, textY);
            ctx.save();
        }
    });
</script>
<!--show Dashboard : features pie chart scripts-->
<script>

    function loadDashboardPageFeaturesDoughNutchart() {
        let featCtx = document.getElementById('featuresGraphDB').getContext('2d');
        let myChart = new Chart(featCtx, {
            type: 'doughnut',
            data: {
                labels: ['Pass', 'Fail', 'Skip', 'Others'],
                datasets: [{
                    label: 'Features',
                    data: [${totalPassFeatures}, ${totalFailFeatures}, ${totalSkipFeatures}, ${totalOtherFeatures}],
                    backgroundColor: [
                        'lightgreen',
                        'salmon',
                        'peachpuff',
                        'lavender'
                    ],
                    hoverOffset: 4
                }],
            },
            options: {
                responsive: false,
                legend: {
                    display: false,
                    position: 'bottom',
                },
                title: {
                    display: false,
                    text: 'Features'
                },
                animation: {
                    animateScale: true,
                    animateRotate: true
                },
                centerText: '${featurePassPercentage}%',
                centerTextColor: 'mediumseagreen',
                tooltips: {
                    callbacks: {
                        label: function (tooltipItem, data) {
                            let dataset = data.datasets[tooltipItem.datasetIndex];
                            let total = dataset.data.reduce(function (previousValue, currentValue, currentIndex, array) {
                                return previousValue + currentValue;
                            });
                            let currentValue = dataset.data[tooltipItem.index];
                            let currLabel = data.labels[tooltipItem.index];
                            let percentage = Math.floor(((currentValue / total) * 100) + 0.5);
                            return currLabel + ":" + currentValue + " (" + percentage + "%)";
                        }
                    }
                }
            }
        });
    };
</script>
<!--show Dashboard : scenarios pie chart scripts-->
<script>
    function loadDashboardPageScenariosDoughNutchart() {
        let scnCtx = document.getElementById('scenariosGraphDB').getContext('2d');
        let myChart = new Chart(scnCtx, {
            type: 'doughnut',
            data: {
                labels: ['Pass', 'Fail', 'Skip', 'Others'],
                datasets: [{
                    label: 'Features',
                    data: [${totalPassScenarios}, ${totalFailScenarios}, ${totalSkipScenarios}, ${totalOtherScenarios}],
                    backgroundColor: [
                        'lightgreen',
                        'salmon',
                        'peachpuff',
                        'lavender'
                    ],
                    hoverOffset: 4
                }],
            },
            options: {
                responsive: false,
                legend: {
                    display: false,
                    position: 'bottom',
                },
                title: {
                    display: false,
                    text: 'Features'
                },
                animation: {
                    animateScale: true,
                    animateRotate: true
                },
                centerText: '${scenariosPassPercentage}%',
                centerTextColor: 'mediumseagreen',
                tooltips: {
                    callbacks: {
                        label: function (tooltipItem, data) {
                            let dataset = data.datasets[tooltipItem.datasetIndex];
                            let total = dataset.data.reduce(function (previousValue, currentValue, currentIndex, array) {
                                return previousValue + currentValue;
                            });
                            let currentValue = dataset.data[tooltipItem.index];
                            let currLabel = data.labels[tooltipItem.index];
                            let percentage = Math.floor(((currentValue / total) * 100) + 0.5);
                            return currLabel + ":" + currentValue + " (" + percentage + "%)";
                        }
                    }
                }
            }
        });
    };
</script>
<!--show Image big & small-->
<script>
    function displayImage(imgbox) {
        document.getElementById("showbigimage").src = (imgbox.src);
        document.getElementById("showbigimagespan").style.display = "block";
    }

    function closebigimage(bigimg) {
        bigimg.src = "";
        document.getElementById("showbigimagespan").style.display = "none";
    }
</script>
<!--scripts end-->