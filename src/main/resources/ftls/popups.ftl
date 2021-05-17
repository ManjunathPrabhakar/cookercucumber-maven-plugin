<!--pop ups start-->
<div class="pop-ups">

    <#list featurepojos as feature>

        <#list feature.getElements() as element>

            <#if element.getType() == "scenario">
                <!-- The Modal -->
                <div id="f${feature?index}s${element?index}" class="modal">

                    <!-- Modal content -->
                    <div class="modal-content">
                        <div class="modal-header">
                            <span class="close">&times;</span>
                            <h2><b>${element.getKeyword()}</b></h2>
                        </div>
                        <div class="modal-body">
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
                            </#if>
                            <div style="text-align: center">
                                <button type="button" class="collapsibleM">
                                    <div class="featbar">
                                        <label>
                                            <p>${element.getKeyword()}: ${element.getName()}</p>
                                        </label>
                                    </div>

                                </button>
                                <div style="text-align: start" class="contentM">
                                    <p>Type : ${element.getType()}</p>
                                    <p>Description : ${element.getDescription()}</p>
                                </div>
                            </div>

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

                                                <table border="1px black solid"
                                                       style="margin: 2px;width: 100%; border-collapse: collapse;">
                                                    <tbody border="1px black solid">
                                                        <tr><th>Arguments</th></tr>
                                                    <#list steps.getMatch().getArguments() as args>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">
                                                                <pre style=" white-space:pre-wrap; padding: 1px; font-family: monospace; font-size: medium;">${args.getVal()}</pre>
                                                            </td>
                                                        </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>

                                            </#if>
                                        </#if>

                                        <!-- STEP DATATABLE -->
                                        <#if steps.getRows()?has_content>
                                            <table border="1px solid black"
                                                   style="margin: 2px;border-collapse: collapse; width: 100%;">
                                                <tbody>
                                                <tr><th>Datatable</th></tr>
                                                <#list steps.getRows() as datatable>
                                                    <tr border="1px solid black">
                                                        <#list datatable.getCells() as cells>
                                                            <td style="padding: 2px;"
                                                                border="1px solid black">${cells}</td>
                                                        </#list>
                                                    </tr>
                                                </#list>
                                                </tbody>
                                            </table>
                                        </#if>

                                        <!-- STEP ERROR MESSAGE -->
                                        <#if steps.getResult().getErrorMessage()?has_content>

                                            <table border="1px red solid" ;
                                                   style="margin: 2px;width: 100%; border-collapse: collapse;">
                                                <tbody border="1px red solid" ;>
                                                <tr><th>Error Message</th></tr>
                                                <tr border="1px red solid" ;>
                                                    <td border="1px red solid" ;>
                                                    <pre class="error"
                                                         style="padding: 5px; color: red; font-size: small;">${steps.getResult().getErrorMessage()}</pre>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </#if>

                                        <!-- STEP EMBEDDING -->
                                        <#if steps.getEmbeddings()?has_content>
                                            <#list steps.getEmbeddings() as embedding>

                                                <#if embedding.getMime_type() == 'image/png'>
                                                    <table border="1px black solid"
                                                           style="margin: 2px; width: 100%;border-collapse: collapse;">
                                                        <tbody border="1px black solid">
                                                        <tr><th>Screenshot Embed</th></tr>
                                                        <#if !(embedding.getName() == '')>
                                                            <tr border="1px black solid">
                                                                <td border="1px black solid">${embedding.getName()}</td>
                                                            </tr>
                                                        </#if>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">
                                                                <style>
                                                                    #pic1:hover{
                                                                        cursor: pointer;
                                                                    }
                                                                </style>

                                                                <img id="pic1" class="materialboxed"
                                                                     onclick="displayImage(this)"
                                                                     data-caption='embedding'
                                                                     width="250"
                                                                     src="data:image/png;base64,${embedding.getData()}">
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </#if>

                                                <#if embedding.getMime_type() == 'text/html'>
                                                    <table border="1px black solid"
                                                           style="width: 100%;margin: 2px;border-collapse: collapse;">
                                                        <tbody border="1px black solid">
                                                        <tr><th>HTML Embed</th></tr>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">${embedding.getName()}</td>
                                                        </tr>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">${embedding.getDecodedData(embedding.getData())}</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </#if>

                                                <#if embedding.getMime_type() == 'text/plain'>
                                                    <table border="margin: 2px;1px black solid"
                                                           style="width: 100%; border-collapse: collapse;">
                                                        <tbody border="1px black solid">
                                                        <tr><th>Plain text Embed</th></tr>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">${embedding.getName()}</td>
                                                        </tr>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">
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
                                            <#list steps.getOutput() as output>

                                                <#if output??>
                                                    <table border="1px black solid"
                                                           style="margin: 2px;width: 100%; border-collapse: collapse;">
                                                        <tbody border="1px black solid">
                                                        <tr><th>Output</th></tr>
                                                        <tr border="1px black solid">
                                                            <td border="1px black solid">
                                                                <pre style=" white-space:pre-wrap; padding: 1px; font-family: monospace; font-size: medium;">${output}</pre>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </#if>
                                            </#list>
                                        </#if>

                                        <!-- STEP DOCSTRING -->
                                        <#if steps.getDocStrings()?has_content>
                                            <#if steps.getDocStrings().getValue()??>
                                                <table border="1px black solid"
                                                       style="margin: 2px;width: 100%; border-collapse: collapse;">
                                                    <tbody border="1px black solid">
                                                    <tr><th>Doc Strings</th></tr>
                                                    <tr border="1px black solid">
                                                        <td border="1px black solid">
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
                            <h3>...</h3>
                        </div>
                    </div>

                </div>

            </#if>
        </#list>

    </#list>


</div>
<!-- popups end -->