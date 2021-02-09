package cookercucumber_reporter;

import cookerMojoTrigger.MojoLogger;

import java.util.List;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 23/09/2020
 * @project cooker-maven-plugin
 */
public class CookReport {
    String jsonPath = "";
    String htmlpath = "";
    String logPath = "";
    String projectName = "";

    public CookReport(String jsonPath, String htmlPath, String logPath, String projectName) {
        this.jsonPath = jsonPath;
        this.htmlpath = htmlPath;
        this.logPath = logPath;
        this.projectName = projectName;
    }

    public void showLogReport() throws Exception {
        List<String> res = new ConsoleLogReporter().generateReport(this.jsonPath);
        for (String s : res
        ) {
            MojoLogger.getLogger().info(s);
        }
    }

    public void generateHTMLReport() throws Exception {
        HTMLReporter htmlReporter = new HTMLReporter(jsonPath, htmlpath, logPath, projectName);
        htmlReporter.genHTML();
    }
}
