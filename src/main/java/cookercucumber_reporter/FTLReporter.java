package cookercucumber_reporter;

import common.utils.TimeUtility;
import cookerMojoTrigger.MojoLogger;
import cookercucumber_reporter.json_pojos.FeaturePOJO;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FTLReporter {

    String JSONSPATH = null;
    String HTMLPATH = null;
    String startPage = null;
    String userName = null;
    String hostName = null;
    String userLetter = null;
    String projectName = null;
    int startPageIndex = 0;
    boolean turnOffSplash = false;
    String version = "2.0.33";

    public FTLReporter(String jsonPath, String htmlpath, String startPage, String projectName, boolean turnOffSplash) {
        this.JSONSPATH = jsonPath;
        this.HTMLPATH = htmlpath;
        this.startPage = startPage;
        this.projectName = projectName;
        this.turnOffSplash = turnOffSplash;
        try {
            if (System.getProperty("user.name").equalsIgnoreCase("")
                    | System.getProperty("user.name").isEmpty()
                    | System.getProperty("user.name") == null) {
                userName = "null";
                userLetter = (projectName.charAt(0) + "").toUpperCase();
            } else {
                userName = System.getProperty("user.name");
                userLetter = (userName.charAt(0) + "").toUpperCase();
            }
        } catch (Exception e) {
            userName = "null";
            userLetter = (projectName.charAt(0) + "").toUpperCase();
        }
        //userName = (System.getProperty("user.name")).replaceAll("\\$","\\\\\\$");
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostName = "null";
        }

        try {
            if (this.projectName.equalsIgnoreCase("")
                    | this.projectName.isEmpty()
                    | this.projectName == null) {
                this.projectName = "Cooker Cucumber Report";
            }
        } catch (Exception e) {
            this.projectName = "Cooker Cucumber Report";
        }

        try {
            startPageIndex = Pages.valueOf(this.startPage.toUpperCase()).getPageIndex();
        } catch (Exception e) {
            startPageIndex = 0;
        }

    }

    public String getDurationStringFormat(Duration duration) {

        long days = duration.toDays();
        duration = duration.minusDays(days);
        long hours = duration.toHours();
        duration = duration.minusHours(hours);
        long mins = duration.toMinutes();
        duration = duration.minusMinutes(mins);
        long secs = duration.getSeconds();
        duration = duration.minusSeconds(secs);
        long mils = duration.toMillis();

        System.out.println(mils);
        String res = ((days > 0 ? (days + "d") : "") + " " +
                (hours > 0 ? (String.format("%02d", hours) + "h") : "") + " " +
                (mins > 0 ? (String.format("%02d", mins) + "m") : "") + " " +
                (secs > 0 ? (String.format("%02d", secs) + "s") : "") + " " +
                (mils > 0 ? (String.format("%04d", mils).substring(0, 3) + "ms") : "")).trim();

        return res.isEmpty() ? "0ms" : res;
    }

    public void generateFTLReport() throws Exception {
        //CODE GOES DOWN BELOW

        List<FeaturePOJO> jsons = ReportHandler.getJSONsToList(this.JSONSPATH);
        List<FeaturePOJO> featurePOJOS = ReportHandler.combineMultipleScenariosOfSameFeature(jsons);

        //TEMPLATE CODE

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(FTLReporter.class, "/ftls");
        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


        // 2.1. Prepare the template input:

        long totalFeatures = featurePOJOS.size();
        long totalPassFeatures = featurePOJOS.stream().filter(s -> s.getStatus().equalsIgnoreCase("pass")).count();
        long totalFailFeatures = featurePOJOS.stream().filter(s -> s.getStatus().equalsIgnoreCase("fail")).count();
        long totalSkipFeatures = featurePOJOS.stream().filter(s -> s.getStatus().equalsIgnoreCase("skip")).count();
        long totalOtherFeatures = featurePOJOS.stream().filter(s -> s.getStatus().equalsIgnoreCase("other")).count();

        long totalscenarios = 0, scenariospasscount = 0, scenariosfailcount = 0, scenariosskipcount = 0, scenariosothercount = 0;
        for (FeaturePOJO featureList : featurePOJOS) {
            totalscenarios = totalscenarios +
                    featureList.getElements().stream().filter(e -> e.getType().equalsIgnoreCase("scenario")).count();
            scenariospasscount = scenariospasscount +
                    featureList.getElements().stream().filter(e -> e.getType().equalsIgnoreCase("scenario") & e.getStatus().equalsIgnoreCase("pass")).count();
            scenariosfailcount = scenariosfailcount +
                    featureList.getElements().stream().filter(e -> e.getType().equalsIgnoreCase("scenario") & e.getStatus().equalsIgnoreCase("fail")).count();
            scenariosskipcount = scenariosskipcount +
                    featureList.getElements().stream().filter(e -> e.getType().equalsIgnoreCase("scenario") & e.getStatus().equalsIgnoreCase("skip")).count();
            scenariosothercount = scenariosothercount +
                    featureList.getElements().stream().filter(e -> e.getType().equalsIgnoreCase("scenario") & e.getStatus().equalsIgnoreCase("other")).count();
        }

        Duration totalExectionDuration = Duration.ofSeconds(0);
        for (FeaturePOJO f : featurePOJOS) {
            Duration featureDur = f.getDuration();
            totalExectionDuration = totalExectionDuration.plus(featureDur);
        }

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("firstPage", this.startPageIndex);

        //INDEX.HTML
        input.put("cookerReportTitle", "Cooker Cucumber Report");
        //If user adds logo with base64 image then below line only
        input.put("pluginNameWithVersion", "Cooker Cucumber Maven Plugin " + version);
        input.put("pluginAuthorName", "Manjunath Prabhakar");
        input.put("needScreenshot", true);

        //SIDEBAR.HTML
        input.put("sidebarAlphabet", this.userLetter);

        //Overview.HTML
        input.put("projectName", this.projectName);
        input.put("totalFeatures", "" + totalFeatures);
        input.put("totalPassFeatures", "" + totalPassFeatures);
        input.put("totalFailFeatures", "" + totalFailFeatures);
        input.put("totalSkipFeatures", "" + totalSkipFeatures);
        input.put("totalOtherFeatures", "" + totalOtherFeatures);
        input.put("featurePassPercentage", (int) Math.round(((float) totalPassFeatures / totalFeatures) * 100));
        input.put("totalScenarios", "" + totalscenarios);
        input.put("totalPassScenarios", "" + scenariospasscount);
        input.put("totalFailScenarios", "" + scenariosfailcount);
        input.put("totalSkipScenarios", "" + scenariosskipcount);
        input.put("totalOtherScenarios", "" + scenariosothercount);
        input.put("scenariosPassPercentage", (int) Math.round(((float) scenariospasscount / totalscenarios) * 100));
        input.put("triggeredUserName", this.userName);
        input.put("triggeredHostName", this.hostName);
        input.put("totalExecutionTime", getDurationStringFormat(totalExectionDuration));


        //graph.ftl - NOTHING NOW

        //dashboard.ftl - NOTHING NOW

        //features.ftl
        input.put("featurepojos", featurePOJOS);

        input.put("turnOffSplash", this.turnOffSplash);


        //logs.ftl - NOTHING NOW

        //profilecontent.ftl - NOTHING NOW

        //popups.ftl


        // 2.2. Get the template


        // 2.3. Generate the output

        // Write output to the console
//        Writer consoleWriter = new OutputStreamWriter(System.out);
//        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:

        new File(HTMLPATH).mkdirs();

        try (PrintWriter printWriter = new PrintWriter(new File(HTMLPATH + "\\cooker_cucumber_report_" + TimeUtility.getCurrTimeStampUnderscore() + ".html"))) {
            cfg.getTemplate("index.ftl").process(input, printWriter);
        } catch (Exception e) {
            MojoLogger.getLogger().error("Couldnt Generate Cooker Cucumber report!");
            e.printStackTrace();
        }

        MojoLogger.getLogger().info("Cooker report generated : " + HTMLPATH + "\\cooker_cucumber_report_"
                + TimeUtility.getCurrTimeStampUnderscore() + ".html");
    }
}
