package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.DataTable;
import gherkin.ast.DocString;
import gherkin.ast.Node;
import gherkin.ast.Step;

public class StepsUtils implements StepI {

    private Step step = null;
    private StringBuilder result = new StringBuilder();

    public StepsUtils(Step pStep) {
        this.step = pStep;
    }

    public String getStepsData() {

        try {
            String sKeyword = this.step.getKeyword();
            String sText = this.step.getText();
            Node sStepArgs = this.step.getArgument();

            this.result.append(sKeyword).append(" ").append(sText);
            this.result.append(System.getProperty("line.separator"));


            if (sStepArgs instanceof DocString) {
                DocString docString = ((DocString) sStepArgs);

                DocStringUtils docStringUtils = new DocStringUtils(docString);

                String docStringData = docStringUtils.getDocStringData();
                this.result.append(docStringData);
            }

            if (sStepArgs instanceof DataTable) {
                DataTable dataTable = ((DataTable) sStepArgs);

                DataTableUtils dataTableUtils = new DataTableUtils(dataTable);

                String dataTableData = dataTableUtils.getDataTableData();
                this.result.append(dataTableData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(this.result);

    }


}
