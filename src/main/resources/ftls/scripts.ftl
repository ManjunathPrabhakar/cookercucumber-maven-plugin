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
<!--show snackbar scripts-->
<script>
    function showToast(type, msg) {
        var x = document.getElementById("snackbar");
        var defType = type === null ? "info" : type;
        switch (type) {
            case 'success':
                x.getElementsByTagName("i")[0].className = "fa fa-check-circle";
                x.style.backgroundColor = "rgb(0,190,54)";
                break;
            case 'error':
                x.getElementsByTagName("i")[0].className = "fa fa-close-circle";
                x.style.backgroundColor = "rgb(190,38,0)";
                break;
            case 'warning':
                x.getElementsByTagName("i")[0].className = "fa fa-exclamation-circle";
                x.style.backgroundColor = "rgb(190,149,0)";
                break;
            default:
                x.getElementsByTagName("i")[0].className = "fa fa-info-circle";
                x.style.backgroundColor = "rgb(0,108,190)";
                break;

        }

        x.getElementsByTagName("span")[0].innerText = msg;
        x.className = "show";
        setTimeout(function () {
            x.className = x.className.replace("show", "");
        }, 3000);
    }
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
            if (chart.config.options.elements.center) {
                // Get ctx from string
                var ctx = chart.chart.ctx;

                // Get options from the center object in options
                var centerConfig = chart.config.options.elements.center;
                var fontStyle = centerConfig.fontStyle || 'Arial';
                var txt = centerConfig.text;
                var color = centerConfig.color || '#000';
                var maxFontSize = centerConfig.maxFontSize || 75;
                var sidePadding = centerConfig.sidePadding || 20;
                var sidePaddingCalculated = (sidePadding / 100) * (chart.innerRadius * 2)
                // Start with a base font of 30px
                ctx.font = "40px " + fontStyle;

                // Get the width of the string and also the width of the element minus 10 to give it 5px side padding
                var stringWidth = ctx.measureText(txt).width;
                var elementWidth = (chart.innerRadius * 2) - sidePaddingCalculated;

                // Find out how much the font can grow in width.
                var widthRatio = elementWidth / stringWidth;
                var newFontSize = Math.floor(30 * widthRatio);
                var elementHeight = (chart.innerRadius * 2);

                // Pick a new font size so it will not be larger than the height of label.
                var fontSizeToUse = Math.min(newFontSize, elementHeight, maxFontSize);
                var minFontSize = centerConfig.minFontSize;
                var lineHeight = centerConfig.lineHeight || 25;
                var wrapText = false;

                if (minFontSize === undefined) {
                    minFontSize = 20;
                }

                if (minFontSize && fontSizeToUse < minFontSize) {
                    fontSizeToUse = minFontSize;
                    wrapText = true;
                }

                // Set font settings to draw it correctly.
                ctx.textAlign = 'center';
                ctx.textBaseline = 'middle';
                var centerX = ((chart.chartArea.left + chart.chartArea.right) / 2);
                var centerY = ((chart.chartArea.top + chart.chartArea.bottom) / 2);
                ctx.font = fontSizeToUse + "px " + fontStyle;
                ctx.fillStyle = color;

                if (!wrapText) {
                    ctx.fillText(txt, centerX, centerY);
                    return;
                }

                var words = txt.split(' ');
                var line = '';
                var lines = [];

                // Break words up into multiple lines if necessary
                for (var n = 0; n < words.length; n++) {
                    var testLine = line + words[n] + ' ';
                    var metrics = ctx.measureText(testLine);
                    var testWidth = metrics.width;
                    if (testWidth > elementWidth && n > 0) {
                        lines.push(line);
                        line = words[n] + ' ';
                    } else {
                        line = testLine;
                    }
                }

                // Move the center up depending on line height and number of lines
                centerY -= (lines.length / 2) * lineHeight;

                for (var n = 0; n < lines.length; n++) {
                    ctx.fillText(lines[n], centerX, centerY);
                    centerY += lineHeight;
                }
                //Draw text in center
                ctx.fillText(line, centerX, centerY);
            }
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
            elements: {
                center: {
                    text: '${featurePassPercentage}%',
                    color: 'mediumseagreen', // Default is #000000
                    fontStyle: 'Arial', // Default is Arial
                    sidePadding: 20, // Default is 20 (as a percentage)
                    minFontSize: 10, // Default is 20 (in px), set to false and text will not wrap.
                    lineHeight: 25 // Default is 25 (in px), used for when text wraps
                }
            },
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
            elements: {
                center: {
                    text: '${scenariosPassPercentage}%',
                    color: 'mediumseagreen', // Default is #000000
                    fontStyle: 'Arial', // Default is Arial
                    sidePadding: 20, // Default is 20 (as a percentage)
                    minFontSize: 10, // Default is 20 (in px), set to false and text will not wrap.
                    lineHeight: 25 // Default is 25 (in px), used for when text wraps
                }
            },
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