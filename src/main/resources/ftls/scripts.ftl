<!--scripts start-->
<script>
    /* ===== START OF COLLAPSIBLE IMPLEMENTATION ===== */
    /* Code to Implement Collapasible's */
    var coll_element = document.getElementsByClassName("collapsibleM");
    for (var i = 0; i < coll_element.length; i++) {
        coll_element[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
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
    $(document).ready(function () {
        // Chart
        var canvas = document.getElementById('chart-area-features');
        var ctx = canvas.getContext("2d");
        var chart = new Chart(ctx, {
            "data": {
                "labels": [
                    <#list featurepojos as featurepojo>
                    "${featurepojo.getName()}",
                    </#list>
                ],
                "datasets": [
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getFeaturesStatusesCount() as stats,count>
                            <#if stats == "pass">
                            ${count},
                            </#if>
                            </#list>
                            </#list >
                        ],
                        "backgroundColor": "lightgreen",
                        "label": "passed"
                    },
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getFeaturesStatusesCount() as stats,count>
                            <#if stats == "fail">
                            ${count},
                            </#if>
                            </#list>
                            </#list >
                        ],
                        "backgroundColor": "salmon",
                        "label": "failed"
                    },
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getFeaturesStatusesCount() as stats,count>
                            <#if stats == "skip">
                            ${count},
                            </#if>
                            </#list>
                            </#list >
                        ],
                        "backgroundColor": "peachpuff",
                        "label": "skipped"
                    },
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getFeaturesStatusesCount() as stats,count>
                            <#if stats == "other">
                            ${count},
                            </#if>
                            </#list>
                            </#list >
                        ],
                        "backgroundColor": "lavender",
                        "label": "others"
                    }
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
                                    "display": false
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
                    ]
                },
            "type": "bar"
        });
    });
</script>
<!--show Graph : scenarios bar chart scripts-->
<script>
    $(document).ready(function () {
        // Chart
        var canvas = document.getElementById('chart-area-scenarios');
        var ctx = canvas.getContext("2d");
        var chart = new Chart(ctx, {
            "data": {
                "labels": [
                    <#list featurepojos as featurepojo>
                    <#list featurepojo.getElements() as elements>
                    <#if elements.getType() == 'scenario'>
                    "${elements.getName()}",
                    </#if>
                    </#list>
                    </#list>
                ],
                "datasets": [
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getElements() as elements>
                            <#if elements.getType() == 'scenario'>
                            <#list elements.getScenariosStatusesCount() as stats,count>
                            <#if stats == "pass">
                            ${count},
                            </#if>
                            </#list>
                            </#if>
                            </#list>
                            </#list>
                        ],
                        "backgroundColor": "lightgreen",
                        "label": "passed"
                    },
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getElements() as elements>
                            <#if elements.getType() == 'scenario'>
                            <#list elements.getScenariosStatusesCount() as stats,count>
                            <#if stats == "fail">
                            ${count},
                            </#if>
                            </#list>
                            </#if>
                            </#list>
                            </#list>
                        ],
                        "backgroundColor": "salmon",
                        "label": "failed"
                    },
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getElements() as elements>
                            <#if elements.getType() == 'scenario'>
                            <#list elements.getScenariosStatusesCount() as stats,count>
                            <#if stats == "skip">
                            ${count},
                            </#if>
                            </#list>
                            </#if>
                            </#list>
                            </#list>
                        ],
                        "backgroundColor": "peachpuff",
                        "label": "skipped"
                    },
                    {
                        "data": [
                            <#list featurepojos as featurepojo>
                            <#list featurepojo.getElements() as elements>
                            <#if elements.getType() == 'scenario'>
                            <#list elements.getScenariosStatusesCount() as stats,count>
                            <#if stats == "other">
                            ${count},
                            </#if>
                            </#list>
                            </#if>
                            </#list>
                            </#list>
                        ],
                        "backgroundColor": "lavender",
                        "label": "others"
                    }
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
                                    "display": false
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
                    ]
                },
            "type": "bar"
        });
    });
</script>
<!--show percentage in pie scripts-->
<script>
    Chart.pluginService.register({
        beforeDraw: function (chart) {
            var width = chart.chart.width,
                height = chart.chart.height,
                ctx = chart.chart.ctx;

            ctx.restore();
            var fontSize = ((height / 114).toFixed(2)) - ((height / 114).toFixed(2)) * 0.2;
            ctx.font = fontSize + "em Arial";
            ctx.textBaseline = "middle";
            ctx.fillStyle = chart.options.centerTextColor;

            var text = chart.options.centerText,
                textX = Math.round((width - ctx.measureText(text).width) / 2),
                textY = height / 2;

            ctx.fillText(text, textX, textY);
            ctx.save();
        }
    });
</script>
<!--show Dashboard : features pie chart scripts-->
<script>
    var ctx = document.getElementById('featuresGraphDB').getContext('2d');
    var myChart = new Chart(ctx, {
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
                        var dataset = data.datasets[tooltipItem.datasetIndex];
                        var total = dataset.data.reduce(function (previousValue, currentValue, currentIndex, array) {
                            return previousValue + currentValue;
                        });
                        var currentValue = dataset.data[tooltipItem.index];
                        var currLabel = data.labels[tooltipItem.index];
                        var percentage = Math.floor(((currentValue / total) * 100) + 0.5);
                        return currLabel + ":" + currentValue + " (" + percentage + "%)";
                    }
                }
            }
        }
    });
</script>
<!--show Dashboard : scenarios pie chart scripts-->
<script>
    var ctx = document.getElementById('scenariosGraphDB').getContext('2d');
    var myChart = new Chart(ctx, {
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
                        var dataset = data.datasets[tooltipItem.datasetIndex];
                        var total = dataset.data.reduce(function (previousValue, currentValue, currentIndex, array) {
                            return previousValue + currentValue;
                        });
                        var currentValue = dataset.data[tooltipItem.index];
                        var currLabel = data.labels[tooltipItem.index];
                        var percentage = Math.floor(((currentValue / total) * 100) + 0.5);
                        return currLabel + ":" + currentValue + " (" + percentage + "%)";
                    }
                }
            }
        }
    });
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