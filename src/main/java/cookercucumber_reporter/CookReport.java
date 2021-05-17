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
    String startpage = "";
    String projectName = "";
    boolean turnOffsplash;

    public CookReport(String jsonPath, String htmlPath, String startPage, String projectName, boolean turnOffSplash) {
        this.jsonPath = jsonPath;
        this.htmlpath = htmlPath;
        this.startpage = startPage;
        this.projectName = projectName;
        this.turnOffsplash = turnOffSplash;
    }

    public void showLogReport() throws Exception {
        try {
            List<String> res = new ConsoleLogReporter().generateReport(this.jsonPath);
            for (String s : res
            ) {
                MojoLogger.getLogger().info(s);
            }
        } catch (Exception e) {
            System.out.println("Error in Cooker Cucumber Console Reporter");
        }
    }

    public void generateHTMLReport() throws Exception {
        try {
            HTMLReporter htmlReporter = new HTMLReporter(jsonPath, htmlpath, "", projectName);
            htmlReporter.genHTML();
        } catch (Exception e) {
            System.out.println("Error in Cooker Cucumber Old HTMl Reporter");
        }
    }

    public void generateFTLReport() throws Exception{
        try {
            FTLReporter ftl = new FTLReporter(this.jsonPath, this.htmlpath, this.startpage, this.projectName, this.turnOffsplash);
            ftl.generateFTLReport();
        } catch (Exception e) {
            System.out.println("Error in Cooker Cucumber HTML Reporter");
        }
    }
}
