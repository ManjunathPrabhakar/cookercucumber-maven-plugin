package cookerMojoTrigger;

import cookercucumber_reporter.CookReport;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.HashMap;
import java.util.Map;


@Mojo(name = "cook-report", threadSafe = true, defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class CookerReportMOJO extends AbstractMojo {

    private Log LOGGER = getLog();

    @Parameter(property = "jsonPath", required = true, defaultValue = "none")
    private String jsonPath;

    @Parameter(property = "htmlGeneratePath", required = false, defaultValue = "none")
    private String htmlPath;

    @Parameter(property = "projectName", required = false, defaultValue = "Cooker Cucumber Automation Report")
    private String projectName;

    @Parameter(property = "startPage", required = false, defaultValue = "none")
    private String startPage;

    @Parameter(property = "includeScreenshots", required = false, defaultValue = "none")
    private String includeScreenshots;

    @Parameter(property = "includeOnlyScreenshotsOfFailStep", required = false, defaultValue = "none")
    private String includeOnlyScreenshotsOfFailStep;

    @Parameter(property = "showConsoleLogReport", required = false, defaultValue = "true")
    private String showConsoleLogReport;


    /**
     * This Method is First Executed during POST_INTEGRATION_TEST (cook-report) LifeCycle of Maven, Its Thread Safe
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @throws MojoExecutionException If Any
     * @throws MojoFailureException   If Any
     */
    public void execute() throws MojoExecutionException, MojoFailureException {
        // The logic of our plugin will go here
        boolean bincludeScreenshots = false, bincludeOnlyScreenshotsOfFailStep = false, bshowConsoleLogReport = false;
        int startIndex = 0;
        try {
            if (jsonPath.equalsIgnoreCase("none")) {
                jsonPath = System.getProperty("user.dir") + "\\target\\cucumber-reports";
            }
            if (htmlPath.equalsIgnoreCase("none")) {
                htmlPath = System.getProperty("user.dir") + "\\target\\cooker-html-report";
            }
            if (startPage.equalsIgnoreCase("none")) {
                startPage = "dashboard";
            }
            if (includeScreenshots.equalsIgnoreCase("none") || includeScreenshots.equalsIgnoreCase("false")) {
                bincludeScreenshots = false;
            } else {
                bincludeScreenshots = true;
            }
            if (includeOnlyScreenshotsOfFailStep.equalsIgnoreCase("none") || includeOnlyScreenshotsOfFailStep.equalsIgnoreCase("false")) {
                bincludeOnlyScreenshotsOfFailStep = false;
            } else {
                bincludeOnlyScreenshotsOfFailStep = true;
            }
            if (showConsoleLogReport.equalsIgnoreCase("true")) {
                bshowConsoleLogReport = true;
            } else {
                bshowConsoleLogReport = false;
            }

            Map<String, Object> params = new HashMap<>();
            //Strings
            params.put("jsonPath", jsonPath);
            params.put("htmlPath", htmlPath);
            params.put("startPage", startPage);
            params.put("projectName", projectName);
            //Boolean
            params.put("includeScreenshots", bincludeScreenshots);
            params.put("includeOnlyScreenshotsOfFailStep", bincludeOnlyScreenshotsOfFailStep);
            params.put("showConsoleLogReport",bshowConsoleLogReport);

            LOGGER.info("============== COOKER CUCUMBER REPORT MAVEN PLUGIN STARTED =====================");
            LOGGER.info("========================== By Manjunath Prabhakar ==============================");
            LOGGER.info("======================= ++++ generating started ++++ ===========================");
            MojoLogger.setLogger(LOGGER);
            CookReport cookReport = new CookReport(params);
            cookReport.generateFTLReport();
            if (bshowConsoleLogReport) {
                cookReport.showLogReport();
            }
            LOGGER.info("===================== ++++ generating completed ++++ ===========================");
        } catch (Exception e) {
            LOGGER.error("============== ++++ oh no! report generation aborted ++++ ======================");
            e.printStackTrace();
            LOGGER.error("================================================================================");
        } finally {
            LOGGER.info("============== COOKER CUCUMBER REPORT MAVEN PLUGIN ENDED =======================");
        }
    }


}