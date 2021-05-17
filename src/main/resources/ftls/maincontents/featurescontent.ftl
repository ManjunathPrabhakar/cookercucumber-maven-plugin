<div class="features-content">
    <div class="container-title">Features
        <i id="featuresinfo-tooltip" style="margin-left: 5px; font-size: medium;" class="fa fa-info-circle"
           aria-hidden="true"></i>
    </div>

    <!-- SEARCH FILTERS START -->
    <div class="card-content">
        <p class="card-title">Search here</p>
        <div class="card-data">
            <div class="card-start-line"></div>
            <p>Filter</p>
        </div>
    </div>

    <div class="card-content">
        <p class="card-title">By Feature Name</p>
        <div class="card-data">
            <div class="card-start-line"></div>
            <input type="text" id="myInput" onkeyup="featureSearch()" placeholder="Search feature names.."><br>
        </div>
    </div>

    <div class="card-content">
        <p class="card-title">By Status</p>
        <div class="card-data">
            <div class="card-start-line"></div>
            <input type="checkbox" class="statuscheckbox" id="statuspass" name="pass" checked
                   onclick="featureSearch()" value="Pass">
            <label for="statuspass"> Pass</label>
            <input type="checkbox" class="statuscheckbox" id="statusfail" name="fail" checked
                   onclick="featureSearch()" value="Fail">
            <label for="statusfail"> Fail</label>
            <input type="checkbox" class="statuscheckbox" id="statusskip" name="skip" checked
                   onclick="featureSearch()" value="Skip">
            <label for="statusskip"> Skip</label>
            <input type="checkbox" class="statuscheckbox" id="statusothers" checked name="others"
                   onclick="featureSearch()" value="Others">
            <label for="statusothers"> Others</label>
        </div>
    </div>

    <div class="card-content">
        <p class="card-title">Clear</p>
        <div class="card-data" onclick="resetfeaturefilter()">
            <div class="card-start-line"></div>
            <i class="material-icons">cancel</i><br>
        </div>
    </div>
    <!-- SEARCH FILTERS END -->


    <div class="featurecoll" style="text-align: center;">

        <#list featurepojos as feature>
            <!-- Features List Start -->
            <!-- Feature Start -->
            <button type="button" class="collapsibleM">
                <div class="featbar">
                    <!-- FEATURE NAME -->
                    <label class="${feature.getStatus()}feature"
                           data-feature-uri="${feature.getStatus()}featurefile.feature">
                            <span>
                                <b>
                                     <#if feature.getStatus() == "pass">
                                         <i class="fa fa-check-circle" aria-hidden="true"
                                            style="color: var(--pass-color-lightcolor);"></i>
                                     </#if>
                                    <#if feature.getStatus() == "fail">
                                        <i class="fa fa-times-circle" aria-hidden="true"
                                           style="color: var(--fail-color-lightcolor);"></i>
                                    </#if>
                                    <#if feature.getStatus() == "skip">
                                        <i class="fa fa-exclamation-circle" aria-hidden="true"
                                           style="color: var(--skip-color-lightcolor);"></i>
                                    </#if>
                                    <#if feature.getStatus() == "other">
                                        <i class="fa fa-minus-circle" aria-hidden="true"
                                           style="color: var(--others-color-lightcolor);"></i>
                                    </#if>

                                    <i class="fa fa-file-text-o" aria-hidden="true"></i>
                                </b>
                                ${feature.getName()}
                            </span>
                    </label>

                    <!-- FEATURE STATUS -->
                    <label>

                        <#list feature.getFeaturesStatusesCount() as status, statusCounts>

                            <#if status == "pass" && statusCounts != "0">
                                <!-- PASS COUNT -->
                                <span class="tagchip" style="color: rgb(0,190,170);background: rgb(235, 254, 252);">
                                <span class="tagname">
                                    <!-- <i class="material-icons" style="vertical-align: -6px;">sell</i> -->
                                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                                    ${statusCounts}
                                </span>
                                </span>
                            </#if>

                            <#if status == "fail" && statusCounts != "0">
                                <!-- FAIL COUNT -->
                                <span class="tagchip">
                                <span class="tagname">
                                    <!-- <i class="material-icons" style="vertical-align: -6px;">sell</i> -->
                                    <i class="fa fa-times-circle" aria-hidden="true"></i>
                                    ${statusCounts}
                                </span>
                            </span>
                            </#if>

                            <#if status == "skip" && statusCounts != "0">
                                <!-- SKIP COUNT -->
                                <span class="tagchip" style="color: rgb(171, 190, 0);background: rgb(254, 254, 235);">
                                <span class="tagname">
                                    <!-- <i class="material-icons" style="vertical-align: -6px;">sell</i> -->
                                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                    ${statusCounts}
                                </span>
                            </span>
                            </#if>

                            <#if status == "other" && statusCounts != "0">
                                <!-- OTHERS COUNT -->
                                <span class="tagchip" style="color: rgb(0, 51, 190);background: rgb(235, 243, 254);">
                                <span class="tagname">
                                    <!-- <i class="material-icons" style="vertical-align: -6px;">sell</i> -->
                                    <i class="fa fa-minus-circle" aria-hidden="true"></i>
                                    ${statusCounts}
                                </span>
                            </span>
                            </#if>
                        </#list>

                        <span style="font-size: small;">${feature.getDurationStringFormat(feature.getDuration())}</span>

                    </label>
                </div>
            </button>
            <div class="contentM">
                <#if !(feature.getDescription() == "")>
                    <span>Description: ${feature.getDescription()}</span>
                </#if>
                <div style="text-align: left;" class="chip">
                    <#list feature.getTags() as tag>
                        <span class="tagchip"
                              style="margin-left:1vw;color: rgb(10, 10, 10);background: rgb(134, 226, 109); font-size: small;">
                        <span class="tagname">
                            <i class="fa fa-tag" aria-hidden="true"></i>
                            <span class="featureTagName">${tag.getTagName()}</span>
                        </span>
                    </span>
                    </#list>
                </div>
                <#if !(feature.getUri() == "")>
                    <span>URI: ${feature.getUri()}</span>
                </#if>

                <!-- Trigger/Open The Modal -->
                <#list feature.getElements() as elements>
                    <#if elements.getType() == "scenario">
                        <button class="scenario" onclick="showPopUp(this,'f${feature?index}s${elements?index}')">
                            <div class="featbar">
                                <label>
                                    <#if elements.getStatus() == "pass">
                                        <i class="fa fa-check-circle" aria-hidden="true"
                                           style="color: var(--pass-color-lightcolor);"></i>
                                    </#if>
                                    <#if elements.getStatus() == "fail">
                                        <i class="fa fa-times-circle" aria-hidden="true"
                                           style="color: var(--fail-color-lightcolor);"></i>
                                    </#if>
                                    <#if elements.getStatus() == "skip">
                                        <i class="fa fa-exclamation-circle" aria-hidden="true"
                                           style="color: var(--skip-color-lightcolor);"></i>
                                    </#if>
                                    <#if elements.getStatus() == "other">
                                        <i class="fa fa-minus-circle" aria-hidden="true"
                                           style="color: var(--others-color-lightcolor);"></i>
                                    </#if>
                                    <i class="material-icons" style="vertical-align: middle;">view_list</i>
                                    ${elements.getKeyword()}: ${elements.getName()}
                                </label>


                                <label>
                                    <span style="font-size: small;"> ${elements.getDurationStringFormat(elements.getDuration())} </span>
                                </label>
                            </div>
                        </button>
                    </#if>
                </#list>
            </div>
            <!-- Feature End -->
        </#list>

    </div>
</div>