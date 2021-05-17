package cookercucumber_parser;

import common.fileFactory.FileUtility;
import cookerMojoTrigger.MojoLogger;
import cookercucumber_parser.exceptionsFactory.CookerPluginException;
import cookercucumber_parser.featureParserFactory.*;
import cookercucumber_parser.fileGenerationFactory.GenMain;
import cookercucumber_parser.kitchenShelf.Ingredients;
import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.ast.*;

import java.io.File;
import java.util.List;


/**
 * This Class is used to trigger the Cooker Cucumber Maven Plugin
 */
public class CookIt {

    //GET ALL NEEDED VALUES FROM INGREDIENTS FROM Ingredients Class
    ///////////////////////////////////////////////////////////////////////////////////////////
    private String existingFeatureFilePath = null;
    private String listUserTags = null;
    private CookerTagExpressionParser cookerTagExpressionParser;

    private int count = 0;

    /**
     * Constructor - Intilizes ExitingFeatureFilePath and Gets the Tag(s) that user want to run
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     */
    public CookIt() {
        //Initilize all Info needed from Ingredients Class
        existingFeatureFilePath = Ingredients.getfExiFullPath();
        listUserTags = Ingredients.getUserTag();
        cookerTagExpressionParser = new CookerTagExpressionParser();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Main Method that Parses and perform what the Plugin has to do
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @throws CookerPluginException If Any
     */
    public void cook() throws CookerPluginException {

        try {
            //Initilize FileUtils Class with exiting feature files directory
            FileUtility featurecontent = new FileUtility(existingFeatureFilePath);
            //Get all *.feature files from existing feature files directory
            List<File> featurefiles = featurecontent.getFiles(Ext.FEATURE.extension);

            //If Feature Files are present
            if (featurefiles.size() > 0) {

                //Initilize File Counter to 0
                count = 0;

                //Delete Old and Create new Generated Test Runners & Generated Feature Files Directory
                GenMain.deleteAndCreateDir();

                //For each feature file
                for (File feature : featurefiles) {

                    //Initilize Background Utils Object
                    BackgroundUtils backgroundUtils = null;
                    //String to Hold background Data
                    String BG = null;

                    //Get the Content of Feature File
                    String featureFileContent = FileUtility.readAndGetFileContent(feature.getPath());

                    //Check if Feature File is Empty
                    if (featureFileContent.equals("")) {
                        //Display the feature file is empty and go to next Feature File
                        MojoLogger.getLogger().warn(feature.getName() + " is empty!");
                        continue;
                    }

                    //Show parsing Feature File
                    MojoLogger.getLogger().info("parsing : " + feature.getName());

                    //Create new object of Gherkin Document Parser
                    Parser<GherkinDocument> gherkinDocumentParser = new Parser<>(new AstBuilder());
                    GherkinDocument gherkinDocument = gherkinDocumentParser.parse(featureFileContent);

                    //Get Parsed Gherkin Document as a Feature File
                    Feature featurefile = gherkinDocument.getFeature();

                    //Parse Feature file
                    FeatureUtils featureUtils = new FeatureUtils(featurefile);

                    //Check if the Feature Level Tags has the Tags specified by the user

                    if (cookerTagExpressionParser.tagParser(listUserTags, featureUtils.getFeatureTagsList())) {
                        //If Feature Level tags contains User Tags, Get all the contents of feature file
                        String toFile = featureUtils.getFeatureData();
                        //Create a Feature File and Its Test Runner
                        GenMain.genFiles(featureUtils.getsFeatureName(), toFile);
                        count++;
                    } else
                    //If the Feature Level Tags doesn't have the tags specified by user,
                    //then parse the feature file for Scenario/ScenarioOutline/Background
                    {
                        //Get all the scenariodefinations from the feature files as list
                        List<ScenarioDefinition> featurescenarios = featurefile.getChildren();

                        //For each scenariodefinations in the feature file
                        for (ScenarioDefinition sd : featurescenarios) {
                            //Initilize String Builder to Store the sceanrio/scenariooutline/background to create Feature File
                            StringBuilder toFile = new StringBuilder();

                            //If the scenariodefination is a background
                            if (sd instanceof Background) {
                                //Initilize BackgroundUtils with Background Object
                                backgroundUtils = new BackgroundUtils((Background) sd);
                                //Parse it and get the contents of background and Store Background in a string
                                BG = backgroundUtils.getBackgroundData();
                            }

                            //if the scenariodefinations is a Scenario
                            if (sd instanceof Scenario) {
                                //Initilize ScenarioUtils with Scenario Object
                                ScenarioUtils scenarioUtils = new ScenarioUtils((Scenario) sd);

                                //Check if the Scenario Level Tags has the Tags specified by the user
                                if (cookerTagExpressionParser.tagParser(listUserTags, scenarioUtils.getScenarioTagsList())) {

                                    //If yes, then we have got the scenario, now to create a file
                                    //get Feature tags, name & keyword and add to String Builder
                                    toFile.append(featureUtils.getFeatureTags());
                                    toFile.append(featureUtils.getsFeatureKeyword()).append(": ").append(featureUtils.getsFeatureName());
                                    toFile.append(System.getProperty("line.separator"));
                                    toFile.append(featureUtils.getSfeatureDescription());

                                    //if the current feature file had background too then,
                                    // append that Background and Scenario to String Builder
                                    //else, append only scenario
                                    if (backgroundUtils == null) {
                                        toFile.append(scenarioUtils.getScenarioData());
                                    } else {
                                        toFile.append(BG);
                                        toFile.append(scenarioUtils.getScenarioData());
                                    }
                                }
                            }

                            //if the scenariodefinations is a ScenarioOutline
                            if (sd instanceof ScenarioOutline) {
                                //Initilize ScenarioUtils with ScenarioOutline Object
                                ScenarioOutlineUtils scenarioOutlineUtils = new ScenarioOutlineUtils((ScenarioOutline) sd);

                                //Check if the ScenarioOutline Level Tags has the Tags specified by the user
                                if (cookerTagExpressionParser.tagParser(listUserTags, scenarioOutlineUtils.getScenarioOutlineTagsList())) {

                                    //If yes, then we have got the scenariooutline, now to create a file
                                    //get Feature tags, name & keyword and add to String Builder
                                    toFile.append(featureUtils.getFeatureTags());
                                    toFile.append(featureUtils.getsFeatureKeyword()).append(": ").append(featureUtils.getsFeatureName());
                                    toFile.append(System.getProperty("line.separator"));
                                    toFile.append(featureUtils.getSfeatureDescription());

                                    //if the current feature file had background too then,
                                    // append that Background and Scenario to String Builder
                                    //else, append only scenariooutline
                                    if (backgroundUtils == null) {
                                        toFile.append(scenarioOutlineUtils.getScenarioOutlineData());
                                    } else {
                                        toFile.append(BG);
                                        toFile.append(scenarioOutlineUtils.getScenarioOutlineData());
                                    }
                                }
                            }

                            //In Each iteration there will either be none/scenario/scenarioOutline stored in String Builder
                            //If ther is something in string builder then
                            if (toFile.length() != 0) {
                                //Create a Feature File and Its Test Runner
                                GenMain.genFiles(featureUtils.getsFeatureName(), String.valueOf(toFile));
                                count++;
                            }
                        }//End of ScenarioDefination For Each Loop
                    }//End of Else Part for checking ScenarioDefinations
                }//End of FaturesFiles for Each Loop
                MojoLogger.getLogger().info("Generated " + count + " Feature File(s) and Test Runner File(s) Respectively");
            }//End of If feature files > 0
        } //End of Try
        catch (Exception e) {
            e.printStackTrace();
            throw new CookerPluginException("Error in CookIt : ");

        } finally {
            MojoLogger.getLogger().info("Cooker Cucumber Maven Plugin Execution Complete");
        }
    }
}
