package CookerCucumberMavenPlugin.FeatureFactory;

import CookerCucumberMavenPlugin.FileFactory.ExcelReader;
import gherkin.ast.Examples;
import gherkin.ast.ScenarioOutline;
import gherkin.ast.Step;
import gherkin.ast.Tag;

import java.util.ArrayList;
import java.util.List;

public class ScenarioOutlineUtils implements ScenarioOutlineI {

    private ScenarioOutline scenarioOutline = null;
    private StringBuilder result = new StringBuilder();
    private String sSoKeyword;
    private String sSoName;
    private String sSoDescription;
    private List<Tag> sSoTags;
    private List<Step> sSoStep;

    public String getsSoKeyword() {
        return sSoKeyword;
    }

    public String getsSoName() {
        return sSoName;
    }

    public String getsSoDescription() {
        return sSoDescription;
    }

    List<Examples> sSoExamples;

    public ScenarioOutlineUtils(ScenarioOutline pScenarioOutline) {
        this.scenarioOutline = pScenarioOutline;
        sSoKeyword = this.scenarioOutline.getKeyword();
        sSoName = this.scenarioOutline.getName();
        sSoDescription = this.scenarioOutline.getDescription();
        sSoTags = this.scenarioOutline.getTags();
        sSoStep = scenarioOutline.getSteps();
        sSoExamples = scenarioOutline.getExamples();
    }

    public String getScenarioOutlineData() {

        try {
            for (Tag tag : sSoTags) {
                TagUtils tu = new TagUtils(tag);
                String soTagsData = tu.getTagsData();
                this.result.append(soTagsData);
            }

            this.result.append(scenarioOutline.getKeyword()).append(": ").append(scenarioOutline.getName());
            this.result.append(System.getProperty("line.separator"));
            this.result.append(scenarioOutline.getDescription() == null ? "" : scenarioOutline.getDescription());
            this.result.append(System.getProperty("line.separator"));


            for (Step step : sSoStep) {
                StepsUtils stepsUtils = new StepsUtils(step);
                String soSteps = stepsUtils.getStepsData();
                this.result.append(soSteps);

            }

            List<String> path = new ArrayList<>();
            ;
            boolean res = false;
            for (Tag t : sSoTags) {
                if (t.getName().contains("@excel")) {
                    path.add(t.getName().split("=")[1]); //Path
                    path.add(t.getName().split("=")[2]); //filename
                    path.add(t.getName().split("=")[3]); //SheetName
                    res = true;
                    break;
                }
            }

            if (res) {
                this.result.append("Examples:");
                this.result.append(System.getProperty("line.separator"));

                ExcelReader objExcelFile = new ExcelReader();

                //Prepare the path of excel file
                String filePath = null;
                if (path.get(0).equalsIgnoreCase("root")) {
                    filePath = System.getProperty("user.dir");
                } else {
                    filePath = path.get(0);
                }


                //Call read file method of the class to read data

                String z = objExcelFile.readExcel(filePath, path.get(1), path.get(2));
                this.result.append(z);
            } else {
                for (Examples examples : sSoExamples) {
                    ExamplesUtils examplesUtils = new ExamplesUtils(examples);
                    String soExampleData = examplesUtils.getExamplesData();
                    this.result.append(soExampleData);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return String.valueOf(this.result);
    }

//    public String getScenarioOutlineTags() {
//        StringBuilder ScenarioOutlineTags = new StringBuilder();
//
//        for (Tag tag : sSoTags) {
//            TagUtils tagUtils = new TagUtils(tag);
//            ScenarioOutlineTags.append(tagUtils.getTags());
//        }
//        return String.valueOf(ScenarioOutlineTags);
//    }

    public List<String> getScenarioOutlineTagsList() {
        List<String> res = new ArrayList<String>();

        try {
            for (Tag tag : sSoTags) {
                TagUtils tagUtils = new TagUtils(tag);
                res.add(tagUtils.getTagsData().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }


}
