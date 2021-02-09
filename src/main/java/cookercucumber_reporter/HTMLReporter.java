package cookercucumber_reporter;

import com.google.gson.Gson;
import common.fileFactory.FileUtility;
import common.utils.TimeUtility;
import cookercucumber_reporter.json_pojos.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 09/02/2021
 * @project cooker-report-plugin
 */
public class HTMLReporter {
    String JSONSPATH = null;
    String HTMLPATH = null;
    String LOGPATH = null;
    String userName = null;
    String hostName = null;
    String userLetter = null;
    String projectName = null;

    public HTMLReporter(String jsonPath, String htmlpath, String logpath,String projectName) {
        this.JSONSPATH = jsonPath;
        this.HTMLPATH = htmlpath;
        this.LOGPATH = logpath;
        this.projectName = projectName;
        userName = (System.getProperty("user.name")).replaceAll("\\$","\\\\\\$");
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostName = "NA";
        }
        userLetter = (userName.charAt(0) + "").toUpperCase();
    }

    public void genHTML() {
        try {
            List<FeaturePOJO> jsons = getJSONsToList(JSONSPATH);

            InputStream resourceAsStream = getClass().getResourceAsStream("/template/temp.html");
            Scanner s = new Scanner(resourceAsStream).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";

            String html = result;
            //System.out.println("html = " + html);
            //FileUtility.readAndGetFileContent(manual.getAbsolutePath());
            StringBuffer sb = new StringBuffer();

            //DASH BOARD DATA
            //Report Generated Time Stamp
            String generatedDate = TimeUtility.getCurrTimeStamp();

            //Total Execution Duration
            long totalDuration = 0l;
            for (FeaturePOJO featurePOJO : jsons) {
                for (Elements elements : featurePOJO.getElements()) {
                    if (elements.getType().equalsIgnoreCase("scenario")) {
                        totalDuration = totalDuration + getElementDuration(elements);
                    }
                }
            }
            String totalExectime = TimeUtility.convertNanosecondsToTimeString(totalDuration);

            //Get Total Feature Details & Total Sceanrio Details
            List<Map<String, Integer>> maps = getfeatureInfo(jsons);
            int featureCount = maps.get(0).get("featureCount");
            int featurePass = maps.get(0).get("featurePass");
            int featureFail = maps.get(0).get("featureFail");
            int featureSkip = maps.get(0).get("featureSkip");
            int featureOther = maps.get(0).get("featureOther");
            int scenarioCount = maps.get(0).get("scenarioCount");
            int scenarioPass = maps.get(0).get("scenarioPass");
            int scenarioFail = maps.get(0).get("scenarioFail");
            int scenarioSkip = maps.get(0).get("scenarioSkip");
            int scenarioOther = maps.get(0).get("scenarioOther");

            //FEATURES DATA Table
            String featurePageData = getFeatureDataforHTML(jsons);

            String dashbord = html.replaceAll("@PROFILELETTER", userLetter)
                    .replaceAll("@REPORTGENERATIONDATE", generatedDate)
                    .replaceAll("@PROJECTNAME", projectName)
                    .replaceAll("@EXECUTORNAME", userName)
                    .replaceAll("@HOSTNAME", hostName)
                    .replaceAll("@TOTALEXECUTIONTIME", totalExectime)
                    .replaceAll("@TOTALFEATURES", featureCount + "")
                    .replaceAll("@FEATUREPASS", featurePass + "")
                    .replaceAll("@FEATUREFAIL", featureFail + "")
                    .replaceAll("@FEATURESKIP", featureSkip + "")
                    .replaceAll("@FEATUREOTHERS", featureOther + "")
                    .replaceAll("@TOTALSCENARIO", scenarioCount + "")
                    .replaceAll("@SCENARIOPASS", scenarioPass + "")
                    .replaceAll("@SCENARIOFAIL", scenarioFail + "")
                    .replaceAll("@SCENARIOSKIP", scenarioSkip + "")
                    .replaceAll("@SCENARIOOTHERS", scenarioOther + "")
                    .replaceAll("@FEATUREDATA", featurePageData);

            if (LOGPATH.equalsIgnoreCase("none")) {
                dashbord = dashbord.replaceAll("@LOGDATA","Log not specified/generated");
            }
            if (!LOGPATH.equalsIgnoreCase("none")) {
                FileUtility fileUtility = new FileUtility(LOGPATH);
                List<File> files = fileUtility.getFiles(".log");
                Map<String, String> logData = new HashMap<>();
                for (File file : files
                ) {
                    logData.put(file.getName(), FileUtility.readAndGetFileContent(file.getAbsolutePath()));

                }

                String logTemp =
                        "<h1>@LOGFILENAME</h1>" +
                                "<br>" +
                                "<p>@LOGFILEDATA</p>" +
                                "<br>";
                String log = "";
                for (Map.Entry<String, String> entry : logData.entrySet()) {
                    log = log + "\n" + logTemp.replaceAll("@LOGFILENAME", entry.getKey())
                            .replaceAll("@LOGFILEDATA", entry.getValue());
                }

                dashbord = dashbord.replaceAll("@LOGDATA", log);
            }


            FileUtility.createRunnerandFeatureDir(new File(HTMLPATH));

            FileUtility.writeAndCreateFile(dashbord, HTMLPATH + "\\cooker_cucumber_report_"
                    + TimeUtility.getCurrTimeStampUnderscore() + ".html");
        } catch (Exception e) {
            System.err.println("Error in Generating HTML : " + e.getMessage());
        }


    }

    private List<Map<String, Integer>> getfeatureInfo(List<FeaturePOJO> jsons) {
        int featureCount = 0, featurePass = 0, featureFail = 0, featureSkip = 0, featureOther = 0;
        int scenarioCount = 0, scenarioPass = 0, scenarioFail = 0, scenarioSkip = 0, scenarioOther = 0;
        for (FeaturePOJO featurePOJO : jsons) {
            featureCount++;
            List<Elements> elements = featurePOJO.getElements();
            int pass = 0, fail = 0, skip = 0, other = 0;
            for (Elements element : elements) {
                Map<String, String> scnData = new HashMap<>();
                String str = element.getType();
                if (str.equalsIgnoreCase("scenario")) {
                    scenarioCount++;
                    String elementPassStatus = getElementPassStatus(element);
                    if (elementPassStatus.equalsIgnoreCase("pass")) {
                        pass++;
                        scenarioPass++;
                    } else if (elementPassStatus.equalsIgnoreCase("fail")) {
                        fail++;
                        scenarioFail++;
                    } else if (elementPassStatus.equalsIgnoreCase("skip")) {
                        skip++;
                        scenarioSkip++;
                    } else {
                        other++;
                        scenarioOther++;
                    }
                }
            }
            if (fail != 0) {
                featureFail++;
                //break;
            } else if (fail == 0 && skip != 0) {
                featureSkip++;
                //break;
            } else if (fail == 0 && skip == 0 && other != 0) {
                featureOther++;
                //break;
            } else {
                featurePass++;
            }

        }
        Map<String, Integer> data = new HashMap<>();
        data.put("featureCount", featureCount);
        data.put("featurePass", featurePass);
        data.put("featureFail", featureFail);
        data.put("featureSkip", featureSkip);
        data.put("featureOther", featureOther);
        data.put("scenarioCount", scenarioCount);
        data.put("scenarioPass", scenarioPass);
        data.put("scenarioFail", scenarioFail);
        data.put("scenarioSkip", scenarioSkip);
        data.put("scenarioOther", scenarioOther);

        List<Map<String, Integer>> res = new ArrayList<>();
        res.add(data);
        return res;

    }

    private List<FeaturePOJO> getJSONsToList(String jsonspath) throws Exception {
        List<FeaturePOJO> total = new ArrayList<FeaturePOJO>();
        Gson gson = new Gson();

        FileUtility featurecontent = new FileUtility(jsonspath);
        //Get all *.feature files from existing feature files directory
        List<File> featurefiles = featurecontent.getFiles(".json");

        if (featurefiles.size() > 0) {
            for (File jsonFile : featurefiles) {
                String str = FileUtility.readAndGetFileContent(jsonFile.getPath());
                FeaturePOJO[] featurePOJOS = gson.fromJson(str, FeaturePOJO[].class);
                total.addAll(Arrays.asList(featurePOJOS));
            }
        }
        return total;
    }

    private String getFeatureDataforHTML(List<FeaturePOJO> jsons) throws IOException {

        StringBuffer mainData = new StringBuffer();
        String featureHolder =
                " <tr class=\" header\">\n" +
                        "                        <th>@FEATURENAME</th>\n" +
                        "                        <th><i class=\"material-icons\" id=\"@FEATURESTATUSICONID\">@FEATURESTATUSICON</i></th>\n" +
                        "                        <th>@FEATUREDURATION</th>\n" +
                        "                        <th style=\"display: none;\" colspan=\"2\"><span class=\"material-icons\">expand_more</span></th>\n" +
                        "                    </tr>";

        String scenarioholder =
                " <tr>\n" +
                        "                        <td>@SCENARIONAME</td>\n" +
                        "                        <td><i class=\"material-icons\" id=\"@SCENARIOSTATUSICONID\">@SCENARIOSTATUSICON</i></td>\n" +
                        "                        <td>@SCENARIODURATION</td>\n" +
                        "                    </tr>";

        for (FeaturePOJO featurePOJO : jsons) {


            String name = featurePOJO.getName();
            System.out.println("name = " + name);
            String statusicon = "";
            String statusiconId = "";
            long featuretime = 0l;

            List<Map<String, String>> scenarioData = new ArrayList<>();

            List<Elements> elements = featurePOJO.getElements();

            int pass = 0, fail = 0, skip = 0;
            for (Elements element : elements) {
                Map<String, String> scnData = new HashMap<>();
                String str = element.getType();
                if (str.equalsIgnoreCase("scenario")) {
                    scnData.put("scnName", element.getName());
                    String elementPassStatus = getElementPassStatus(element);
                    if (elementPassStatus.equalsIgnoreCase("pass")) {
                        scnData.put("scnstaticon", "check");
                        scnData.put("scnstaticonid", "passicon");
                        pass++;
                    } else if (elementPassStatus.equalsIgnoreCase("fail")) {
                        scnData.put("scnstaticon", "close");
                        scnData.put("scnstaticonid", "failicon");
                        fail++;
                    } else if (elementPassStatus.equalsIgnoreCase("skip")) {
                        scnData.put("scnstaticon", "warning_amber");
                        scnData.put("scnstaticonid", "skipicon");
                        skip++;
                    }
                    long res = getElementDuration(element);
                    featuretime = featuretime + res;
                    String scnDur = TimeUtility.convertNanosecondsToTimeString(res);
                    scnData.put("scnduration", scnDur);

                    scenarioData.add(scnData);
                }

            }
            if (fail != 0) {
                statusicon = "cancel";
                statusiconId = "failicon";
                //break;
            } else if (fail == 0 && skip != 0) {
                statusicon = "warning";
                statusiconId = "skipicon";
                //break;
            } else {
                statusicon = "check_circle";
                statusiconId = "passicon";
                //break;
            }

            String featurDur = TimeUtility.convertNanosecondsToTimeString(featuretime);
            mainData.append("\n");
            mainData.append(featureHolder
                    .replaceAll("@FEATURENAME", name)
                    .replaceAll("@FEATURESTATUSICONID", statusiconId)
                    .replaceAll("@FEATURESTATUSICON", statusicon)
                    .replaceAll("@FEATUREDURATION", featurDur));
            mainData.append("\n");
            for (Map<String, String> scn : scenarioData) {

                mainData.append(scenarioholder
                        .replaceAll("@SCENARIONAME", scn.get("scnName"))
                        .replaceAll("@SCENARIOSTATUSICONID", scn.get("scnstaticonid"))
                        .replaceAll("@SCENARIOSTATUSICON", scn.get("scnstaticon"))
                        .replaceAll("@SCENARIODURATION", scn.get("scnduration")));
                mainData.append("\n");
            }


        }

        return mainData.toString();
    }

    private String getElementPassStatus(Elements elements) {
        String status1 = null;

        int totalFail = 0, totalSkip = 0, totalPass = 0;

        Elements e = elements;

        if (e.getType().equalsIgnoreCase("scenario")) {
            int pass = 0, fail = 0, skip = 0;

            //Before Scenario
            List<BeforeHook> beforeHooks = e.getBefore();
            for (BeforeHook bf : beforeHooks) {
                String beforeStatus = bf.getResult().getStatus();
                if (beforeStatus.equalsIgnoreCase("passed")) {
                    pass++;
                } else if (beforeStatus.equalsIgnoreCase("failed")) {
                    fail++;
                } else if (beforeStatus.equalsIgnoreCase("skipped")) {
                    skip++;
                }
            }

            //totalScenarios = totalScenarios + 1;


            for (Steps s : e.getSteps()) {

                //Before Step
                List<BeforeHook> beforeStepHooks = s.getBefore();
                for (BeforeHook bf : beforeStepHooks) {
                    String beforeStatus = bf.getResult().getStatus();
                    if (beforeStatus.equalsIgnoreCase("passed")) {
                        pass++;
                    } else if (beforeStatus.equalsIgnoreCase("failed")) {
                        fail++;
                    } else if (beforeStatus.equalsIgnoreCase("skipped")) {
                        skip++;
                    }
                }

                String status = s.getResult().getStatus();
                if (status.equalsIgnoreCase("passed")) {
                    pass++;
                } else if (status.equalsIgnoreCase("failed")) {
                    fail++;
                } else if (status.equalsIgnoreCase("skipped")) {
                    skip++;
                }

                //After Step
                List<AfterHook> afterStephooks = s.getAfter();
                for (AfterHook af : afterStephooks) {
                    String afterStatus = af.getResult().getStatus();
                    if (afterStatus.equalsIgnoreCase("passed")) {
                        pass++;
                    } else if (afterStatus.equalsIgnoreCase("failed")) {
                        fail++;
                    } else if (afterStatus.equalsIgnoreCase("skipped")) {
                        skip++;
                    }
                }

            }

            //After Scenario
            List<AfterHook> afterhooks = e.getAfter();
            for (AfterHook af : afterhooks) {
                String afterStatus = af.getResult().getStatus();
                if (afterStatus.equalsIgnoreCase("passed")) {
                    pass++;
                } else if (afterStatus.equalsIgnoreCase("failed")) {
                    fail++;
                } else if (afterStatus.equalsIgnoreCase("skipped")) {
                    skip++;
                }
            }


            if (fail != 0) {
                totalFail++;
                //break;
            } else if (fail == 0 && skip != 0) {
                totalSkip++;
                //break;
            } else {
                totalPass++;
                //break;
            }

        }

        if (totalPass != 0 & totalFail == 0 & totalSkip == 0) {
            status1 = "PASS";
        } else if (totalFail != 0) {
            status1 = "FAIL";
        } else if (totalPass == 0 & totalFail == 0 & totalSkip != 0) {
            status1 = "SKIP";
        }

        //System.out.println(status1);

        return status1 + "";
    }

    private long getElementDuration(Elements elements) {
        long res = 0l;

        Elements e = elements;

        if (e.getType().equalsIgnoreCase("scenario")) {
            int pass = 0, fail = 0, skip = 0;

            //Before Scenario
            List<BeforeHook> beforeHooks = e.getBefore();
            for (BeforeHook bf : beforeHooks) {
                res = res + bf.getResult().getDuration();
            }

            //totalScenarios = totalScenarios + 1;


            for (Steps s : e.getSteps()) {

                res = res + s.getResult().getDuration();

                //Before Step
                List<BeforeHook> beforeStepHooks = s.getBefore();
                for (BeforeHook bf : beforeStepHooks) {
                    res = res + bf.getResult().getDuration();
                }

                //After Step
                List<AfterHook> afterStephooks = s.getAfter();
                for (AfterHook af : afterStephooks) {
                    res = res + af.getResult().getDuration();
                }

            }

            //After Scenario
            List<AfterHook> afterhooks = e.getAfter();
            for (AfterHook af : afterhooks) {
                res = res + af.getResult().getDuration();
            }
        }

        return res;
    }

}
