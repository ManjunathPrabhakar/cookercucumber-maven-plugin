package cookercucumber_parser.featureParserFactory;

import gherkin.ast.Background;
import gherkin.ast.Location;
import gherkin.ast.Step;

import java.util.List;

public class BackgroundUtils implements BackgroundI {
    /**
     * BACKGROUND CANNOT HAVE TAGS & EXAMPLES
     */

    private Background background;
    private StringBuilder bgResult = new StringBuilder();

    /**
     * Constructor used to intilize the Background Object
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param pBackground Background Object
     */
    public BackgroundUtils(Background pBackground) {
        this.background = pBackground;
    }


    /**
     * Read the Background Object and Parse it and get it's Content in as String
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Background Object
     */
    public String getBackgroundData() {


        try {
            /* BACKGROUND INFO */
            String bKeyword = this.background.getKeyword(); // Background
            String bName = this.background.getName(); //Background Name
            String bDesc = this.background.getDescription(); //Background Desciption
            Location bLocation = this.background.getLocation(); //Background Location(Line & Col Numbers)
            int nLineNum = bLocation.getLine();
            int nColNum = bLocation.getColumn();
            List<Step> bSteps = this.background.getSteps(); //Background Steps


            this.bgResult.append(bKeyword).append(": ").append(bName); // Append Background: Background Name
            this.bgResult.append(System.getProperty("line.separator")); // Append New Line
            this.bgResult.append(bDesc == null ? "" : bDesc); //Append Background Description (If Not Null)
            this.bgResult.append(System.getProperty("line.separator")); //Append New Line


            /*
             * Loop through each step and get it in a string
             */
            for (final Step step : bSteps) {
                StepsUtils su = new StepsUtils(step); //Pass the Background Steps to Parse
                String val = su.getStepsData(); //Get the Steps Data to String
                this.bgResult.append(val); // Append Steps Data
            }

            this.bgResult.append(System.getProperty("line.separator")); //Append New Line
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* RETURN THE BACKGROUND DATA AS STRING */
        return String.valueOf(this.bgResult);
    }


}
