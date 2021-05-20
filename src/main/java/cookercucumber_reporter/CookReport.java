package cookercucumber_reporter;

import cookerMojoTrigger.MojoLogger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 23/09/2020
 * @project cooker-maven-plugin
 */
public class CookReport {
    Map<String, Object> params = new HashMap<>();

    public CookReport(Map<String, Object> params) {
        this.params = params;
    }

    public void showLogReport() throws Exception {
        new ConsoleLogReporter().generateConsoleLog(params);
    }

    public void generateFTLReport() throws Exception {
        try {
            FTLReporter ftl = new FTLReporter(params);
            ftl.generateFTLReport();
        } catch (Exception e) {
            MojoLogger.getLogger().error("Error in Cooker Cucumber HTML Reporter");
            e.printStackTrace();
        }
    }
}
