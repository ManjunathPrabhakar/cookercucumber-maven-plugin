package cookercucumber_reporter;

import cookerMojoTrigger.MojoLogger;

import java.util.List;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 23/09/2020
 * @project cooker-maven-plugin
 */
public class CookReport {

    public String showReport(String jsonPath) throws Exception {
        List<String> res = Trigger.start(jsonPath);
        for (String s: res
             ) {
            MojoLogger.getLogger().info(s);
        }
        return "Coming soon!!";
    }
}
