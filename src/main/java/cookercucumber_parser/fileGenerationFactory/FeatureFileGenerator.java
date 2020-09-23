package cookercucumber_parser.fileGenerationFactory;

import common.fileFactory.FileUtility;

public class FeatureFileGenerator {

    //Feature File Extension
    private static final String FF_EXTENSION = ".feature";

    /**
     * static method used to generate Feature Files. gets the content from feature file and feature file name
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param Content         //Content for Feature File
     * @param FeatureFileName //Full Path of Feature File including file name
     */
    public static void genFeatureFile(String Content, String FeatureFileName) {
        //Uses static method from fileutils class to create a feature file
        FileUtility.writeAndCreateFile(Content, FeatureFileName + FF_EXTENSION);
    }

}
