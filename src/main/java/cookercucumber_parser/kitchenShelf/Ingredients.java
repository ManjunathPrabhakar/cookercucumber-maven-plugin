package cookercucumber_parser.kitchenShelf;

import cookerMojoTrigger.MojoLogger;

import java.util.*;

public class Ingredients {


    private static Map<String, String> custommap = new HashMap<String, String>();

    /* WHICH TAG SHOULD BE USED TO GENERATE TEST RUNNERS AND FEATURE FILES */
    //NEEDED TAG
    private static String USER_TAG;

    /* WHERE IS PROJECT STORED */
    //PROJECT HOME
    private static String HOME_DIR = System.getProperty("user.dir");

    /* WHERE IS TEST RUNNER TEMPLATE STORED */
    //TEST RUNNER TEMPLATE
    private static String TR_FULL_TEMP_PATH;

    /* WHERE IS EXISTING FEATURE FILES STORED */
    //EXISTING FEATURE FILES
    private static String F_EXI_FULL_PATH;

    /* WHERE IS THE STEPDEFINATIONS */
    //STEP DEFINATIONS PACKAGE
    private static String STEP_DEF_PACKAGE;

    /* WHERE TO GENERATE AND STORE TEST RUNNERs */
    //TEST RUN GENERATED DIR
    private static String TR_FULL_GEN_PATH;

    /* WHERE TO GENERATE AND STORE FEATURE FILES */
    // FEATURE FILES GENERATED DIR
    private static String FG_FULL_GEN_PATH;


    ///////////// FEATURE FILES GENERATOR FULL PATH GETTER & SETTERS /////////////////////////////

    public static String getFgFullGenPath() {
        return FG_FULL_GEN_PATH;
    }

    public static void setFgFullGenPath(String fgFullGenPath) {
        FG_FULL_GEN_PATH = fgFullGenPath;
    }

    ///////////// STEP DEFINATIONS PACKAGE GETTER & SETTERS /////////////////////////////

    public static String getStepDefPackage() {
        return STEP_DEF_PACKAGE;
    }

    public static void setStepDefPackage(String stepDefPackage) {
        STEP_DEF_PACKAGE = stepDefPackage;
    }

    ///////////// GET USER TAGS GETTER & SETTERS /////////////////////////////

    public static String getUserTag() {
        return USER_TAG;
    }

    public static void setUserTag(String userTag) {
        USER_TAG = userTag;
    }

    public static List<String> getAllTagsList() {
        List<String> ls = new ArrayList<String>();
        String tags = getUserTag();
        if (!(tags.trim().length() > 0)) {
            MojoLogger.getLogger().error("Please Specify Tag Names, It Might be blank");
            System.exit(0);
        }
        String[] array = tags.split(",");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        ls = Arrays.asList(array);
        return ls;
    }

    ///////////// GET HOME DIRECTORY GETTER & SETTERS /////////////////////////////

    public static String getHomeDir() {
        return HOME_DIR;
    }

    public static void setHomeDir(String homeDir) {
        HOME_DIR = homeDir;
    }

    ///////////// TEST RUNNER TEMPLATE FULL PATH GETTER & SETTERS /////////////////////////////

    //USED IN cookerMOJO.java and TestRunnerGenerator.java
    public static String getTrFullTempPath() {
        return TR_FULL_TEMP_PATH;
    }

    public static void setTrFullTempPath(String trFullTempPath) {
        TR_FULL_TEMP_PATH = trFullTempPath;
    }

    ///////////// EXISTING FEATURE FILES FULL PATH GETTER & SETTERS /////////////////////////////

    public static String getfExiFullPath() {
        return F_EXI_FULL_PATH;
    }

    public static void setfExiFullPath(String fExiFullPath) {
        F_EXI_FULL_PATH = fExiFullPath;
    }

    ///////////// TEST RUNNER GENERATOR FULL PATH GETTER & SETTERS /////////////////////////////

    public static String getTrFullGenPath() {
        return TR_FULL_GEN_PATH;
    }

    public static void setTrFullGenPath(String trFullGenPath) {
        TR_FULL_GEN_PATH = trFullGenPath;
    }

    ///////////// CUSTOM PLACEHOLDERS MAP GETTER & SETTERS /////////////////////////////

    public static Map<String, String> getCustomPlaceHolders() {
        return custommap;
    }

    /* CUSTOM PLACEHOLDER FOR TEST RUNNER */
    public static void setCustomPlaceHolders(Map<String, String> pMavenCustomPlaceHolder) {
        //Map<String, String> custommap = new HashMap<String, String>();
        custommap.put("[COOKER:PLUGIN_OWNER]", "Manjunath Prabhakar");
        custommap.put("[COOKER:TIMESTAMP]", "" + new Date());

        if (!pMavenCustomPlaceHolder.isEmpty()) {
            for (Map.Entry<String, String> entry : pMavenCustomPlaceHolder.entrySet()) {
                final String key = "[COOKER:" + (entry.getKey()).toUpperCase() + "]";
                final String val = (entry.getValue());
                custommap.put(key, val);
            }
        }
    }
}
