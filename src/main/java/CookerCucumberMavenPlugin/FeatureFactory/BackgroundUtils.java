package CookerCucumberMavenPlugin.FeatureFactory;

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

    public BackgroundUtils(Background pBackground) {
        this.background = pBackground;
    }


    public String getBackgroundData() {


        try {
            /* BACKGROUND INFO */
            String bKeyword = this.background.getKeyword();
            String bName = this.background.getName();
            String bDesc = this.background.getDescription();
            Location bLocation = this.background.getLocation();
            int nLineNum = bLocation.getLine();
            int nColNum = bLocation.getColumn();
            List<Step> bSteps = this.background.getSteps();


            this.bgResult.append(bKeyword).append(": ").append(bName);
            this.bgResult.append(System.getProperty("line.separator"));
            this.bgResult.append(bDesc == null ? "" : bDesc);
            this.bgResult.append(System.getProperty("line.separator"));


            for (final Step step : bSteps) {
                StepsUtils su = new StepsUtils(step);
                String val = su.getStepsData();
                this.bgResult.append(val);
            }

            this.bgResult.append(System.getProperty("line.separator"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(this.bgResult);
    }


}
