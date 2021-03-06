package cookercucumber_parser.featureParserFactory;

import cookerMojoTrigger.MojoLogger;
import cookercucumber_parser.flatFileParser.CSVParser;
import cookercucumber_parser.flatFileParser.ExcelParser;
import cookercucumber_parser.flatFileParser.PlainParser;
import gherkin.ast.Examples;
import gherkin.ast.ScenarioOutline;
import gherkin.ast.Step;
import gherkin.ast.Tag;

import java.util.ArrayList;
import java.util.List;

public class ScenarioOutlineUtils implements ScenarioOutlineI {

    List<Examples> sSoExamples;
    private ScenarioOutline scenarioOutline = null;
    private StringBuilder result = new StringBuilder();
    private String sSoKeyword;
    private String sSoName;
    private String sSoDescription;
    private List<Tag> sSoTags;
    private List<Step> sSoStep;

    public ScenarioOutlineUtils(ScenarioOutline pScenarioOutline) {
        this.scenarioOutline = pScenarioOutline;
        sSoKeyword = this.scenarioOutline.getKeyword();
        sSoName = this.scenarioOutline.getName();
        sSoDescription = this.scenarioOutline.getDescription();
        sSoTags = this.scenarioOutline.getTags();
        sSoStep = scenarioOutline.getSteps();
        sSoExamples = scenarioOutline.getExamples();
    }

    public String getsSoKeyword() {
        return sSoKeyword;
    }

    public String getsSoName() {
        return sSoName;
    }

    public String getsSoDescription() {
        return sSoDescription;
    }

    /**
     * Read the ScenarioOutline Object and Parse it and get it's Content in as String
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of ScenarioOutline Object
     */
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


            //Check if the Scenario Outline as @excel tag
            List<String> path = new ArrayList<>();
            boolean needExcel = false;
            boolean needCSV = false;
            boolean needPlain = false;
            boolean needExamples = true;
            for (Tag t : sSoTags) {
                //if it has @ excel then extract filepath, filename, sheetname & set res = true
                if (t.getName().contains("@excel")) {
                    try {
                        path.add(t.getName().split("=")[1]); //Path
                        path.add(t.getName().split("=")[2]); //filename
                        path.add(t.getName().split("=")[3]); //SheetName
                        needExcel = true;
                        needExamples = false;
                        break;
                    } catch (Exception e) {
                        //If error in extracting then log warning message and set res = false
                        MojoLogger.getLogger().error("Issue in prasing Excel for Scenario Outline " + sSoName +
                                "\nExcel Tag format must be @excel=folderpath=filename.fileextension=sheetname\n" +
                                "if folderpath is root then project path is taken");
                        needExcel = false;
                        needExamples = true;
                        break;
                    }
                }

                if (t.getName().contains("@csv")) {
                    //@csv=root=filename.csv=,
                    try {
                        path.add(t.getName().split("=")[1]); //Path
                        path.add(t.getName().split("=")[2]); //filename
                        path.add(t.getName().split("=")[3]); //Delimiter
                        needCSV = true;
                        needExamples = false;
                        break;
                    } catch (Exception e) {
                        //If error in extracting then log warning message and set res = false
                        MojoLogger.getLogger().error("Issue in prasing Excel for Scenario Outline " + sSoName +
                                "\nExcel Tag format must be @excel=folderpath=filename.fileextension=sheetname\n" +
                                "if folderpath is root then project path is taken");
                        needCSV = false;
                        needExamples = true;
                        break;
                    }
                }

                if (t.getName().contains("@plain")) {
                    //@plain=root=filename.txt
                    try {
                        path.add(t.getName().split("=")[1]); //Path
                        path.add(t.getName().split("=")[2]); //filename
                        needPlain = true;
                        needExamples = false;
                        break;
                    } catch (Exception e) {
                        //If error in extracting then log warning message and set res = false
                        MojoLogger.getLogger().error(e + "\nIssue in prasing Excel for Scenario Outline " + sSoName +
                                "\nExcel Tag format must be @excel=folderpath=filename.fileextension=sheetname\n" +
                                "if folderpath is root then project path is taken");
                        needPlain = false;
                        needExamples = true;
                        break;
                    }
                }
            }


            if (needExcel) {
                StringBuilder stringBuilder = new StringBuilder();
                try {

                    //Prepare the path of excel file
                    String filePath = null;
                    if (path.get(0).equalsIgnoreCase("root")) {
                        filePath = System.getProperty("user.dir");
                    } else {
                        filePath = path.get(0);
                    }

                    //Call read file method of the class to read data
                    String z = ExcelParser.readExcel(filePath, path.get(1), path.get(2));
                    stringBuilder.append(z);

                    this.result.append(stringBuilder);
                } catch (Exception e) {
                    //If error in extracting then log warning message and set res = false
                    MojoLogger.getLogger().error(e + "\nIssue in prasing Excel for Scenario Outline " + sSoName +
                            "\nExcel Tag format must be @excel=folderpath=filename.fileextension=sheetname\n" +
                            "if folderpath is root then project path is taken");
                    needExamples = true;
                }

            }

            if (needCSV) {
                StringBuilder stringBuilder = new StringBuilder();
                try {

                    //Prepare the path of excel file
                    String filePath = null;
                    if (path.get(0).equalsIgnoreCase("root")) {
                        filePath = System.getProperty("user.dir");
                    } else {
                        filePath = path.get(0);
                    }

                    //Call read file method of the class to read data
                    String z = CSVParser.readCSV(filePath, path.get(1), path.get(2));
                    stringBuilder.append(z);

                    this.result.append(stringBuilder);
                } catch (Exception e) {
                    //If error in extracting then log warning message and set res = false
                    MojoLogger.getLogger().error(e + "\nIssue in prasing CSV for Scenario Outline " + sSoName +
                            "\nExcel Tag format must be @csv=folderpath=filename.csv=delimiter\n" +
                            "if folderpath is root then project path is taken");
                    needExamples = true;
                }
            }

            if (needPlain) {
                StringBuilder stringBuilder = new StringBuilder();
                try {

                    //Prepare the path of excel file
                    String filePath = null;
                    if (path.get(0).equalsIgnoreCase("root")) {
                        filePath = System.getProperty("user.dir");
                    } else {
                        filePath = path.get(0);
                    }

                    //Call read file method of the class to read data
                    String z = PlainParser.readPlain(filePath, path.get(1));
                    stringBuilder.append(z);

                    this.result.append(stringBuilder);
                } catch (Exception e) {
                    //If error in extracting then log warning message and set res = false
                    MojoLogger.getLogger().error(e + "\nIssue in prasing Txt for Scenario Outline " + sSoName +
                            "\nPlain Tag format must be @plain=folderpath=filename.txt\n" +
                            "if folderpath is root then project path is taken");
                    needExamples = true;
                }
            }

            if (needExamples) {
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
