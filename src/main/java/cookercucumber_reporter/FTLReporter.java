package cookercucumber_reporter;

import common.utils.TimeUtility;
import cookerMojoTrigger.MojoLogger;
import cookercucumber_reporter.json_pojos.FeaturePOJO;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class FTLReporter {

    private static String COOKER_PROJECT_NAME = "Cooker Cucumber Report Maven Plugin";
    private static String COOKER_PROJECT_VERSION = "3.0.0";
    private static String COOKER_PROJECT_AUTHOR = "Manjunath Prabhakar";

    Map<String, Object> params = new HashMap<>();

    public FTLReporter(Map<String, Object> params) {
        this.params = params;

        String userName = null;
        String hostName = null;
        String userLetter = null;

        //USER NAME
        try {
            if (System.getProperty("user.name").equalsIgnoreCase("")
                    | System.getProperty("user.name").isEmpty()
                    | System.getProperty("user.name") == null) {
                userName = "null";
                userLetter = (params.get("startPage").toString().charAt(0) + "").toUpperCase();
            } else {
                userName = System.getProperty("user.name");
                userLetter = (userName.charAt(0) + "").toUpperCase();
            }
        } catch (Exception e) {
            userName = "null";
            userLetter = "C".toUpperCase();
        }
        //userName = (System.getProperty("user.name")).replaceAll("\\$","\\\\\\$");

        //HOST NAME
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostName = "null";
        }

        //START PAGE
        int startPageIndex = 0;
        try {
            startPageIndex = Pages.valueOf(params.get("startPage").toString().toUpperCase()).getPageIndex();
        } catch (Exception e) {
            startPageIndex = 0;
        }

        params.put("triggeredUserName", userName);
        params.put("userLetter", userLetter);
        params.put("startPage", startPageIndex);
        params.put("triggeredHostName", hostName);

    }

    public void generateFTLReport() throws Exception {
        //CODE GOES DOWN BELOW
        List<FeaturePOJO> jsons = ReportHandler.getJSONsToList(params.get("jsonPath").toString());
        List<FeaturePOJO> featurePOJOS = ReportHandler.combineMultipleScenariosOfSameFeature(jsons);

        //Prepare Data
        Map<String, Object> input = new HashMap<String, Object>();
        input.putAll(params);

        Map<String, Object> featureData = ReportHandler.getFeatureDatas(featurePOJOS);
        input.putAll(featureData);

        Map<String, Object> scenarioData = ReportHandler.getScenariosData(featurePOJOS);
        input.putAll(scenarioData);

        input.put("totalExecutionTime", ReportHandler.getDurationStringFormat((Duration) input.get("totalDuration")));
        input.put("featurepojos", featurePOJOS);

        input.put("cookerReportTitle", COOKER_PROJECT_NAME);

        reportData(input);
        generateReport(input);

        this.params.clear();
        this.params.putAll(input);
    }

    private void generateReport(Map<String, Object> data) {
        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(FTLReporter.class, "/ftls");
        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        File htmlTargetDir = new File(data.get("htmlPath").toString());
        boolean mkdirs = htmlTargetDir.mkdirs();

        try (PrintWriter printWriter = new PrintWriter(new File(data.get("htmlPath").toString() + "\\cooker_cucumber_report_" + TimeUtility.getCurrTimeStampUnderscore() + ".html"))) {
            cfg.getTemplate("index.ftl").process(data, printWriter);
        } catch (Exception e) {
            MojoLogger.getLogger().error("Couldnt Generate Cooker Cucumber report!");
            e.printStackTrace();
        }

        MojoLogger.getLogger().info("Cooker report generated : " + data.get("htmlPath").toString() + "\\cooker_cucumber_report_"
                + TimeUtility.getCurrTimeStampUnderscore() + ".html");

    }

    private void reportData(Map<String, Object> data) {
        Log logger = MojoLogger.getLogger();
        logger.info("----------------------------------------");
        logger.info("cooker cucumber report parameters");
        logger.info("----------------------------------------");
        logger.info("Project Name             : " + data.get("projectName").toString());
        logger.info("Show Report on Console   : " + data.get("showConsoleLogReport").toString());
        logger.info("Source JSONs Path        : " + data.get("jsonPath").toString());
        logger.info("Target HTML Path         : " + data.get("htmlPath").toString());
        logger.info("Start Page               : " + Arrays.stream(Pages.values()).filter(s -> s.getPageIndex() == (int) data.get("startPage")).collect(Collectors.toList()));
        logger.info("Include Screenshots      : " + data.get("includeScreenshots").toString());
        logger.info("Include Fail Screenshots : " + data.get("includeOnlyScreenshotsOfFailStep").toString());
        logger.info("----------------------------------------");

    }

    public Map<String, Object> getParams() {
        return this.params;
    }

}
