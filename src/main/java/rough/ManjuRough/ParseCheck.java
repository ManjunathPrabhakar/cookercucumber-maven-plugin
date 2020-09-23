package rough.ManjuRough;

import CookerCucumberMavenPlugin.FeatureFactory.FeatureUtils;
import CookerCucumberMavenPlugin.FileFactory.ExcelReader;
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

public class ParseCheck {
    FileUtils fileUtils = new FileUtils();
    String NeededTag = "@googleTest1";
    Background[] backgroundz = new Background[1];
    List<Scenario> scenariozList = new ArrayList<Scenario>();
    List<ScenarioOutline> scenarioOutlinezList = new ArrayList<ScenarioOutline>();

    public static void main(String[] args) throws Exception {
        String sHome = System.getProperty("user.dir");
        String sFeaturesHome = "\\src\\main\\test\\resources\\Features";

        FileUtils featurecontent = new FileUtils(sHome + sFeaturesHome);
        System.out.println(sHome + sFeaturesHome);
        List<File> featurefiles = featurecontent.getFiles(".feature");

        if (featurefiles.size() > 0) {

            for (File feature : featurefiles) {

                new ParseCheck().fParseFeature(feature);

                String val = new FileUtils().readAndGetFileContent(feature.getPath());
                Parser<GherkinDocument> gherkinDocumentParser = new Parser(new AstBuilder());
                GherkinDocument gherkinDocument = gherkinDocumentParser.parse(val);
                Feature featurefile = gherkinDocument.getFeature();
                FeatureUtils featureUtils = new FeatureUtils(featurefile);
                String s = featureUtils.getFeatureTags();
                if (s.contains("@googlefeature")) {
                    System.out.println(featureUtils.getsFeatureName() + " : Full Feature");
                }


            }
        }
    }

    public void fParseFeature(File featurefile) throws IOException {

        String val = fileUtils.readAndGetFileContent(featurefile.getPath());
        System.out.println("File : " + featurefile.getName());
        //pParse(val);
        System.out.println("val = " + val);
        pParser(val);


    }

    public void pParser(String featurefileContent) throws IOException {
        List<Background> backgroundz = new ArrayList<Background>();
        List<Scenario> scenariozList = new ArrayList<Scenario>();
        List<ScenarioOutline> scenarioOutlinezList = new ArrayList<ScenarioOutline>();
        Parser<GherkinDocument> gherkinDocumentParser = new Parser(new AstBuilder());
        GherkinDocument gherkinDocument = gherkinDocumentParser.parse(featurefileContent);
        Feature feature = gherkinDocument.getFeature();
        if (feature == null) {
            System.out.println("empty");
            return;
            /**
             * THROW ERROR AS ITS EMPTY FILE
             */
        }
        List<ScenarioDefinition> featurescenarios = feature.getChildren();
        for (ScenarioDefinition sd : featurescenarios) {
            if (sd instanceof Background) {
                backgroundz.add((Background) sd);
            }
            if (sd instanceof Scenario) {
                scenariozList.add((Scenario) sd);
            }
            if (sd instanceof ScenarioOutline) {
                scenarioOutlinezList.add((ScenarioOutline) sd);
                System.out.println(getScenarioOutlineM((ScenarioOutline) sd));
            }
        }


        for (Scenario s : scenariozList) {
            for (Tag tag : s.getTags()) {
                if (tag.getName().contains(NeededTag)) {


                    if (backgroundz.size() > 0) {
                        //scenario,feature,background
                        this.genFile(feature, s, null, backgroundz.get(0));

                        //System.out.println(backgroundz.get(0).getName() + " BG Triggered");
                    } else {
                        //scenario,feature,null
                        this.genFile(feature, s, null, null);
                    }

                    // System.out.println(s.getName() + " S Triggered!");
                }
            }
        }
        for (ScenarioOutline s : scenarioOutlinezList) {
            for (Tag tag : s.getTags()) {
                if (tag.getName().contains(NeededTag)) {
                    if (backgroundz.size() > 0) {
                        //scenario,feature,background
                        this.genFile(feature, null, s, backgroundz.get(0));
                        //System.out.println(backgroundz.get(0).getName() + " BG Triggered");
                    } else {
                        //scenario,feature,null
                        this.genFile(feature, null, s, null);
                    }

                }
            }
        }
    }

