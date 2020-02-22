package CookerCucumberMavenPlugin;

import CookerCucumberMavenPlugin.ExceptionsFactory.CookerPluginException;
import CookerCucumberMavenPlugin.FeatureFactory.BackgroundUtils;
import CookerCucumberMavenPlugin.FeatureFactory.FeatureUtils;
import CookerCucumberMavenPlugin.FeatureFactory.ScenarioOutlineUtils;
import CookerCucumberMavenPlugin.FeatureFactory.ScenarioUtils;
import CookerCucumberMavenPlugin.FileFactory.FileUtils;
import CookerCucumberMavenPlugin.FileGenFactory.GenMain;
import CookerCucumberMavenPlugin.Kitchen.Ingredients;
import cookerplugin.MojoLogger;
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
    private String ExistingFeatureFilePath = null;
    private List<String> listUserTags = null;

    public CookIt() {
        //Initilize all Info needed from Ingredients Class
        ExistingFeatureFilePath = Ingredients.getfExiFullPath();
        listUserTags = Ingredients.getAllTagsList();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    public void cook() throws CookerPluginException {

        try {
            //Initilize FileUtils Class with exiting feature files directory
            FileUtils featurecontent = new FileUtils(ExistingFeatureFilePath);
            //Get all *.feature files from existing feature files directory
            List<File> featurefiles = featurecontent.getFiles(".feature");


            //If Feature Files are present
            if (featurefiles.size() > 0) {

                //Delete Old and Create new Generated Test Runners & Generated Feature Files Directory
                GenMain.deleteAndCreateDir();

                //For each feature file
                for (File feature : featurefiles) {

                    //Initilize Background Utils Object
                    BackgroundUtils backgroundUtils = null;
                    //String to Hold background Data
                    String BG = null;

                    //Get the Content of Feature File
                    String featureFileContent = FileUtils.readAndGetFileContent(feature.getPath());

                    //Check if Feature File is Empty
                    if (featureFileContent.equals("")) {
                        //Display the feature file is empty and go to next Feature File
                        MojoLogger.getLogger().warn(feature.getName() + " is empty!");
                        continue;
                    }

                    //Show parsing Feature File
                    MojoLogger.getLogger().info("parsing " + feature.getName());

                    //Create new object of Gherkin Document Parser
                    Parser<GherkinDocument> gherkinDocumentParser = new Parser(new AstBuilder());
                    GherkinDocument gherkinDocument = gherkinDocumentParser.parse(featureFileContent);

                    //Get Parsed Gherkin Document as a Feature File
                    Feature featurefile = gherkinDocument.getFeature();

                    //Parse Feature file
                    FeatureUtils featureUtils = new FeatureUtils(featurefile);

                    //Check if the Feature Level Tags has the Tags specified by the user
                    if (featureUtils.getFeatureTagsList().containsAll(listUserTags)) {
                        //If Feature Level tags contains User Tags, Get all the contents of feature file
                        String toFile = featureUtils.getFeatureData();
                        //Create a Feature File and Its Test Runner
                        GenMain.genFiles(featureUtils.getsFeatureName(), toFile);
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
                                if (scenarioUtils.getScenarioTagsList().containsAll(listUserTags)) {

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
                                if (scenarioOutlineUtils.getScenarioOutlineTagsList().containsAll(listUserTags)) {

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
                            }
                        }//End of ScenarioDefination For Each Loop
                    }//End of Else Part for checking ScenarioDefinations
                }//End of FaturesFiles for Each Loop
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
