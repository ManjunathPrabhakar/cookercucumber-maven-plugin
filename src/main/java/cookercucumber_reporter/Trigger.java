package cookercucumber_reporter;

import com.google.gson.Gson;
import common.fileFactory.FileUtility;
import cookercucumber_reporter.json_pojos.FeaturePOJO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 19/09/2020
 * @project cooker-cucumber-reporter
 */
public class Trigger {

    public static List<String> start(String jsonPath) throws Exception {
        List<FeaturePOJO> total = new ArrayList<>();
        Gson gson = new Gson();

        FileUtility featurecontent = new FileUtility(jsonPath);
        //Get all *.feature files from existing feature files directory
        List<File> featurefiles = featurecontent.getFiles(".json");

        if (featurefiles.size() > 0) {
            for (File jsonFile : featurefiles) {
                String str = FileUtility.readAndGetFileContent(jsonFile.getPath());
                FeaturePOJO[] featurePOJOS = gson.fromJson(str, FeaturePOJO[].class);
                total.addAll(Arrays.asList(featurePOJOS));
            }
        }

        return Reporter.generateReport(total);

    }

}
