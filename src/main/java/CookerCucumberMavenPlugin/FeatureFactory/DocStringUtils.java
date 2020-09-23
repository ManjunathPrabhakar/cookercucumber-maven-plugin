package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.DocString;

public class DocStringUtils implements DocStringI {

    private DocString docString = null;
    private StringBuilder result = new StringBuilder();

    public DocStringUtils(DocString pDocString) {
        this.docString = pDocString;
    }

    /**
     * Read the Docstring Object and Parse it and get it's Content in as String
     *  <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Docstring Object
     */
    public String getDocStringData() {

        try {
            String docStringContent = docString.getContent();
            String docStringContentType = docString.getContentType();


            String sCover = "\"\"\"";
            String docStringData = sCover + "\n" + docStringContent + "\n" + sCover;

            this.result.append(docStringData);
            this.result.append(System.getProperty("line.separator")); // Append New Line
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(this.result);
    }
}
