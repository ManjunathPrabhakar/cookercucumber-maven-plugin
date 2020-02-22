package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.DocString;

public class DocStringUtils implements DocStringI {

    private DocString docString = null;
    private StringBuilder result = new StringBuilder();

    public DocStringUtils(DocString pDocString) {
        this.docString = pDocString;
    }

    public String getDocStringData() {

        try {
            String docStringContent = docString.getContent();
            String docStringContentType = docString.getContentType();

            String sCover = "\"\"\"";
            String docStringData = sCover + "\n" + docStringContent + "\n" + sCover;

            this.result.append(docStringData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(this.result);
    }
}
