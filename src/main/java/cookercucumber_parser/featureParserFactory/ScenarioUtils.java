package cookercucumber_parser.featureParserFactory;

import gherkin.ast.Scenario;
import gherkin.ast.Step;
import gherkin.ast.Tag;

import java.util.ArrayList;
import java.util.List;

public class ScenarioUtils implements ScenarioI {

    String sSDescription;
    List<Tag> sSTags;
    List<Step> sSSteps;
    StringBuilder result = new StringBuilder();
    private Scenario scenario = null;
    private String sSKeyword;
    private String sSName;

    public ScenarioUtils(Scenario pScenario) {
        this.scenario = pScenario;
        sSKeyword = this.scenario.getKeyword();
        sSName = this.scenario.getName();
        sSDescription = this.scenario.getDescription();
        sSTags = this.scenario.getTags();
        sSSteps = this.scenario.getSteps();
    }

    public String getsSKeyword() {
        return sSKeyword;
    }

    public String getsSName() {
        return sSName;
    }

    public String getsSDescription() {
        return sSDescription;
    }

    /**
     * Read the Scenario Object and Parse it and get it's Content in as String
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of SCenario Object
     */
    public String getScenarioData() {


        try {
            for (Tag tag : sSTags) {
                TagUtils tu = new TagUtils(tag);
                String soTagsData = tu.getTagsData();
                this.result.append(soTagsData);
            }

            this.result.append(this.scenario.getKeyword() + ": " + this.scenario.getName());
            this.result.append(System.getProperty("line.separator"));
            this.result.append(this.scenario.getDescription() == null ? "" : this.scenario.getDescription());
            this.result.append(System.getProperty("line.separator"));


            for (Step step : sSSteps) {
                StepsUtils stepsUtils = new StepsUtils(step);
                String soSteps = stepsUtils.getStepsData();
                this.result.append(soSteps);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(this.result);
    }

//    public String getScenarioTags() {
//        StringBuilder ScenarioTags = new StringBuilder();
//
//        for (Tag tag : sSTags) {
//            TagUtils tagUtils = new TagUtils(tag);
//            ScenarioTags.append(tagUtils.getTags());
//        }
//        return String.valueOf(ScenarioTags);
//    }

    public List<String> getScenarioTagsList() {
        List<String> res = new ArrayList<String>();

        try {
            for (Tag tag : sSTags) {
                TagUtils tagUtils = new TagUtils(tag);
                res.add(tagUtils.getTagsData().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

}
