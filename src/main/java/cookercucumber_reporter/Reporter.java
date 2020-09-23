package cookercucumber_reporter;

import cookercucumber_reporter.json_pojos.Elements;
import cookercucumber_reporter.json_pojos.FeaturePOJO;
import cookercucumber_reporter.json_pojos.Steps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 20/09/2020
 * @project cooker-cucumber-reporter
 */
public class Reporter {

    public static List<String> generateReport(List<FeaturePOJO> allJsonFiles) {

//        List<String> featureNames = new ArrayList<>();
//        Map<String,Integer> totalScenarios = new HashMap<>();
//        Map<String,Integer> totalPass = new HashMap<>();
//        Map<String,Integer> totalFail = new HashMap<>();
//        Map<String,Integer> totalSkip = new HashMap<>();
//        Map<String,Integer> passPercentage = new HashMap<>();
        /*
        | Feature Name | Total Scenarios | Passed | Failed | Skipped | Pass% |
        |              |  SUM(Scenarios) | sum|sum|sum
         */
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
            double passPercentage = 0;


            featureName = featurePOJO.getName();
            rows.add(featureName);

            List<Elements> elements = featurePOJO.getElements();
            for (Elements e : elements) {


                if (e.getType().equalsIgnoreCase("scenario")) {
                    totalScenarios = totalScenarios + 1;

                    int pass = 0, fail = 0, skip = 0;
                    for (Steps s : e.getSteps()) {
                        String status = s.getResult().getStatus();
                        if (status.equalsIgnoreCase("passed")) {
                            pass++;
                        } else if (status.equalsIgnoreCase("failed")) {
                            fail++;
                        } else if (status.equalsIgnoreCase("skipped")) {
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


            rows.add(((totalPass / totalScenarios) * 100) + "%");

            data.add(rows);
            //System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", featureName, totalScenarios, totalPass, totalFail, totalSkip, ((totalPass / totalScenarios) * 100) + "%");
        }
        sumPassPercentage = (sumPass / sumScenarios) * 100 + "%";

        List<String> footer = new ArrayList<>();
        footer.add("");
        footer.add(sumScenarios + "");
        footer.add(sumPass + "");
        footer.add(sumFail + "");
        footer.add(sumSkip + "");
        footer.add(sumPassPercentage + "");

        data.add(footer);

        return printInTabluarForm(data);
    }

    private static List<String> printInTabluarForm(List<List<String>> data) {

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
}
