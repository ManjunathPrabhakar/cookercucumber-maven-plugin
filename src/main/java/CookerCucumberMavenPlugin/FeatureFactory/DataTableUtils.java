package CookerCucumberMavenPlugin.FeatureFactory;

import gherkin.ast.DataTable;
import gherkin.ast.Location;
import gherkin.ast.TableCell;
import gherkin.ast.TableRow;

import java.util.List;

public class DataTableUtils implements DatatableI {

    private DataTable dataTable = null;
    private StringBuilder dtResult = new StringBuilder();

    public DataTableUtils(DataTable pdataTable) {
        this.dataTable = pdataTable;
    }

    public String getDataTableData() {

        try {
            Location location = dataTable.getLocation();
            int dLineNum = location.getLine();
            int dColNum = location.getColumn();


            List<TableRow> listrows = this.dataTable.getRows();

            for (TableRow row : listrows) {
                List<TableCell> cells = row.getCells();
                this.dtResult.append("|");
                for (TableCell cell : cells) {
                    String sCellVal = cell.getValue();
                    this.dtResult.append(sCellVal).append("|");

                }
                this.dtResult.append(System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(this.dtResult);
    }


}
