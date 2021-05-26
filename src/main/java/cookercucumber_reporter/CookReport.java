package cookercucumber_reporter;

import cookerMojoTrigger.MojoLogger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 23/09/2020
 * @project cooker-maven-plugin
 */
public class CookReport {
    Map<String, Object> params = new HashMap<>();
    Map<String, Object> Allparams = new HashMap<>();

    public CookReport(Map<String, Object> params) {
        this.params = params;
    }

    public void generateFTLReport() throws Exception {
        try {
            FTLReporter ftl = new FTLReporter(params);
            ftl.generateFTLReport();
            this.Allparams.putAll(ftl.getParams());
        } catch (Exception e) {
            MojoLogger.getLogger().error("Error in Cooker Cucumber HTML Reporter");
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            MojoLogger.getLogger().error(errors.toString());
            errors.flush();
            errors.close();

        }
    }

    public void showLogReport() throws Exception {
        new ConsoleLogReporter().generateConsoleLog(this.Allparams);
    }

}
