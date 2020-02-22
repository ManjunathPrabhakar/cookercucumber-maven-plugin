package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.Tag;

public class TagUtils implements TagI {

    Tag tag = null;
    StringBuilder result = new StringBuilder();

    public TagUtils(Tag pTag) {
        this.tag = pTag;
    }

    public String getTagsData() {

        try {
            String sTagName = this.tag.getName();

            this.result.append(sTagName);
            this.result.append(System.getProperty("line.separator"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(this.result);
    }


}
