<div class="graph-content">

    <div class="container-title">
        Graph
        <i id="graphinfo-tooltip" style="margin-left: 5px; font-size: medium;" class="fa fa-info-circle"
           aria-hidden="true"></i>
    </div>
    <div class="chart-container" style="display:flex;flex-direction: column;">
        <div>
            <p>Execution Summary (Features against Scenarios)</p>
            <div class="chart-exec" style="position: relative; flex: 1">
                <canvas id="chart-area-features" width="100%" height="100%"
                        style="display: block; width: 95vw; height: 600px;"></canvas>
            </div>
        </div>
        <div>
            <p>Execution Summary (Scenarios against Steps)</p>
            <div class="chart-exec" style="position: relative; flex: 1">
                <canvas id="chart-area-scenarios" width="100%" height="100%"
                        style="display: block; width: auto; height: 600px;"></canvas>
            </div>
        </div>
    </div>
</div>