    public void genFile(Feature f, Scenario s, ScenarioOutline so, Background b) throws IOException {
        StringBuilder sb = new StringBuilder();
        String filename = "";
        List<Tag> lf = f.getTags();
        for (Tag t : lf) {
            sb.append(t.getName());
            sb.append(System.getProperty("line.separator"));
        }
        sb.append(f.getKeyword()).append(": ").append(f.getName());
        sb.append(System.getProperty("line.separator"));
        sb.append(f.getDescription() == null ? "" : f.getDescription());
        sb.append(System.getProperty("line.separator"));

        if (b != null) {
            /**
             * Background is present
             */
            sb.append(getBackgroundMANJU(b));
        }

        if (s != null) {
            /**
             * Scenario is present
             */
            sb.append(getScenarioM(s));
        }
        if (so != null) {
            /**
             * Scenario Outline is present
             */
            sb.append(getScenarioOutlineM(so));
        }


    }

    public String getBackgroundMANJU(Background background) {
        StringBuilder sb = new StringBuilder();
        /**
         * BACKGROUND CANNOT HAVE TAGS & EXAMPLES
         */
        // System.out.println("-----------BACKGROUND-----------");
        // Background background = (Background) sd;
        //System.out.println("Keyword : " + background.getKeyword());
        // System.out.println("Text : " + background.getName());
        sb.append(background.getKeyword()).append(": ").append(background.getName());
        sb.append(System.getProperty("line.separator"));
        //System.out.println("Description : " + background.getDescription());
        sb.append(background.getDescription() == null ? "" : background.getDescription());
        sb.append(System.getProperty("line.separator"));
        // System.out.println("---------------STEPS---------------");
        List<Step> ls = background.getSteps();
        for (Step step : ls) {
            // System.out.println("Step Keyword : " + step.getKeyword());
            //  System.out.println("Steps Text : " + step.getText());
            sb.append(step.getKeyword() + " " + step.getText());
            sb.append(System.getProperty("line.separator"));
            Node argument = step.getArgument();
            if (argument instanceof DataTable) {
                List<TableRow> listrows = ((DataTable) argument).getRows();
                for (TableRow row : listrows) {
                    List<TableCell> cells = row.getCells();
                    List<String> rowValues = new ArrayList<String>();
                    sb.append("|");
                    for (TableCell cell : cells) {
                        rowValues.add(cell.getValue());
                        sb.append(cell.getValue() + "|");

                    }
                    sb.append(System.getProperty("line.separator"));
                    // System.out.println("rowValues = " + rowValues);

                }
            } else if (argument instanceof DocString) {
                //System.out.println("((DocString) argument).getContent() = " + ((DocString) argument).getContent());
                sb.append("\"\"\" \n" + ((DocString) argument).getContent() + "\n\"\"\"");
            }

        }
        //  System.out.println("-----------END OF STEPS---------------");
        //  System.out.println("-------------END OF BACKGROUND---------------");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

    public String getScenarioM(Scenario featurescenario) {
        StringBuilder sb = new StringBuilder();
        //  System.out.println("---------------SCENARIO-------------------");
        // Save background steps in order to add them to every scenario inside the same feature
        Scenario scenario = (Scenario) featurescenario;

        List<Tag> stag = scenario.getTags();
        for (Tag ts : stag) {
            sb.append(ts.getName());
            sb.append(System.getProperty("line.separator"));
        }

        // System.out.println("Keyword = " + scenario.getKeyword());
        // System.out.println("Name = " + scenario.getName());
        // System.out.println("Description = " + scenario.getDescription());
        sb.append(scenario.getKeyword() + ": " + scenario.getName());
        sb.append(System.getProperty("line.separator"));
        sb.append(scenario.getDescription() == null ? "" : scenario.getDescription());
        sb.append(System.getProperty("line.separator"));


        List<Step> step = scenario.getSteps();

        for (Step ss : step) {
            //   System.out.println("Step Keyword : " + ss.getKeyword());
            //   System.out.println("Steps Text : " + ss.getText());
            sb.append(ss.getKeyword()).append(" ").append(ss.getText());
            sb.append(System.getProperty("line.separator"));
            Node argument = ss.getArgument();
            if (argument instanceof DataTable) {
                List<TableRow> z = ((DataTable) argument).getRows();
                for (TableRow row : z) {
                    List<TableCell> cells = row.getCells();
                    List<String> rowValues = new ArrayList<String>();
                    sb.append("|");
                    for (TableCell cell : cells) {
                        rowValues.add(cell.getValue());
                        sb.append(cell.getValue() + "|");
                    }
                    sb.append(System.getProperty("line.separator"));
                    //   System.out.println("rowValues = " + rowValues);

                }
            } else if (argument instanceof DocString) {
                // System.out.println("((DocString) argument).getContent() = " + ((DocString) argument).getContent());
                sb.append("\"\"\" \n" + ((DocString) argument).getContent() + "\n\"\"\"");
                sb.append(System.getProperty("line.separator"));
            }
        }

        //   System.out.println("------------END OF SCENARIO-------------------");

        return sb.toString();
    }

    public String getScenarioOutlineM(ScenarioOutline featurescenario) throws IOException {
        StringBuilder sb = new StringBuilder();
        ScenarioOutline scenarioOutline = (ScenarioOutline) featurescenario;
//        System.out.println("Keyword = " + scenarioOutline.getKeyword());
//        System.out.println("Name = " + scenarioOutline.getName());
//        System.out.println("Description = " + scenarioOutline.getDescription());

        List<Tag> stag = scenarioOutline.getTags();
        for (Tag ts : stag) {
            sb.append(ts.getName());
            sb.append(System.getProperty("line.separator"));
        }

        sb.append(scenarioOutline.getKeyword() + ": " + scenarioOutline.getName());
        sb.append(System.getProperty("line.separator"));
        sb.append(scenarioOutline.getDescription() == null ? "" : scenarioOutline.getDescription());
        sb.append(System.getProperty("line.separator"));

        List<Step> step = scenarioOutline.getSteps();

        for (Step ss : step) {
//            System.out.println("Step Keyword : " + ss.getKeyword());
//            System.out.println("Steps Text : " + ss.getText());
            sb.append(ss.getKeyword() + " " + ss.getText());
            sb.append(System.getProperty("line.separator"));
            Node argument = ss.getArgument();
            if (argument instanceof DataTable) {
                List<TableRow> z = ((DataTable) argument).getRows();
                for (TableRow row : z) {
                    List<TableCell> cells = row.getCells();
                    List<String> rowValues = new ArrayList<String>();
                    sb.append("|");
                    for (TableCell cell : cells) {
                        rowValues.add(cell.getValue());
                        sb.append(cell.getValue() + "|");
                    }
                    sb.append(System.getProperty("line.separator"));
                    //   System.out.println("rowValues = " + rowValues);
                }
            } else if (argument instanceof DocString) {
                //System.out.println("((DocString) argument).getContent() = " + ((DocString) argument).getContent());
                sb.append("\"\"\" \n" + ((DocString) argument).getContent() + "\n\"\"\"");
                sb.append(System.getProperty("line.separator"));
            }
        }

        List<String> path = new ArrayList<>();
        ;
        boolean res = false;
        for (Tag t : stag) {
            if (t.getName().contains("@excel")) {
                path.add(t.getName().split("=")[1]); //Path
                path.add(t.getName().split("=")[2]); //filename
                path.add(t.getName().split("=")[3]); //SheetName
                res = true;
                break;
            }
        }

        if (res) {
            System.out.println("Found Excel Keyword");
            sb.append("Examples:");
            sb.append(System.getProperty("line.separator"));

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
            sb.append(z);


        } else {
            List<Examples> ex = scenarioOutline.getExamples();
            for (Examples e : ex) {
                sb.append("Examples:");
                sb.append(System.getProperty("line.separator"));
                Map<String, List<String>> exampleMap = new LinkedHashMap<String, List<String>>();

                List<TableCell> headerCells = e.getTableHeader().getCells();
                sb.append("|");
                for (TableCell headerCell : headerCells) {
                    exampleMap.put("<" + headerCell.getValue() + ">", new ArrayList<String>());
                    sb.append(headerCell.getValue() + "|");
                }
                Object[] columnKeys = exampleMap.keySet().toArray();
                sb.append(System.getProperty("line.separator"));

                List<TableRow> tableBody = e.getTableBody();
                for (TableRow tableRow : tableBody) {
                    List<TableCell> cells = tableRow.getCells();
                    sb.append("|");
                    for (int i = 0; i < cells.size(); i++) {
                        String columnKey = (String) columnKeys[i];
                        List<String> values = exampleMap.get(columnKey);
                        values.add(cells.get(i).getValue());
                        sb.append(cells.get(i).getValue() + "|");
                    }
                    sb.append(System.getProperty("line.separator"));
                }

                //sb.append(exampleMap);
                //System.out.println(exampleMap);
            }
        }


        return sb.toString();
    }

}
