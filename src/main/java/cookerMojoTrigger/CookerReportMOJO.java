package cookerMojoTrigger;

import cookercucumber_reporter.CookReport;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;


@Mojo(name = "cook-report", threadSafe = true, defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class CookerReportMOJO extends AbstractMojo {

    private Log LOGGER = getLog();

    @Parameter(property = "jsonPath", required = true, defaultValue = "none")
    private String jsonPath;

    @Parameter(property = "htmlGeneratePath", required = false, defaultValue = "none")
    private String htmlPath;

    @Parameter(property = "logFilesPath", required = false, defaultValue = "none")
    private String logPath;

    @Parameter(property = "projectName", required = true, defaultValue = "")
    private String projectName;


    /**
     * This Method is First Executed during POST_INTEGRATION_TEST (cook-report) LifeCycle of Maven, Its Thread Safe
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @throws MojoExecutionException If Any
     * @throws MojoFailureException   If Any
     */
    public void execute() throws MojoExecutionException, MojoFailureException {
        // The logic of our plugin will go here
        try {
            if (jsonPath.equalsIgnoreCase("none")) {
                jsonPath = System.getProperty("user.dir") + "\\target\\cucumber-reports";
            }
            if (htmlPath.equalsIgnoreCase("none")) {
                htmlPath = System.getProperty("user.dir") + "\\target\\cooker-html-report";
            }
            if (logPath.equalsIgnoreCase("all")) {
                logPath = System.getProperty("user.dir") + "\\";
            }

            LOGGER.info("============== COOKER CUCUMBER REPORT MAVEN PLUGIN STARTED =====================");
            LOGGER.info("========================== By Manjunath Prabhakar ==============================");
            LOGGER.info("======================= ++++ generating started ++++ ===========================");
            MojoLogger.setLogger(LOGGER);
            CookReport cookReport = new CookReport(jsonPath, htmlPath, logPath,projectName);
            cookReport.showLogReport();
            cookReport.generateHTMLReport();
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