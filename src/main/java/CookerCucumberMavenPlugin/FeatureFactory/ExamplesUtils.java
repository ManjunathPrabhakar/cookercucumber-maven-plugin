package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.Examples;
import gherkin.ast.TableCell;
import gherkin.ast.TableRow;

import java.util.List;

public class ExamplesUtils implements ExampleI {

    private Examples examples = null;
    private StringBuilder result = new StringBuilder();
    private final String EXAMPLES_KEYWORD = "Examples:";

    public ExamplesUtils(Examples pExamples) {
        this.examples = pExamples;
    }

    /**
     * Read the Examples Object and Parse it and get it's Content in as String
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Examples Object
     */
    public String getExamplesData() {
        try {
//            //Examples Tags
//            for (Tag tag : examples.getTags()) {
//                TagUtils tagUtils = new TagUtils(tag);
//                String tagData = tagUtils.getTagsData();
//                this.result.append(tagData);
//            }

            this.result.append(EXAMPLES_KEYWORD);
            this.result.append(System.getProperty("line.separator"));


            //Map<String, List<String>> exampleMap = new LinkedHashMap<String, List<String>>();

            List<TableCell> headerCells = this.examples.getTableHeader().getCells();
            this.result.append("|");
            for (TableCell headerCell : headerCells) {
                //exampleMap.put("<" + headerCell.getValue() + ">", new ArrayList<String>());
                this.result.append(headerCell.getValue()).append("|");
            }
            //Object[] columnKeys = exampleMap.keySet().toArray();
            this.result.append(System.getProperty("line.separator"));

            List<TableRow> tableBody = this.examples.getTableBody();
            for (TableRow tableRow : tableBody) {
                List<TableCell> cells = tableRow.getCells();
                this.result.append("|");
                for (TableCell tableCell : cells) {
                    // String columnKey = (String) columnKeys[i];
                    // List<String> values = exampleMap.get(columnKey);
                    //values.add(cells.get(i).getValue());

                    String cell = tableCell.getValue();
                    this.result.append(cell).append("|");
                }
                this.result.append(System.getProperty("line.separator"));
            }

            //sb.append(exampleMap);
            //System.out.println(exampleMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(this.result);
    }
}
