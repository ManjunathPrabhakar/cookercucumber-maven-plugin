package cookercucumber_parser.featureParserFactory;

public interface FeatureDocument {

    String getFeatureData() throws Exception;
}

interface TagI {
    String getTagsData() throws Exception;
}

interface BackgroundI {
    String getBackgroundData() throws Exception;
}

interface ScenarioI {
    String getScenarioData() throws Exception;
}

interface ScenarioOutlineI {
    String getScenarioOutlineData() throws Exception;
}

interface DatatableI {
    String getDataTableData() throws Exception;
}

interface DocStringI {
    String getDocStringData() throws Exception;
}

interface StepI {
    String getStepsData() throws Exception;
}

interface ExampleI {
    String getExamplesData() throws Exception;
}






