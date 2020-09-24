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

    @Parameter(property = "jsonPath", required = true)
    private String jsonPath;

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
            if(jsonPath.equalsIgnoreCase("none")){
                jsonPath = System.getProperty("user.dir") + "\\target\\cucumber-reports";
            }

            LOGGER.info("============= COOKER CUCUMBER REPORT MAVEN PLUGIN SUMMARY ===================");
            MojoLogger.setLogger(LOGGER);
            CookReport cookReport = new CookReport();
            String res = cookReport.showReport(jsonPath).toUpperCase();
            LOGGER.info("============ COOKER CUCUMBER REPORT MAVEN PLUGIN More " + res + " ============");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }


}