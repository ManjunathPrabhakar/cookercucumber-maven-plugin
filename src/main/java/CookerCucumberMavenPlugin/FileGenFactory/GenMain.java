package CookerCucumberMavenPlugin.FileGenFactory;

import CookerCucumberMavenPlugin.Kitchen.Ingredients;
import CookerCucumberMavenPlugin.FileFactory.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static CookerCucumberMavenPlugin.FileGenFactory.FeatureFileGenerator.genFeatureFile;
import static CookerCucumberMavenPlugin.FileGenFactory.TestRunnerGenerator.genTestRunner;

/**
 * This Class is used to Generate Test Runners and Feature Files in the Specified Directory
 * It Contains Static Methods
 */
public class GenMain {

    ////////////////////////////////////////////////////////////////////////////////
    //GetAll Needed Values from Ingredients Class
    private static String GenFeatureFilesFullPath = Ingredients.getFgFullGenPath();
    private static String StepDefPackageName = Ingredients.getStepDefPackage();
    private static Map<String, String> CustomPlaceHolders = Ingredients.getCustomPlaceHolders();
    private static String GenTestRunnersFullPath = Ingredients.getTrFullGenPath();
    ////////////////////////////////////////////////////////////////////////////////

    /**
     * This Method is used to generate TestRunner Files and Feature Files in Generated.TestRunners & Generated.FeatureFiles Directory
     *
     * @param pFileName       //Feature Name Only
     * @param pFeatureContent //Feature Content
     */
    public static void genFiles(String pFileName, String pFeatureContent) {

        //If Feature Name has any symbols, remove it
        pFileName = pFileName.replaceAll("[^A-Za-z0-9\\s]", "");

        //if the first letter of feature name is a number, then replace it with 'F'
        char c = pFileName.charAt(0);
        if (c >= '0' && c <= '9') {
            pFileName = "F" + pFileName.substring(pFileName.length() - 1);
        }

        //Replace all Spaces with UnderScore
        pFileName = pFileName.replace(" ", "_");

        //Store Feature Name in another String
        String feature = pFileName;
        //Get a Random Number
        String randNum = RandomNumberGenerator.genRandomNumber();

        //Create a File Name with Feature underscore and Random number
        String fileName = feature + "_" + randNum;
        //Create a Full Feature File Path
        String fullFeaturePath = GenFeatureFilesFullPath + fileName + ".feature";

        //Initlize deafult placeholders for Test Runners
        //Required : featureFilePath, StepDefs Package,
        Map<String, String> defaultPlaceholder = new HashMap<String, String>();
        defaultPlaceholder.put("featurefilepath", fullFeaturePath);
        defaultPlaceholder.put("stepdefpackage", StepDefPackageName); //Step Defination Package Name
        defaultPlaceholder.put("fileName", fileName); //fileName needed for creating Test Runner class name

        //Get Custom Place Holders from Ingredeints(Maven Plugin) for Test Runners
        Map<String, String> customPlaceholder = CustomPlaceHolders;

        //Call Generate Test Runner Method to Create Test Runners
        genTestRunner(defaultPlaceholder, customPlaceholder, GenTestRunnersFullPath + fileName);

        //Call Generate Feature Files Method to Create Feature Files
        genFeatureFile(pFeatureContent, GenFeatureFilesFullPath + fileName);


    }

    /**
     * This Method is used to perfrom deletion and creation of Generated.TestRunners & Generated.FeatureFiles Directory
     * It uses static methods from FileUtils Class
     */
    public static void deleteAndCreateDir() {
        //Delete Old Generated.FeatureFiles Directory
        FileUtils.deleteRunnerandFeatureDir(new File(GenFeatureFilesFullPath));
        //Delete Old Generated.TestRunners Directory
        FileUtils.deleteRunnerandFeatureDir(new File(GenTestRunnersFullPath));
        //Create New Generated.FeatureFiles Directory
        FileUtils.createRunnerandFeatureDir(new File(GenFeatureFilesFullPath));
        //Create New Generated.TestRunners Directory
        FileUtils.createRunnerandFeatureDir(new File(GenTestRunnersFullPath));
    }
}
