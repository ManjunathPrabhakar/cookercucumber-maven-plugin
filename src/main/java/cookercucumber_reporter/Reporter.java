package cookercucumber_reporter;

import com.google.gson.Gson;
import common.fileFactory.FileUtility;
import cookercucumber_reporter.json_pojos.*;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 20/09/2020
 * @project cooker-cucumber-reporter
 */
public class Reporter {

    public List<String> generateReport(String jsonPath) throws Exception {
        List<FeaturePOJO> total = new ArrayList<>();
        Gson gson = new Gson();

        FileUtility featurecontent = new FileUtility(jsonPath);
        //Get all *.feature files from existing feature files directory
        List<File> featurefiles = featurecontent.getFiles(".json");

        if (featurefiles.size() > 0) {
            for (File jsonFile : featurefiles) {
                String str = FileUtility.readAndGetFileContent(jsonFile.getPath());
                FeaturePOJO[] featurePOJOS = gson.fromJson(str, FeaturePOJO[].class);
                total.addAll(Arrays.asList(featurePOJOS));
            }
        }

        return gatherSummarizeData(total);

    }

    private List<String> gatherSummarizeData(List<FeaturePOJO> allJsonFiles) {

        int sumScenarios = 0, sumPass = 0, sumFail = 0, sumSkip = 0;
        String sumPassPercentage = "%";

        List<List<String>> data = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("FeatureName");
        header.add("Total Scenarios");
        header.add("Total Pass");
        header.add("Total Fail");
        header.add("Total Skip");
        header.add("Pass %");
        data.add(header);

        //System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Feature Name", "Total Scenarios", "Total Pass", "Total Fail", "Total Skip", "Pass Percentage");

        for (FeaturePOJO featurePOJO : allJsonFiles) {
            List<String> rows = new ArrayList<>();

            String featureName;
            int totalScenarios = 0, totalPass = 0, totalFail = 0, totalSkip = 0;

            featureName = featurePOJO.getName();
            rows.add(featureName);

            List<Elements> elements = featurePOJO.getElements();
            for (Elements e : elements) {


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

                    totalScenarios = totalScenarios + 1;


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

            }
            sumScenarios = sumScenarios + totalScenarios;
            rows.add(totalScenarios + "");

            sumPass = sumPass + totalPass;
            rows.add(totalPass + "");

            sumFail = sumFail + totalFail;
            rows.add(totalFail + "");

            sumSkip = sumSkip + totalSkip;
            rows.add(totalSkip + "");


            String totalPercentage = calculatePercentage(totalPass, totalScenarios);

            rows.add(totalPercentage);

            data.add(rows);
        }
        sumPassPercentage = calculatePercentage(sumPass, sumScenarios);

        List<String> footer = new ArrayList<>();
        footer.add("");
        footer.add(sumScenarios + "");
        footer.add(sumPass + "");
        footer.add(sumFail + "");
        footer.add(sumSkip + "");
        footer.add(sumPassPercentage + "");

        data.add(footer);

        return gatherDataInList(data);
    }

    private List<String> gatherDataInList(List<List<String>> data) {

        List<String> res = new ArrayList<>();

        int maxFeatureLength = 0, maxTotalScenariosLength = 0, maxTotPassLen = 0, maxTotFailLen = 0, maxTotSkipLen = 0, maxPassPer = 0;

        for (List<String> s : data) {
            int len = 0;
            len = s.get(0).length();
            if (len > maxFeatureLength) {
                maxFeatureLength = len;
            }
            len = s.get(1).length();
            if (len > maxTotalScenariosLength) {
                maxTotalScenariosLength = len;
            }
            len = s.get(2).length();
            if (len > maxTotPassLen) {
                maxTotPassLen = len;
            }
            len = s.get(3).length();
            if (len > maxTotFailLen) {
                maxTotFailLen = len;
            }
            len = s.get(4).length();
            if (len > maxTotSkipLen) {
                maxTotSkipLen = len;
            }
            len = s.get(5).length();
            if (len > maxPassPer) {
                maxPassPer = len;
            }

        }

        maxFeatureLength = maxFeatureLength + 3;
        maxTotalScenariosLength = maxTotalScenariosLength + 3;
        maxTotPassLen = maxTotPassLen + 3;
        maxTotFailLen = maxTotFailLen + 3;
        maxTotSkipLen = maxTotSkipLen + 3;
        maxPassPer = maxPassPer + 3;

        boolean line = false;
        int dataCount = 0;
        int dataLimit = data.size() - 1;
        List<String> dataToLog = new ArrayList<>();
        for (List<String> ls : data) {
            String format = String.format("|%-" + maxFeatureLength + "s|%-" + (maxTotalScenariosLength)
                            + "s|%-" + maxTotPassLen + "s|%-" + maxTotFailLen + "s|%-" + maxTotSkipLen + "s|%-" + maxPassPer + "s|",
                    " " + ls.get(0), " " + ls.get(1), " " + ls.get(2), " " + ls.get(3), " " + ls.get(4), " " + ls.get(5));

            dataToLog.add(format);
        }

        String lines = "";

        int formatLen = dataToLog.get(0).length();
        for (int i = 0; i < formatLen; i++) {
            lines = lines + "-";
        }

        res.add(lines); //Line
        res.add(dataToLog.get(0)); //Header
        res.add(lines); //Line

        for (int i = 1; i < dataToLog.size() - 1; i++) {
            res.add(dataToLog.get(i));  //Rows
        }
        res.add(lines); //Line
        res.add(dataToLog.get(dataToLog.size() - 1)); //Footer
        res.add(lines); //Line


        return res;
    }

    private String calculatePercentage(double obtained, double total) {
        DecimalFormat df2 = new DecimalFormat("#.##");
        return df2.format(obtained * 100 / total) + "%";
    }
}
