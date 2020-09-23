package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.Tag;

public class TagUtils implements TagI {

    /*
       TAGS CAN BE FOUND FOR FEATURE / SCENARIO / SCENARIO OUTLINE
     */

    Tag tag = null;
    StringBuilder result = new StringBuilder();

    /**
     * Constructor used to intilize the Tag Object
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param pTag Tag Object
     */
    public TagUtils(Tag pTag) {
        this.tag = pTag;
    }

    /**
     * Read the Tag Object and Parse it and get it's Content in as String
     *  <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Tag Object
     */
    public String getTagsData() {

        try {
            String sTagName = this.tag.getName(); //Get the Name of the Tag

            this.result.append(sTagName); //Append Tag Name
            this.result.append(System.getProperty("line.separator")); //Append New Line
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* RETURN THE TAG NAME */
        return String.valueOf(this.result);
    }


}
