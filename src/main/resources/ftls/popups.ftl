<!--pop ups start-->
<div class="pop-ups">
    <#list featurepojos as feature>
        <#list feature.getElements() as element>
            <#if element.getType() == "scenario">
                <!-- The Modal -->
                <div id="feat${feature?index}scn${element?index}" class="modal">
                    <!-- Modal content -->
                    <div class="modal-content">
                        <div class="modal-header">
                            <span class="close">&times;</span>
                            <span><b>${element.getKeyword()}: </b>${element.getName()}</span>
                        </div>
                        <div class="modal-body">

                            <#if !(element.getDescription() == "")>
                                <span>Description: ${element.getDescription()}</span>
                                <br>
                            </#if>

                            <#if element.getTags()?has_content>
                                <#list element.getTags() as tag>
                                    <span class="tagchip"
                                          style="margin-left:1vw;color: rgb(10, 10, 10);background: rgb(134, 226, 109); font-size: small;">
                                    <span class="tagname">
                                        <i class="fa fa-tag" aria-hidden="true"></i>
                                        <span class="featureTagName">${tag.getTagName()}</span>
                                    </span>
                                </span>
                                </#list>
                                <br>
                            </#if>

                            <#if !(element.getType() == "")>
                                <span>Type: ${element.getType()}</span>
                                <br>
                            </#if>

                            <#if !(element.getStart_timestamp() == "")>
                                <span>Start TimeStamp: ${element.getStart_timestamp()}</span>
                                <br>
                            </#if>

                            <#list element.getSteps() as steps>
                                <div style="text-align: center">
                                    <button type="button" class="collapsibleM">
                                        <div class="featbar">
                                            <label>
                                                <p>
                                                    <label>
                                                        <#if steps.getResult().getStatus() == "passed">
                                                            <i class="fa fa-check-circle" aria-hidden="true"
                                                               style="color: var(--pass-color-lightcolor);"></i>
                                                        <#elseif steps.getResult().getStatus() == "failed">
                                                            <i class="fa fa-times-circle" aria-hidden="true"
                                                               style="color: var(--fail-color-lightcolor);"></i>
                                                        <#elseif steps.getResult().getStatus() == "skipped">
                                                            <i class="fa fa-exclamation-circle" aria-hidden="true"
                                                               style="color: var(--skip-color-lightcolor);"></i>
                                                        <#else>
                                                            <i class="fa fa-minus-circle" aria-hidden="true"
                                                               style="color: var(--others-color-lightcolor);"></i>
                                                        </#if>
                                                        <b>${steps.getKeyword()} </b>${steps.getName()}
                                                    </label>
                                                </p>
                                            </label>
                                            <label>
                                                <span style="font-size: small;"> ${steps.getDurationStringFormat(steps.getDuration())} </span>
                                            </label>
                                        </div>
                                    </button>
                                    <div style="text-align: start" class="contentM">
                                        <!-- STEP ARGUMENTS -->
                                        <#if steps.getMatch()?has_content>
                                            <#if steps.getMatch().getArguments()?size gt 0>
                                                <table class="stepTable">
                                                    <tbody>
                                                    <tr>
                                                        <th>Arguments</th>
                                                    </tr>
                                                    <#list steps.getMatch().getArguments() as args>
                                                        <tr>
                                                            <td>
                                                                <pre style="white-space:pre-wrap; padding: 1px; font-family: monospace; font-size: medium;">${args.getVal()}</pre>
                                                            </td>
                                                        </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                            </#if>
                                        </#if>
                                        <!-- STEP DATATABLE -->
                                        <#if steps.getRows()?has_content>
                                            <table class="stepTable">
                                                <tbody>
                                                <tr>
                                                    <th>Datatable</th>
                                                </tr>
                                                <#list steps.getRows() as datatable>
                                                    <tr>
                                                        <#list datatable.getCells() as cells>
                                                            <td>${cells}</td>
                                                        </#list>
                                                    </tr>
                                                </#list>
                                                </tbody>
                                            </table>
                                        </#if>
                                        <!-- STEP ERROR MESSAGE -->
                                        <#if steps.getResult().getErrorMessage()?has_content>
                                            <table class="stepTable">
                                                <tbody>
                                                <tr>
                                                    <th>Error Message(s)</th>
                                                </tr>
                                                <tr>
                                                    <td>
                                                    <pre class="error"
                                                         style="font-family: monospace;white-space:pre-wrap; padding: 5px; color: #d20000; font-size: small;">${steps.getResult().getErrorMessage()}</pre>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </#if>
                                        <!-- STEP EMBEDDING -->
                                        <#if steps.getEmbeddings()?has_content>
                                            <#list steps.getEmbeddings() as embedding>
                                                <#if includeScreenshots == true>
                                                    <#if includeOnlyScreenshotsOfFailStep == true>
                                                        <#if !(steps.getResult().getStatus() == "passed")>
                                                            <#if embedding.getMime_type() == 'image/png'>
                                                                <table class="stepTable">
                                                                    <tbody>
                                                                    <tr>
                                                                        <th>Screenshot Embed</th>
                                                                    </tr>
                                                                    <#if !(embedding.getName() == '')>
                                                                        <tr>
                                                                            <td>${embedding.getName()}</td>
                                                                        </tr>
                                                                    </#if>
                                                                    <tr>
                                                                        <td>
                                                                            <style>
                                                                                .materialboxed:hover {
                                                                                    cursor: pointer;
                                                                                }
                                                                            </style>
                                                                            <img class="materialboxed"
                                                                                 onclick="displayImage(this)"
                                                                                 data-caption='embedding'
                                                                                 width="300"
                                                                                 src="data:image/png;base64,${embedding.getData()}">
                                                                        </td>
                                                                    </tr>
                                                                    </tbody>
                                                                </table>
                                                            </#if>
                                                        <#else>
                                                            <table class="stepTable">
                                                                <tbody>
                                                                <tr>
                                                                    <th><span style="font-size: small;">Captured Screenshot for passed step has been decided not to display with <b>includeOnlyScreenshotsOfFailStep=true</b></span>
                                                                    </th>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </#if>
                                                    <#else>
                                                        <#if embedding.getMime_type() == 'image/png'>
                                                            <table class="stepTable">
                                                                <tbody>
                                                                <tr>
                                                                    <th>Screenshot Embed</th>
                                                                </tr>
                                                                <#if !(embedding.getName() == '')>
                                                                    <tr>
                                                                        <td>${embedding.getName()}</td>
                                                                    </tr>
                                                                </#if>
                                                                <tr>
                                                                    <td>
                                                                        <style>
                                                                            .materialboxed:hover {
                                                                                cursor: pointer;
                                                                            }
                                                                        </style>
                                                                        <img class="materialboxed"
                                                                             onclick="displayImage(this)"
                                                                             data-caption='embedding'
                                                                             width="300"
                                                                             src="data:image/png;base64,${embedding.getData()}">
                                                                    </td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </#if>
                                                    </#if>
                                                </#if>
                                                <#if embedding.getMime_type() == 'text/html'>
                                                    <table class="stepTable">
                                                        <tbody>
                                                        <tr>
                                                            <th>HTML Embed</th>
                                                        </tr>
                                                        <tr>
                                                            <td>${embedding.getName()}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>${embedding.getDecodedData(embedding.getData())}</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </#if>
                                                <#if embedding.getMime_type() == 'text/plain'>
                                                    <table class="stepTable">
                                                        <tbody>
                                                        <tr>
                                                            <th>Plain text Embed</th>
                                                        </tr>
                                                        <tr>
                                                            <td>${embedding.getName()}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <pre style=" white-space:pre-wrap; padding: 1px; font-family: monospace; font-size: small;">${embedding.getDecodedData(embedding.getData())}</pre>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </#if>
                                            </#list>
                                        </#if>
                                        <!-- STEP OUTPUT -->
                                        <#if steps.getOutput()?has_content>
                                            <#if steps.getOutput()?size gt 0>
                                                <table class="stepTable">
                                                    <tbody>
                                                    <tr>
                                                        <th>Output</th>
                                                    </tr>
                                                    <#list steps.getOutput() as output>
                                                        <#if output??>
                                                            <tr>
                                                                <td>
                                                                    <pre style=" white-space:pre-wrap; padding: 1px; font-family: monospace; font-size: medium;">${output}</pre>
                                                                </td>
                                                            </tr>
                                                        </#if>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                            </#if>
                                        </#if>
                                        <!-- STEP DOCSTRING -->
                                        <#if steps.getDocStrings()?has_content>
                                            <#if steps.getDocStrings().getValue()??>
                                                <table class="stepTable">
                                                    <tbody>
                                                    <tr>
                                                        <th>Doc String(s)</th>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <pre style=" white-space:pre-wrap; padding: 1px; font-family: monospace; font-size: medium;">${steps.getDocStrings().getValue()}</pre>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </#if>
                                        </#if>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="modal-footer">
                            <h3>End of Scenario</h3>
                        </div>
                    </div>
                </div>
            </#if>
        </#list>
    </#list>
</div>
<!-- popups end -->