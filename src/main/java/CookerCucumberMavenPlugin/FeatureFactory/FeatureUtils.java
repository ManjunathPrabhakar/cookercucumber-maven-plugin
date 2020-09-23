package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.*;

import java.util.ArrayList;
import java.util.List;

public class FeatureUtils implements FeatureDocument {


    private Feature feature = null;
    private StringBuilder result = new StringBuilder();
    private String sFeatureKeyword;
    private String sFeatureName;
    private String sfeatureLanguage;
    private String sfeatureDescription;
    private List<Tag> sfeatureLevelTags;
    private List<ScenarioDefinition> sfeaturescenarios;


    public String getsFeatureKeyword() {
        return sFeatureKeyword;
    }

    public String getsFeatureName() {
        return sFeatureName;
    }

    public String getSfeatureLanguage() {
        return sfeatureLanguage;
    }

    public String getSfeatureDescription() {
        return sfeatureDescription;
    }

    public FeatureUtils(Feature pFeature) {
        this.feature = pFeature;
        sFeatureKeyword = this.feature.getKeyword();
        sFeatureName = this.feature.getName();
        sfeatureLanguage = this.feature.getLanguage();
        sfeatureDescription = this.feature.getDescription() == null ? "" : this.feature.getDescription();
        sfeatureLevelTags = this.feature.getTags();
        sfeaturescenarios = this.feature.getChildren();
    }

    /**
     * Read the Feature Object and Parse it and get it's Content in as String
     *  <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Feature Object
     */
    public String getFeatureData() {
        try {
            if (feature == null) {
                System.out.println("empty");
                /**
                 * THROW ERROR AS ITS EMPTY FILE
                 */
            }

            String fTagData = getFeatureTags();
            this.result.append(fTagData);
            this.result.append(System.getProperty("line.separator"));


            this.result.append(sFeatureKeyword).append(": ").append(sFeatureName);
            this.result.append(sfeatureDescription);
            this.result.append(System.getProperty("line.separator"));
            this.result.append("#Language : ").append(sfeatureLanguage);
            this.result.append(System.getProperty("line.separator"));


            for (ScenarioDefinition scenarioDefinition : sfeaturescenarios) {
                if (scenarioDefinition instanceof Background) {
                    Background background = (Background) scenarioDefinition;
                    BackgroundUtils backgroundUtils = new BackgroundUtils(background);
                    String fBackgroundData = backgroundUtils.getBackgroundData();
                    this.result.append(fBackgroundData);
                }
                if (scenarioDefinition instanceof Scenario) {
                    Scenario scenario = (Scenario) scenarioDefinition;
                    ScenarioUtils scenarioUtils = new ScenarioUtils(scenario);
                    String fScenarioData = scenarioUtils.getScenarioData();
                    this.result.append(fScenarioData);
                }
                if (scenarioDefinition instanceof ScenarioOutline) {
                    ScenarioOutline scenarioOutline = (ScenarioOutline) scenarioDefinition;
                    ScenarioOutlineUtils scenarioOutlineUtils = new ScenarioOutlineUtils(scenarioOutline);
                    String fScenarioOutlineData = scenarioOutlineUtils.getScenarioOutlineData();
                    this.result.append(fScenarioOutlineData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return String.valueOf(this.result);
    }


    public String getFeatureTags() {
        StringBuilder FeatureTags = new StringBuilder();

        try {
            for (Tag tag : sfeatureLevelTags) {
                TagUtils tagUtils = new TagUtils(tag);
                FeatureTags.append(tagUtils.getTagsData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(FeatureTags);
    }

    public List<String> getFeatureTagsList() {
        List<String> res = new ArrayList<String>();

        try {
            for (Tag tag : sfeatureLevelTags) {
                TagUtils tagUtils = new TagUtils(tag);
                res.add(tagUtils.getTagsData().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

}
