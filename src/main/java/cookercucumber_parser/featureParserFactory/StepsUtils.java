package cookercucumber_parser.featureParserFactory;

import gherkin.ast.DataTable;
import gherkin.ast.DocString;
import gherkin.ast.Node;
import gherkin.ast.Step;

public class StepsUtils implements StepI {

    /*

    STEPS CAN BE FOUND UNDER BACKGROUND / SCENARIO / SCENARIO OUTLINE
    EACH STEP CAN HAVE DOCSTRING OR DATATABLE

     */

    private Step step = null;
    private StringBuilder result = new StringBuilder();

    /**
     * Constructor used to intilize the Step Object
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @param pStep Step Object
     */
    public StepsUtils(Step pStep) {
        this.step = pStep;
    }

    /**
     * Read the Step Object and Parse it and get it's Content in as String
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return String Content of Step Object
     */
    public String getStepsData() {

        try {
            String sKeyword = this.step.getKeyword(); //Get StepKeyword (Gherkin Keyword)
            String sText = this.step.getText(); // Get Step Data
            Node sStepArgs = this.step.getArgument(); //Get the Step Argument

            this.result.append(sKeyword).append(" ").append(sText); //Append StepKeyword Step Data
            this.result.append(System.getProperty("line.separator")); // Append New Line
            /*
            If the Step Argument is an instance of DocString
             */
            if (sStepArgs instanceof DocString) {
                //Convert Step Argument to DocString Object
                DocString docString = ((DocString) sStepArgs);

                //Create an Object of DocStringUtils using above docstring Object
                DocStringUtils docStringUtils = new DocStringUtils(docString);

                //Get the DocString as String
                String docStringData = docStringUtils.getDocStringData();

                this.result.append(docStringData); //Append the DocString Data
            }

            /*
            If the Step Argument is an instance of Datatable
             */
            if (sStepArgs instanceof DataTable) {
                //Convert Step Argument to Datatable Object
                DataTable dataTable = ((DataTable) sStepArgs);

                //Create an Object of DataTableUtils using above docstring Object
                DataTableUtils dataTableUtils = new DataTableUtils(dataTable);

                //Get the DataTable as String
                String dataTableData = dataTableUtils.getDataTableData();

                this.result.append(dataTableData); //Append Datatable Data
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* RETURN THE STEP DATA */
        return String.valueOf(this.result);

    }


}
