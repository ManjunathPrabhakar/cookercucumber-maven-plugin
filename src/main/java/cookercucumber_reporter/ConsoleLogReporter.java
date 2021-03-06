package cookercucumber_reporter;

import cookerMojoTrigger.MojoLogger;
import cookercucumber_reporter.json_pojos.Elements;
import cookercucumber_reporter.json_pojos.FeaturePOJO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleLogReporter {

    public void generateConsoleLog(Map<String, Object> params) throws Exception {
        //CODE GOES DOWN BELOW
        List<FeaturePOJO> jsons = ReportHandler.getJSONsToList(params.get("jsonPath").toString());
        List<FeaturePOJO> featurePOJOS = ReportHandler.combineMultipleScenariosOfSameFeature(jsons);

        MojoLogger.getLogger().info("----------------------------------------------------------");
        MojoLogger.getLogger().info("------------------- Features Overview --------------------");
        MojoLogger.getLogger().info("----------------------------------------------------------");
        MojoLogger.getLogger().info("Total Features      : " + params.get("totalFeatures").toString());
        MojoLogger.getLogger().info("Passed Features     : " + params.get("totalPassFeatures").toString());
        MojoLogger.getLogger().info("Failed Features     : " + params.get("totalFailFeatures").toString());
        MojoLogger.getLogger().info("Skipped Features    : " + params.get("totalSkipFeatures").toString());
        MojoLogger.getLogger().info("Other Features      : " + params.get("totalOtherFeatures").toString());
        MojoLogger.getLogger().info("Feature Pass %      : " + params.get("featurePassPercentage").toString() + "%");
        MojoLogger.getLogger().info("Overall Exec Time   : " + params.get("totalExecutionTime").toString());
        MojoLogger.getLogger().info("----------------------------------------------------------");
        MojoLogger.getLogger().info("------------------- Scenarios Overview -------------------");
        MojoLogger.getLogger().info("----------------------------------------------------------");
        MojoLogger.getLogger().info("Total Scenarios     : " + params.get("totalScenarios").toString());
        MojoLogger.getLogger().info("Passed Scenarios    : " + params.get("totalPassScenarios").toString());
        MojoLogger.getLogger().info("Failed Scenarios    : " + params.get("totalFailScenarios").toString());
        MojoLogger.getLogger().info("Skipped Scenarios   : " + params.get("totalSkipScenarios").toString());
        MojoLogger.getLogger().info("Other Scenarios     : " + params.get("totalOtherScenarios").toString());
        MojoLogger.getLogger().info("Scenarios Pass %    : " + params.get("scenariosPassPercentage").toString() + "%");
        MojoLogger.getLogger().info("----------------------------------------------------------");

        if (params.get("featurePassPercentage").toString().equalsIgnoreCase("100")) {
            return;
        }

        MojoLogger.getLogger().info("-------------- Features/Scenarios Broken! ----------------");
        int featureCount = 1;
        int scncount = 1;
        for (FeaturePOJO featurePOJO : featurePOJOS) {
            List<String> scenario = featurePOJO.getElements().stream().filter(s -> s.getType().equalsIgnoreCase("scenario") && !s.getStatus().equalsIgnoreCase("pass")).map(Elements::getName).collect(Collectors.toList());
            if (scenario.size() > 0) {
                MojoLogger.getLogger().info("----------------------------------------------------------");
                MojoLogger.getLogger().info("------------------------ Feature -------------------------");
                MojoLogger.getLogger().info("F" + featureCount++ + ". " + featurePOJO.getName());
                MojoLogger.getLogger().info("----------------------- Scenarios ------------------------");
                for (String a : scenario) {
                    MojoLogger.getLogger().info("S" + scncount++ + ". " + a);
                }
            }
            scncount = 1;
        }
        MojoLogger.getLogger().info("----------------------------------------------------------");
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

}
