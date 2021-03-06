<div class="dashboard-content">

    <div class="container-title">Dashboard
        <i id="dashboardinfo-tooltip" style="margin-left: 5px; font-size: medium;" class="fa fa-info-circle"
           aria-hidden="true"></i>
    </div>

    <div id="brief-summary">
        <div class="project-name-content">
            <div class="card-content">
                <p class="card-title"><b>Project</b></p>
                <div class="card-data">
                    <div class="card-start-line"></div>
                    <span style="
                          display:inline-block;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                          max-width: 35ch;">
                        ${projectName}
                    </span>
                </div>
            </div>
        </div>

        <div id="dashgraph" style="display: flex; flex-wrap: wrap;">
            <div class="card-content">
                <p class="card-title"><b>Features</b></p>
                <div class="card-data">
                    <div class="card-start-line"></div>
                    <div style="width:270px; height: 150px;display: flex;align-items: center; ">
                        <canvas id="featuresGraphDB" width="150" height="150"
                                style="padding-left: 15px; float:left; width: 392px; height: 196px;">
                        </canvas>
                        <div style="padding-left: 15px; float:right;">
                            <span>
                                <h3 style="padding-bottom: 2px;">${totalFeatures}</h3>
                            </span>
                            <i class="fa fa-check-circle" aria-hidden="true"
                               style="color: var(--pass-color-darkcolor); padding-bottom: 2px;"></i>
                            ${totalPassFeatures}<br>
                            <i class="fa fa-times-circle" aria-hidden="true"
                               style="color: var(--fail-color-darkcolor); padding-bottom: 2px;"></i>
                            ${totalFailFeatures}
                            <br>
                            <i class="fa fa-exclamation-circle" aria-hidden="true" style="
                                    color: var(--skip-color-darkcolor);padding-bottom: 2px;"></i>
                            ${totalSkipFeatures} <br>
                            <i class="fa fa-minus-circle" aria-hidden="true" style="
                                    color: var(--others-color-darkcolor);padding-bottom: 2px;"></i>
                            ${totalOtherFeatures}
                        </div>
                    </div>
                </div>
            </div>

            <div class="card-content">
                <p class="card-title"><b>Scenarios</b></p>
                <div class="card-data">
                    <div class="card-start-line"></div>
                    <div style="width:270px; height: 150px;display: flex;align-items: center; ">
                        <canvas id="scenariosGraphDB" width="150" height="150"
                                style="padding-left: 15px; float:left; width: 392px; height: 196px;">
                        </canvas>
                        <div style="padding-left: 15px; float:right;">
                            <span>
                                <h3 style="padding-bottom: 2px;">${totalScenarios}</h3>
                            </span>
                            <i class="fa fa-check-circle" aria-hidden="true"
                               style="color: var(--pass-color-darkcolor); padding-bottom: 2px;"></i>
                            ${totalPassScenarios}<br>
                            <i class="fa fa-times-circle" aria-hidden="true"
                               style="color: var(--fail-color-darkcolor); padding-bottom: 2px;"></i>
                            ${totalFailScenarios}
                            <br>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"
                               style="color: var(--skip-color-darkcolor);padding-bottom: 2px;"></i>
                            ${totalSkipScenarios} <br>
                            <i class="fa fa-minus-circle" aria-hidden="true"
                               style="color: var(--others-color-darkcolor);padding-bottom: 2px;"></i>
                            ${totalOtherScenarios}
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="project-summary-content">

            <div class="card-content">
                <p class="card-title"><b>Triggered By</b></p>
                <div class="card-data">
                    <div class="card-start-line"></div>
                    ${triggeredUserName}<br>
                </div>
            </div>

            <div class="card-content">
                <p class="card-title"><b>Test Host</b></p>
                <div class="card-data">
                    <div class="card-start-line"></div>
                    ${triggeredHostName}<br>
                </div>
            </div>

            <div class="card-content">
                <p class="card-title"><b>Execution Time</b></p>
                <div class="card-data">
                    <div class="card-start-line"></div>
                    ${totalExecutionTime}<br>
                </div>
            </div>

        </div>

    </div>
</div>