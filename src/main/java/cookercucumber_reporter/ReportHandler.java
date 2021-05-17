package cookercucumber_reporter;

import com.google.gson.Gson;
import common.fileFactory.FileUtility;
import cookercucumber_reporter.json_pojos.FeaturePOJO;

import java.io.File;
import java.util.*;

public class ReportHandler {


    public static List<FeaturePOJO> getJSONsToList(String jsonspath) throws Exception {
        List<FeaturePOJO> features = new ArrayList<FeaturePOJO>();
        Gson gson = new Gson();

        FileUtility featurecontent = new FileUtility(jsonspath);
        //Get all *.feature files from existing feature files directory
        List<File> featurefiles = featurecontent.getFiles(".json");

        if (featurefiles.size() > 0) {
            for (File jsonFile : featurefiles) {
                String str = FileUtility.readAndGetFileContent(jsonFile.getPath());
                FeaturePOJO[] featurePOJOS = gson.fromJson(str, FeaturePOJO[].class);
                features.addAll(Arrays.asList(featurePOJOS));
            }
        }

        return features;
    }

    public static List<FeaturePOJO> combineMultipleScenariosOfSameFeature(List<FeaturePOJO> featuresList) throws Exception {
        List<FeaturePOJO> finalFeatures = new ArrayList<FeaturePOJO>();

        //Combine Different Scenarios of Same Feature name Jsons as One
        Map<String, FeaturePOJO> featuresMap = new HashMap<>();
        for (FeaturePOJO feature : featuresList) {
            //If Map doesn't have the Feature Name (Key)
            if (featuresMap.get(feature.getName()) == null)
                //Add key as Feature Name & Value as The Feature Itself
                featuresMap.put(feature.getName(), feature);
            else
                //Get the Map with Feature Name (Key),
                // Get Its feature's elements and add the elements of same feature file
                featuresMap.get(feature.getName()).getElements().addAll(feature.getElements());
        }

        finalFeatures = new ArrayList<>(featuresMap.values());

        return finalFeatures;
    }


}
