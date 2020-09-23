package rough.ManjuRough;

import CookerCucumberMavenPlugin.FileFactory.FileUtils;
import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.ast.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FeatureUtilsold {

    FileUtils fileUtils = new FileUtils();
    String NeededTag = "@googleTest1";
    Background[] backgroundz = new Background[1];
    List<Scenario> scenariozList = new ArrayList<Scenario>();
    List<ScenarioOutline> scenarioOutlinezList = new ArrayList<ScenarioOutline>();

    public void fParseFeature(File featurefile) throws IOException {

        String val = fileUtils.readAndGetFileContent(featurefile.getPath());
        System.out.println("File : " + featurefile.getName());
        pParse(val);

    }


    public void pParse(String featurefileContent) {
        System.out.println("--------------------------------------------------------");

        boolean bFLAG = false;

        Parser<GherkinDocument> gherkinDocumentParser = new Parser(new AstBuilder());
        GherkinDocument gherkinDocument;

        gherkinDocument = gherkinDocumentParser.parse(featurefileContent);
        Feature feature = gherkinDocument.getFeature();
        if (feature == null) {
            System.out.println("empty");
            /**
             * THROW ERROR AS ITS EMPTY FILE
             */
        }

        List<Tag> lfeatureLevelTags = feature.getTags();
        for (int i = 0; i < lfeatureLevelTags.size(); i++) {
            System.out.println("featuretags = " + lfeatureLevelTags.get(i).getName());
//            if (lfeatureLevelTags.get(i).getName().equals(NeededTag)) {
//                return;
//            }
        }
        String sFeatureKeyword = feature.getKeyword();
        System.out.println("sFeatureKeyword = " + sFeatureKeyword);
        String sFeatureName = feature.getName();
        System.out.println("sFeatureName = " + sFeatureName);
        String sfeatureLanguage = feature.getLanguage();
        System.out.println("sfeatureLanguage = " + sfeatureLanguage);
        String sfeatureDescription = feature.getDescription();
        System.out.println("sfeatureDescription = " + sfeatureDescription);


        List<ScenarioDefinition> featurescenarios = feature.getChildren();
        for (ScenarioDefinition sd : featurescenarios) {
            if (sd instanceof Background) {
                backgroundz[0] = (Background) sd;
            }
            if (sd instanceof Scenario) {
                scenariozList.add((Scenario) sd);
            }
            if (sd instanceof ScenarioOutline) {
                scenarioOutlinezList.add((ScenarioOutline) sd);
            }
        }

        System.out.println("backgroundz = " + backgroundz.length);
        System.out.println("scenariozList = " + scenariozList.size());
        System.out.println("scenarioOutinezList = " + scenarioOutlinezList.size());

        for (ScenarioDefinition sd : featurescenarios) {
            if (sd instanceof Background) {
                getBackground(sd);
            }
            if (sd instanceof Scenario) {
                getScenario(sd);
            }
            if (sd instanceof ScenarioOutline) {
                getScenarioOutline(sd);
            }
        }


        System.out.println("--------------------------------------------------------");
        //  return bFLAG;
    }

    public void getScenario(ScenarioDefinition featurescenario) {
        System.out.println("---------------SCENARIO-------------------");
        // Save background steps in order to add them to every scenario inside the same feature
        Scenario scenario = (Scenario) featurescenario;
        System.out.println("Keyword = " + scenario.getKeyword());
        System.out.println("Name = " + scenario.getName());
        System.out.println("Description = " + scenario.getDescription());

        List<Tag> stag = scenario.getTags();
        for (int i = 0; i < stag.size(); i++) {
            System.out.println("scenarioTags = " + stag.get(i).getName());
//            if (stag.get(i).getName().equals(NeededTag)) {
//                System.out.println("FUll Scenario");
//                return;
//            }
        }

        List<Step> step = scenario.getSteps();

        for (Step ss : step) {
            System.out.println("Step Keyword : " + ss.getKeyword());
            System.out.println("Steps Text : " + ss.getText());
            Node argument = ss.getArgument();
            if (argument instanceof DataTable) {
                List<TableRow> z = ((DataTable) argument).getRows();
                for (TableRow row : z) {
                    List<TableCell> cells = row.getCells();
                    List<String> rowValues = new ArrayList<String>();
                    for (TableCell cell : cells) {
                        rowValues.add(cell.getValue());
                    }
                    System.out.println("rowValues = " + rowValues);

                }
            } else if (argument instanceof DocString) {
                System.out.println("((DocString) argument).getContent() = " + ((DocString) argument).getContent());
            }
        }

        System.out.println("------------END OF SCENARIO-------------------");
    }

    public void getScenarioOutline(ScenarioDefinition featurescenario) {
        System.out.println("---------SCENARIO OUTLINE-------------");
        ScenarioOutline scenarioOutline = (ScenarioOutline) featurescenario;
        System.out.println("Keyword = " + scenarioOutline.getKeyword());
        System.out.println("Name = " + scenarioOutline.getName());
        System.out.println("Description = " + scenarioOutline.getDescription());

        List<Tag> stag = scenarioOutline.getTags();
        for (int i = 0; i < stag.size(); i++) {
            System.out.println("scenarioOutlingTags = " + stag.get(i).getName());
        }

        List<Step> step = scenarioOutline.getSteps();

        for (Step ss : step) {
            System.out.println("Step Keyword : " + ss.getKeyword());
            System.out.println("Steps Text : " + ss.getText());
            Node argument = ss.getArgument();
            if (argument instanceof DataTable) {
                List<TableRow> z = ((DataTable) argument).getRows();
                for (TableRow row : z) {
                    List<TableCell> cells = row.getCells();
                    List<String> rowValues = new ArrayList<String>();
                    for (TableCell cell : cells) {
                        rowValues.add(cell.getValue());
                    }
                    System.out.println("rowValues = " + rowValues);

                }
            } else if (argument instanceof DocString) {
                System.out.println("((DocString) argument).getContent() = " + ((DocString) argument).getContent());
            }
        }

        List<Examples> ex = scenarioOutline.getExamples();
        for (Examples e : ex) {
            Map<String, List<String>> exampleMap = new LinkedHashMap<String, List<String>>();

            List<TableCell> headerCells = e.getTableHeader().getCells();
            for (TableCell headerCell : headerCells) {
                exampleMap.put("<" + headerCell.getValue() + ">", new ArrayList<String>());
            }
            Object[] columnKeys = exampleMap.keySet().toArray();

            List<TableRow> tableBody = e.getTableBody();
            for (TableRow tableRow : tableBody) {
                List<TableCell> cells = tableRow.getCells();
                for (int i = 0; i < cells.size(); i++) {
                    String columnKey = (String) columnKeys[i];
                    List<String> values = exampleMap.get(columnKey);
                    values.add(cells.get(i).getValue());
                }
            }

            System.out.println(exampleMap);
        }


        System.out.println("--------END OF SCENARIO OUTLINE-------------");
    }

    public void getBackground(ScenarioDefinition sd) {
        /**
         * BACKGROUND CANNOT HAVE TAGS & EXAMPLES
         */
        System.out.println("-----------BACKGROUND-----------");
        Background background = (Background) sd;
        System.out.println("Keyword : " + background.getKeyword());
        System.out.println("Text : " + background.getName());
        System.out.println("Description : " + background.getDescription());
        System.out.println("---------------STEPS---------------");
        List<Step> ls = background.getSteps();
        for (Step step : ls) {
            System.out.println("Step Keyword : " + step.getKeyword());
            System.out.println("Steps Text : " + step.getText());
            Node argument = step.getArgument();
            if (argument instanceof DataTable) {
                List<TableRow> listrows = ((DataTable) argument).getRows();
                for (TableRow row : listrows) {
                    List<TableCell> cells = row.getCells();
                    List<String> rowValues = new ArrayList<String>();
                    for (TableCell cell : cells) {
                        rowValues.add(cell.getValue());
                    }
                    System.out.println("rowValues = " + rowValues);

                }
            } else if (argument instanceof DocString) {
                System.out.println("((DocString) argument).getContent() = " + ((DocString) argument).getContent());
            }

        }
        System.out.println("-----------END OF STEPS---------------");
        System.out.println("-------------END OF BACKGROUND---------------");
    }

    public void getTags() {

    }


}
